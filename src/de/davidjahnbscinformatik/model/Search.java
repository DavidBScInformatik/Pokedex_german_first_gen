package de.davidjahnbscinformatik.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import org.jdom2.Element;

import de.davidjahnbscinformatik.view.PokeDetailsWindow;

public class Search {
	
	public ArrayList<Element> arrEvolution = new ArrayList<Element>();
	public List<Element> fullPokeList;
	
	public List<Element> getResult(Element PokeList, ArrayList<JLabel> evolutions) {
		Xml	pokeList = new Xml();
		
		for (Element fullPokedex : pokeList.getPokeList()) {
			List<Element> foo = fullPokedex.getChildren("pokedex");
			for (Element bar : foo) {
				//System.out.println(bar.getChildText("name"));
				for (JLabel jLabel : evolutions) {
					if(jLabel.getText().equals(bar.getChildText("name"))) {
						System.out.println("Gerfunden: " + jLabel.getText() + " = " + bar.getChildText("name"));
						arrEvolution.add(bar);
					}
				}
			}
		}
		System.out.println("debug...");
		System.out.println("BREAK!");
		return arrEvolution;
	}
	
	public List<Element> getResult(Element PokeList, String pokemon) {
		Xml	pokeList = new Xml();
		
		for (Element fullPokedex : pokeList.getPokeList()) {
			List<Element> foo = fullPokedex.getChildren("pokedex");
			for (Element bar : foo) {
				System.out.println("Vergleiche: " + bar.getChildText("name") + " mit: " + pokemon);
				if(bar.getChildText("name").equals(pokemon)){
					System.out.println("POKEMON IN DER LISTE GEFUNDNE!");
					new PokeDetailsWindow(bar);
				}
			}
		}
		
		System.out.println("debug...");
		System.out.println("BREAK!");
		return arrEvolution;
	}
}
