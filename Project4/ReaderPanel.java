import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * @author Cesar Raymundo
 *
 */
public class ReaderPanel extends JPanel {
	private JPanel infoPanel;
	private JLabel titleLabel;
	private JLabel authorLabel;
	private JLabel pageLabel;
	private JScrollPane bookTextScrollPane;
	private JTextArea bookTextArea;
	private JPanel navigationPanel;
	private JButton pageUpButton;
	private JButton pageDownButton;
	private static int pageNum;
	private static int numPages;
	private ActionListener pageUp;
	private ActionListener pageDown;

	/**
	 * Creates a new ReaderPanel with book given through BookButtonListener
	 * 
	 * @param book
	 */
	public ReaderPanel(Book book) {
		this.setBorder(BorderFactory.createTitledBorder("Reader"));

		// Creating info panel and adding labels to the panel with horizontal glue
		infoPanel = new JPanel();
		infoPanel.setBorder(BorderFactory.createTitledBorder("Information"));
		titleLabel = new JLabel();
		authorLabel = new JLabel();
		pageLabel = new JLabel();
		titleLabel.setText("Title: Project 4");
		authorLabel.setText("Author: Cesar Raymundo");
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		infoPanel.add(Box.createHorizontalGlue());
		infoPanel.add(titleLabel);
		infoPanel.add(Box.createHorizontalGlue());
		infoPanel.add(authorLabel);
		infoPanel.add(Box.createHorizontalGlue());
		infoPanel.add(pageLabel);
		infoPanel.add(Box.createHorizontalGlue());

		// adding booktextarea
		bookTextArea = new JTextArea();
		bookTextArea.setLineWrap(true);
		bookTextArea.setEditable(false);

		/**
		 * if book is passed down through the BookButtonListener, checks if its valid
		 * and sets the labels of new book.
		 */
		if (book.isValid()) {
			bookTextArea.setText(book.getText());
			titleLabel.setText("Title: " + book.getTitle());
			authorLabel.setText("Author: " + book.getAuthor());

			bookTextArea.setCaretPosition(0);
			bookTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		}

		// Creating bookTextScrollPane
		bookTextScrollPane = new JScrollPane(bookTextArea);
		bookTextScrollPane.setBorder(BorderFactory.createTitledBorder("Content"));
		bookTextScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		bookTextScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		bookTextScrollPane.getVerticalScrollBar().addAdjustmentListener(new ScrollBarListener());

		// Creating navigationPanel and adding everything required within the JPanel
		navigationPanel = new JPanel();
		navigationPanel.setBorder(BorderFactory.createTitledBorder("Navigation"));
		pageUpButton = new JButton("Page Up");
		pageDownButton = new JButton("Page Down");
		navigationPanel.add(pageUpButton);
		navigationPanel.add(pageDownButton);
		pageUp = new PagingUpListener();
		pageDown = new PagingDownListener();
		pageUpButton.addActionListener(pageUp);
		pageDownButton.addActionListener(pageDown);

		// Setting the layout of the JPanels within ReaderPanel
		setLayout(new BorderLayout());
		this.add(bookTextScrollPane, BorderLayout.CENTER);
		this.add(infoPanel, BorderLayout.NORTH);
		this.add(navigationPanel, BorderLayout.SOUTH);

	}

	/**
	 * 
	 * Moves the position of the TextScrollPane a certain amount of its minimum
	 * value based on current page height.
	 *
	 */
	private class PagingUpListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			bookTextScrollPane.getVerticalScrollBar().setValue(bookTextScrollPane.getVerticalScrollBar().getValue()
					- bookTextScrollPane.getVerticalScrollBar().getBlockIncrement(1));
			revalidate();
		}
	}

	/**
	 * 
	 * Moves the position of the TextScrollPane a certain amount of its maximum
	 * value based on current page height.
	 *
	 */
	private class PagingDownListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			bookTextScrollPane.getVerticalScrollBar().setValue(bookTextScrollPane.getVerticalScrollBar().getValue()
					+ bookTextScrollPane.getVerticalScrollBar().getBlockIncrement(1));
			revalidate();
		}
	}

	/**
	 * 
	 * Checks if ScrollPane has reached the min or max value and disables a page
	 * button depending on the bound. Also updates the pageLabel with current page
	 * and with the total amount of pages in the book.
	 *
	 */
	private class ScrollBarListener implements AdjustmentListener {
		public void adjustmentValueChanged(AdjustmentEvent e) {
			pageNum = 1 + (bookTextScrollPane.getVerticalScrollBar().getValue()
					/ bookTextScrollPane.getVerticalScrollBar().getBlockIncrement(1));
			numPages = (bookTextScrollPane.getVerticalScrollBar().getMaximum()
					/ bookTextScrollPane.getVerticalScrollBar().getBlockIncrement(1));
			pageLabel.setText("Page: " + pageNum + "/" + numPages);

			int pageHeight = bookTextScrollPane.getVerticalScrollBar().getHeight();

			int max = bookTextScrollPane.getVerticalScrollBar().getMaximum();
			int min = bookTextScrollPane.getVerticalScrollBar().getMinimum();

			int pageValue = e.getValue();
			if ((pageValue - pageHeight) <= min) {
				pageUpButton.setEnabled(false);
			} else {
				pageUpButton.setEnabled(true);
			}

			if ((pageValue + pageHeight) >= max) {
				pageDownButton.setEnabled(false);
			} else {
				pageDownButton.setEnabled(true);
			}
		}

	}

}

