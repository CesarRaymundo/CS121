import javax.swing.JButton;

public class BookButton extends JButton {

	private Book book;
	private final String ELLIPSES = "...";

	/**
	 * Creates book button with title of book object and ellipses if title is longer
	 * than 20 characters.
	 * 
	 * @param book
	 */
	public BookButton(Book book) {
		this.book = book;
		String title = book.getTitle();
		int charCount = title.length();
		if (charCount < 20) {
			String regTitle = book.getTitle();
			setTitleText(regTitle);
		} else {
			String longBook = book.getTitle().substring(0, 19) + ELLIPSES;
			setTitleText(longBook);
		}
		setToolTipText(this.book.toString());
	}

	/**
	 * Returns book
	 * 
	 * @return
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * 
	 * @param text
	 */
	public void setTitleText(String text) {
		this.setText(text);
	}
}
