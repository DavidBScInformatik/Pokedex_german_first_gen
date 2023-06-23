package de.davidjahnbscinformatik.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

import org.jdom2.Element;

import de.davidjahnbscinformatik.model.Search;

public class SearchKeyListener implements KeyListener {

	private JTextField textfield;
	private Element xml;

	public SearchKeyListener(JTextField textfield, Element xml) {
		this.textfield = textfield;
		this.xml = xml;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println(textfield.getText());
			Search search = new Search();
			search.getResult(xml, textfield.getText());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
