import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.io.FileNotFoundException;
/**
 * CS 121 Project 2: Jukebox Hero
 *
 * This program manages a user's songs given by user input to create a 
 * simplified playlist that then prints to the screen.
 * 
 * @author [Cesar Raymundo]
 */


public class JukeboxHero {
	static Scanner reader = new Scanner(System.in);
	public static void main(String[] args)
	{

		//Strings for the menu prompt
		final String BORDER = "*************************";
		final String TITLE = "*      Program Menu     *";
		final String LOAD = "(L)oad catalog";
		final String SEARCH = "(S)earch catalog";
		final String ANALYZE = "(A)nalyse catalog";
		final String PRINT = "(P)rint catalog";
		final String QUIT = "(Q)uit";
		final String PROMPT = "Please enter a command (press 'm' for Menu):";
		//ArrayList for songList
		ArrayList<Song> songList = new ArrayList<Song>();
		//Variables
		int songCount;
		//Menu Prompt
		System.out.println(BORDER);
		System.out.println(TITLE);
		System.out.println(BORDER);
		System.out.println(LOAD);
		System.out.println(SEARCH);
		System.out.println(ANALYZE);
		System.out.println(PRINT);
		System.out.println(QUIT);
		System.out.println();
//Doing the Switch Statement 
		boolean programRun = true;
		//Having the prompt to appear after each switch statement
		while(programRun == true)
		{
			System.out.print(PROMPT);
			String input=reader.nextLine();


			switch(input.toLowerCase()) {

			case"l":
				System.out.println("Load Catalog...");
				System.out.println("Please Enter Filename: ");
				String userInput=reader.nextLine();
				File catalogFile = new File(userInput);

				//Reads file and puts it an ArrayList
				if(catalogFile.exists() && catalogFile.isFile()) {			
					try {
						songCount = 0;
						songList.clear();
						Scanner fileIterator = new Scanner(catalogFile);

						while (fileIterator.hasNext()) 
						{
							String line = fileIterator.nextLine();
							Scanner tokenize = new Scanner(line);
							tokenize.useDelimiter(","); 
							String artist = tokenize.next();
							String album = tokenize.next();
							String title = tokenize.next();
							int sec = Integer.parseInt(tokenize.next());
							Song song0 = new Song(title,artist,album,sec);
							songList.add(song0);
							songCount++;

							while (tokenize.hasNextLine()) {
								String token=tokenize.next();
								System.out.println(token);	
								fileIterator.close();
								tokenize.close();
							}


						}
						
						//Prints out the size of the ArrayList
						System.out.print("Sucessfully loaded "+ (songList.size())+ " songs!");

					}
					catch (FileNotFoundException e) {
						System.out.println("Unable to open file: " + catalogFile);
					}


				}
				else
				{
					System.out.println("Unable to open file:"+catalogFile);
				}
				System.out.println();
				break;
			case"s":
				System.out.println("Search catalog...");
				System.out.println("Please enter the search query");
				String userIn = reader.nextLine();
				ArrayList<Song> searchResults = new ArrayList<Song>();
				searchResults.clear();
				//Goes through songList ArrayList and creates another ArrayList called searchResults
				for(Song x: songList) {
					String title = x.getTitle().toLowerCase();
					if(title.contains(userIn)){
						searchResults.add(x);
					}
				}
				//Getting the number size of the ArrayList and printing it to the console.
				int occurances = searchResults.size();
				System.out.println("Found " + occurances + " matches");
				System.out.println("-------------------------");
				for (Song match : searchResults) {
					System.out.println(match.toString());

				}
				break;
			case"a":
				ArrayList<String> artistList = new ArrayList<String>(); 
				ArrayList<String> albumList = new ArrayList<String>();
				
				int playTimeCount = 0;
				for(Song a:songList) {
					String album = a.getAlbum();
					String artist = a.getArtist();
					int playCount = a.getPlayTime();
					//Adds album and artist to an ArrayList
					if(albumList.contains(album)==false) 
					{
					albumList.add(album);	
					}
					if(artistList.contains(artist)==false)
					{
						artistList.add(artist);
					}
					playTimeCount += playCount;
				}
				//Gets the size of the ArrayList and prints them to the console
				int artistCount = artistList.size();
				int albumCount = albumList.size();
				System.out.println("Number of Artists: "+ artistCount +" ");
				System.out.println("Number of Albums: "+ albumCount +" ");
				System.out.println("Number of Songs: "+ songList.size() +" ");
				System.out.println("Catalog Playtime: "+ playTimeCount +" ");
				
				System.out.println();
				break;
			case"p":
				System.out.println("Song list contains "+ songList.size()+" songs...");
				System.out.println("------------------------");
				//Prints out the file chosen by the user
				for(Song c: songList) {
					System.out.println(c);
				}

				break;
			case"q":
				System.out.print("Goodbye!");
				//Stops java file from running
				programRun = false;
				break;
			case"m":
				System.out.println(BORDER);
				System.out.println(TITLE);
				System.out.println(BORDER);
				System.out.println(LOAD);
				System.out.println(SEARCH);
				System.out.println(ANALYZE);
				System.out.println(PRINT);
				System.out.println(QUIT);
				System.out.println();
				
				break;
			default:
				System.out.print("Invalid Selection!");
				break;
			}	
		}
		reader.close();
	}

}












