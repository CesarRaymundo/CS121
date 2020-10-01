import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library implements LibraryInterface {

	private ArrayList<Book> bookList;

	/**
	 * Creates a new library instance
	 */
	public Library() {
		this.bookList = new ArrayList<Book>();
	}

	@Override
	public ArrayList<Book> getBooks() {
		ArrayList<Book> bookCopy = new ArrayList<Book>();
		for (Book t : bookList) {
			bookCopy.add(t);
		}

		return bookCopy;
	}

	@Override
	public void addBook(Book newBook) {
		bookList.add(newBook);

	}

	@Override
	public void removeBook(int index) {
		if (index < bookList.size()) {
			bookList.remove(index);
		}

	}

	@Override
	public Book getBook(int index) {
		int arraySize = this.getBooks().size();
		if (index < arraySize) {
			Book bookCopy = this.getBooks().get(index);
			return bookCopy;

		}
		return null;
	}

	/**
	 * Goes through the bookList and adds the index to a string
	 * 
	 * @return String with all the book objects within the library instance
	 */
	public String toString() {
		String stringList = "";
		int index = 0;
		for (Book x : this.bookList) {
			String bookInfo = x.toString();
			String formattedBookInfo = "Index: " + index + "\n" + bookInfo + " \n";
			stringList += formattedBookInfo;

			index += 1;
		}
		return stringList;

	}

	@Override
	public void loadLibraryFromCSV(String csvFilename) {
		File bookFile = new File(csvFilename);

		if (bookFile.exists() && bookFile.isFile()) {
			try {
				bookList.clear();
				Scanner fileIterator = new Scanner(bookFile);

				while (fileIterator.hasNext()) 
				{
					int bookCount = 0;
					String line = fileIterator.nextLine();
					Scanner tokenize = new Scanner(line);
					tokenize.useDelimiter(","); 
					String title = tokenize.next();
					String author = tokenize.next();
					String genre= tokenize.next();
					String filePath = tokenize.next();
					Book book0 = new Book(title,author);
					book0.setGenre(genre);
					book0.setFilename(filePath);
					bookList.add(book0);
					bookCount++;
					while (tokenize.hasNextLine()) {
						String token=tokenize.next();
						System.out.println(token);	
						fileIterator.close();
						tokenize.close();
					}
				}


			}
			catch (FileNotFoundException e) {
				System.out.println("Unable to open file: " + bookFile);
			}

		}
		else
		{
			System.out.println("Unable to open file:"+bookFile);
		}
	}
}
