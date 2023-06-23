package de.davidjahnbscinformatik.system;

import de.davidjahnbscinformatik.view.PokedexWindow;

import org.jdom2.Element;

import de.davidjahnbscinformatik.model.Xml;

public class Main {

	public static void main(String[] args) {
		Xml xml = new Xml();
		
		for (Element fullPokedex : xml.getPokeList()) {
			new PokedexWindow(fullPokedex);
		}
		
	}

}
