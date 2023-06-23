package de.davidjahnbscinformatik.model;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.XMLConstants;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Xml {

	private static final String FILENAME = "files/pokemon_genI.xml";
	private List<Element> pokeList;
	
	public Xml() {
		this.load();
	}
	
	private void load() {
		try {
			SAXBuilder sax = new SAXBuilder();

			sax.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
			sax.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");

			Document doc = sax.build(new File(FILENAME));

			Element rootNode = doc.getRootElement();

			this.pokeList = rootNode.getChildren("pokemon");

		} catch (IOException | JDOMException e) {
			e.printStackTrace();
		}
	}
	
	public List<Element> getPokeList(){
		return this.pokeList;
	}
}
