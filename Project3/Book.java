import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Book implements BookInterface {
	private String title;
	private String author;
	private String genre;
	private String filename;

	/**
	 * Constructor for the Book object
	 * 
	 * @param title
	 * @param author
	 */
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.genre = null;
		this.filename = null;

	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getAuthor() {
		return author;
	}

	@Override
	public void setAuthor(String author) {
		this.author = author;

	}

	@Override
	public String getGenre() {
		return genre;
	}

	@Override
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String getFilename() {
		return filename;
	}

	@Override
	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public boolean isValid() {
		boolean output = false;
		if (this.getTitle() != null) {
			if (this.getAuthor() != null) {
				if (this.getGenre() != null) {
					if (this.getFilename() != null) {
						File file = new File(filename);
						if (file.exists() && file.isFile()) {
							output = true;
						}
					}
				}
			}
		} else {
			output = false;
		}
		return output;
	}

	@Override
	public String getText() {
		File catalogFile = new File(filename);
		String output = "";

		if (catalogFile.exists() && catalogFile.isFile()) {
			try {
				Scanner fileIterator = new Scanner(catalogFile);
				String text = "";
				while (fileIterator.hasNextLine()) {
					String line = fileIterator.nextLine();

					text += line + "\n";

				}
				output = text;
				fileIterator.close();
			} catch (FileNotFoundException e) {
				output = "Unable to open file: " + filename;
			}

		} else {
			output = "Unable to open file:" + filename;
		}
		return output;
	}

	/**
	 * Returns a String that contains the attributes of the book object, except for
	 * the filename
	 * 
	 * @return String with details of the book object
	 */
	public String toString() {
		String title = this.getTitle();
		String author = this.getAuthor();
		String genre = this.getGenre();
		String attributes = "Title: " + title + "\n" + "Author: " + author + "\n" + "Genre: " + genre + "\n";
		return attributes;
	}

}

