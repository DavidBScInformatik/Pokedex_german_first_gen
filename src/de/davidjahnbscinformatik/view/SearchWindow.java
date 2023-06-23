package de.davidjahnbscinformatik.view;

import javax.swing.JFrame;
import javax.swing.JTextField;

import org.jdom2.Element;

import de.davidjahnbscinformatik.inputs.SearchKeyListener;

public class SearchWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public SearchWindow(Element xml){
		JTextField textfield = new JTextField();
		textfield.setText("Suche...");
		textfield.setSize(200, 60);
		textfield.addKeyListener(new SearchKeyListener(textfield, xml));
		this.setSize(200, 60);
		this.add(textfield);
		this.setVisible(true);
	}
}
