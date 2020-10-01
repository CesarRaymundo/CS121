import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author cesarraymundo
 *
 */
public class ReaderOfBooksPanel extends JPanel {
	private LibraryPanel libraryPanel;
	private ReaderPanel readerPanel;

	public ReaderOfBooksPanel() {
		setLayout(new BorderLayout());
		libraryPanel = new LibraryPanel(new BookButtonListener());
		add(libraryPanel, BorderLayout.WEST);
		Book emptyBook = new Book(null, null);
		readerPanel = new ReaderPanel(emptyBook);
		add(readerPanel, BorderLayout.CENTER);

	}

	/**
	 * 
	 * Calls a book button to refresh the panel with the new book that is passed to
	 * readerPanel.
	 *
	 */
	private class BookButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			BookButton clicked = (BookButton) e.getSource();
			Book book = clicked.getBook();
			remove(readerPanel);
			readerPanel = new ReaderPanel(book);
			add(readerPanel, BorderLayout.CENTER);

			revalidate();
		}

	}
}
