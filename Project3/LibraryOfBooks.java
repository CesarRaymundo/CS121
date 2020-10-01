import java.util.Scanner;

/**
 * Project 3: LibraryOfBooks
 *
 * @author [Cesar Raymundo]
 */

public class LibraryOfBooks {
	//Strings used for the menuPrompt
	final static String BORDER = "*****************************";
	final static String TITLE = "*      Library of Books     *";
	final static String PRINT = "(P)rint the library contents";
	final static String ADD = "(A)dd Book";
	final static String DELETE = "(D)elete book";
	final static String READ = "(R)ead Book";
	final static String QUIT = "(Q)uit";
	final static String PROMPT = "Please enter a command (press 'm' for Menu):";

	/**
	 * Used to display a menu to the console
	 */
	public static void menuPrompt() {
		System.out.println(BORDER);
		System.out.println(TITLE);
		System.out.println(BORDER);
		System.out.println(PRINT);
		System.out.println(ADD);
		System.out.println(DELETE);
		System.out.println(READ);
		System.out.println(QUIT);
		System.out.println();
	}

	/**
	 * Prints out the contents of the library if book object\s exist.
	 * 
	 * @param books
	 */
	public static void printContent(Library books) {
		System.out.println("View contents of the library ");
		System.out.println("------------------------");
		String bookList = books.toString();
		System.out.println(bookList);
		System.out.println();
	}

	/**
	 * With user input, method will add a book object to the library.
	 * 
	 * @param books
	 * @param input
	 */
	public static void addBook(Library books, Scanner input) {
		System.out.println("Add a book to the library..." + "\n");
		System.out.println("------------------------");
		System.out.print("Enter the title: ");
		String title = input.nextLine();
		System.out.print("Enter the author: ");
		String author = input.nextLine();
//Creating a new book with the user input given
		Book newBook = new Book(title, author);
//Setting the attributes with user input
		System.out.print("Enter the genre: ");
		String genre = input.nextLine();
		newBook.setGenre(genre);
		System.out.print("Enter the filename: ");
		String fileName = input.nextLine();
		newBook.setFilename(fileName);
		books.addBook(newBook);
		System.out.println();
	}

	/**
	 * Uses user input to delete a book if it exists in the Library
	 * 
	 * @param books
	 * @param input
	 */
	public static void deleteBook(Library books, Scanner input) {
		System.out.println("Deleting a book from the library...");
		System.out.println("------------------------");
		System.out.print("Enter the index of the book: ");
		int index = Integer.parseInt(input.nextLine());
		if (index < books.getBooks().size() && books.getBooks().size() != 0) {
			books.removeBook(index);
			System.out.println();
			System.out.println("Book at index: " + index + " is now removed from library.");
		} else {
			System.out.println(index + " is not an index in the current library.");
		}
		System.out.println();
	}

	/**
	 * Will print out the contents of the book object if index number exists in the
	 * library.
	 * 
	 * @param books
	 * @param input
	 */
	public static void readBook(Library books, Scanner input) {
		System.out.println("Read a book from the library...");
		System.out.println("------------------------");
		System.out.print("Enter the index of the book you wish to read: ");
		int index = Integer.parseInt(input.nextLine());
		if (index < books.getBooks().size() && books.getBooks().size() != 0) {
			System.out.println(books.getBook(index).getText());
		} else {
			System.out.println(index + " is not a valid index in the current library.");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		boolean programRun = true;
		// Scanner used throughout the program
		Scanner input = new Scanner(System.in);
		// Creating a new library instance
		Library books = new Library();
		// Displaying the menu
		menuPrompt();
		while (programRun == true) {
			// Having the prompt to appear after each switch statement
			System.out.print(PROMPT);
			String userInput = input.nextLine();

			switch (userInput.toLowerCase()) {
			case "p":
				printContent(books);
				break;
			case "a":
				addBook(books, input);
				break;
			case "d":
				deleteBook(books, input);
				break;
			case "r":
				readBook(books, input);
				break;
			case "q":
				System.out.print("Goodbye!");
				// Stops java file from running
				programRun = false;
				break;
			case "m":
				menuPrompt();
				break;
			default:
				System.out.print("Invalid Selection!");
				break;
			}
		}
		input.close();
	}

}
