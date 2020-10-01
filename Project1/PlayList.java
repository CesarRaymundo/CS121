import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * CS 121 Project 1: PlayList Analyzer
 *
 * This program manages a user's songs given by user input to create a 
 * simplified playlist that then prints to the screen.
 *
 * @author Mason Vail 
 * @author [Cesar Raymundo]
 */
public class PlayList 
{

private final static String PROMPTARTIST = "Enter Artist Name: ";
private final static String PROMPTSONG = "Enter Song Name: ";
private final static String PROMPTLENGTH = "Enter Song Play Time (in mm:ss format): ";
private final static String PROMPTFILE = "Enter File Name: ";
private final static String CLOSETOFR = "Song Closest to 240 Seconds is: ";
private final static String BORDER = "===============================================================================";
private final static String TITLES = "Song Name	     Artist	         File Name		      Play Time";
static Scanner scan = new Scanner(System.in);
	public static void main(String[] args)
{
//Variables
	String artist;
	String name;
	String length;
	String fileName;

	
//input of song0 	
		System.out.print(PROMPTSONG);
			name = scan.nextLine();
		System.out.print(PROMPTARTIST);
			artist = scan.nextLine();
		System.out.print(PROMPTLENGTH);
			length = scan.nextLine();
		System.out.print(PROMPTFILE);
			fileName = scan.nextLine();
// Breaking down the play time to seconds
		int formatBreak = length.indexOf(":");
		String mintues = length.substring(0,formatBreak);
		int minsTosec = (Integer.parseInt(mintues)*60);
		String secondOfhalf = length.substring(formatBreak+1);
		int seconds = (Integer.parseInt(secondOfhalf));
		int finalSec = minsTosec+seconds;
// Making the first song
		Song song0 = new Song(name, artist,finalSec,fileName);
		System.out.println(song0);

// Second song input
		System.out.print(PROMPTSONG);
		name = scan.nextLine();
	System.out.print(PROMPTARTIST);
		artist = scan.nextLine();
	System.out.print(PROMPTLENGTH);
		length = scan.nextLine();
	System.out.print(PROMPTFILE);
		fileName = scan.nextLine();
//Converting to seconds
		int formatBreak1 = length.indexOf(":");
		String mintues1 = length.substring(0,formatBreak1);
		int minsTosec1 = (Integer.parseInt(mintues1)*60);
		String secondOfhalf1 = length.substring(formatBreak+1);
		int seconds1 = (Integer.parseInt(secondOfhalf1));
		int finalSec1 = minsTosec1+seconds1;
//Making song1
		Song song1 = new Song(name, artist,finalSec1,fileName);
		System.out.println(song1);


//Input for song2
		System.out.print(PROMPTSONG);
		name = scan.nextLine();
	System.out.print(PROMPTARTIST);
		artist = scan.nextLine();
	System.out.print(PROMPTLENGTH);
		length = scan.nextLine();
	System.out.print(PROMPTFILE);
		fileName = scan.nextLine();
//Converting to seconds
		int formatBreak2 = length.indexOf(":");
		String mintues2 = length.substring(0,formatBreak2);
		int minsTosec2 = (Integer.parseInt(mintues2)*60);
		String secondOfhalf2 = length.substring(formatBreak2+1);
		int seconds2 = (Integer.parseInt(secondOfhalf2));
		int finalSec2 = minsTosec2+seconds2;
//Creating song2
		Song song2 = new Song(name, artist,finalSec2,fileName);
		System.out.println(song2);
	
	
//Finding the average play time of all songs
		DecimalFormat avgFmt = new DecimalFormat("000.00");
		Double getAverage = ((song0.getPlayTime()+song1.getPlayTime()+song2.getPlayTime())/3.0);
		String averagePlaytime = avgFmt.format(getAverage);
//Seeing the average 
		System.out.println("Average Play Time: " +averagePlaytime);
	
		
//Finding closest to four
		int song0Total = Math.abs(song0.getPlayTime()-240);
		int song1Total = Math.abs(song1.getPlayTime()-240);
		int song2Total = Math.abs(song2.getPlayTime()-240);
	if(song0Total <= song1Total && song0Total <= song2Total)
	{
		System.out.println(CLOSETOFR + song0.getTitle());
	}
	else if(song1Total <= song0Total && song1Total <= song2Total)
	{
		System.out.println(CLOSETOFR + song1.getTitle());
	}
	else if(song2Total <= song0Total && song2Total <= song1Total)
	{
		System.out.println(CLOSETOFR + song2.getTitle());
	}
	
// Sorting the playlist
	int song0Time = song0.getPlayTime();
	int song1Time = song1.getPlayTime();
	int song2Time = song2.getPlayTime();
	System.out.println(BORDER);
	System.out.println(TITLES);
	System.out.println(BORDER);
	
	//Prints one order 
	if(song0Time<=song1Time && song0Time<=song2Time)
	{
	System.out.println(song0.toString());
	
		if(song1Time<=song2Time){
		System.out.println(song1.toString());
		System.out.println(song2.toString());
	}
		else {
			System.out.println(song1.toString());
			System.out.println(song2.toString());
		}
	}
	
	//Prints another order
	else if(song1Time<=song0Time && song1Time<=song2Time) {
		System.out.println(song1.toString());
		
		if(song0Time<=song2Time) {
			System.out.println(song0.toString());
			System.out.println(song2.toString());
		}
		else {
			System.out.println(song2.toString());
			System.out.println(song0.toString());
			}
		}
	//Prints 3rd possible order
	
	else if(song2Time<=song1Time && song2Time<=song0Time) {
		System.out.println(song2.toString());
		
		if(song1Time<=song0Time) {
			System.out.println(song1.toString());
			System.out.println(song0.toString());
		}
		else {
			System.out.println(song0.toString());
			System.out.println(song1.toString());
		}
	}
	//Prints if everything has the same play time 
	else {
		System.out.println(song0.toString());
		System.out.println(song1.toString());
		System.out.println(song2.toString());	
	}
	
	System.out.println(BORDER);
	scan.close();
	








   }
}