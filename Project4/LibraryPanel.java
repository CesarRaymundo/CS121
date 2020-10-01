import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * 
 * @author cesarraymundo
 *
 */

public class LibraryPanel extends JPanel {
	private Library library;
	private JPanel bookListPanel;
	private JScrollPane bookListScrollPane;
	private JPanel importPanel;
	private JTextField importTextField;
	private JButton importButton;
	private ActionListener bookButtonListener;

	public LibraryPanel(ActionListener event) {
		this.bookButtonListener = event;
		this.setBorder(BorderFactory.createTitledBorder("Library"));

		// Creating bookListPanel
		bookListPanel = new JPanel();
		bookListPanel.setBorder(BorderFactory.createTitledBorder("Book List"));
		bookListPanel.setLayout(new BoxLayout(bookListPanel, BoxLayout.Y_AXIS));

		// Scroll bar
		bookListScrollPane = new JScrollPane(bookListPanel);
		bookListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		bookListScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// Creating importPanel and everything required in the JPanel.
		importPanel = new JPanel();
		importPanel.setBorder(BorderFactory.createTitledBorder("Import Books"));
		importPanel.setLayout(new BoxLayout(importPanel, BoxLayout.X_AXIS));
		importTextField = new JTextField(10);
		importPanel.add(importTextField);
		importTextField.addActionListener(new importButtonListener());
		importButton = new JButton("LOAD");
		importPanel.add(importButton);
		importButton.addActionListener(new importButtonListener());

		// Setting layout of panels within LibraryPanel.
		setLayout(new BorderLayout());
		this.add(bookListScrollPane, BorderLayout.CENTER);
		this.add(importPanel, BorderLayout.SOUTH);

	}

	/**
	 * 
	 * Checks if file exists and creates a button for each book object that exists
	 * within the file and adds it to the bookListPanel.
	 *
	 */
	private class importButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			library = new Library();
			String fileName = importTextField.getText();
			library.loadLibraryFromCSV(fileName);
			bookListPanel.removeAll();

			for (Book x : library.getBooks()) {
				BookButton bookButton = new BookButton(x);
				bookListPanel.add(bookButton);
				bookButton.addActionListener(bookButtonListener);

			}
			revalidate();
		}
	}
}