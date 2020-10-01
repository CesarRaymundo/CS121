import java.awt.Component;

import javax.swing.JFrame;

public class ReaderOfBooks {

	public static void main(String[] args) {
		// Responsible for creating the JFrame instantiating the ReaderOfBooksPanel.java
		// class

		JFrame bookRead = new JFrame("Reader of Books");
		bookRead.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bookRead.setSize(800, 600);
		bookRead.add(new ReaderOfBooksPanel());
		bookRead.setVisible(true);
	}
}
