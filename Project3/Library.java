import java.util.ArrayList;

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
}
