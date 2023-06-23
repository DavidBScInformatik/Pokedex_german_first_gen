package de.davidjahnbscinformatik.interfaces;

import javax.swing.JPanel;

import org.jdom2.Element;

public interface IWindow {
	
	void view(String value);
	JPanel creatContentBubble(Element value);
}
