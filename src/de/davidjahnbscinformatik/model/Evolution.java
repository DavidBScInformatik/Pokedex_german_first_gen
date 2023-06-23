package de.davidjahnbscinformatik.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdom2.Element;

import de.davidjahnbscinformatik.inputs.ContentBubbleMouseListener;

public class Evolution {
	
	private JPanel content;
	private final Element POKEDETAILS;
	private ArrayList<JLabel> arrTypes = new ArrayList<>();
	private List<Element> arrEvolutions = new ArrayList<>();
	private List<Element> type;
	private List<Element> pokedex;
	
	public Evolution(JPanel content, Element pokemonDetails){
		this.content = content;
		this.POKEDETAILS = pokemonDetails;
		this.setTypes();
	}
	
	private void setTypes() {
		
		// get all evolutions
		pokedex = POKEDETAILS.getChildren("evolutions");
		for (Element types : pokedex) {
			type = types.getChildren("evo");
			for (int i=0; i<type.size(); i++) {
				this.arrTypes.add(new JLabel(type.get(i).getText()));
			}
		}
		
		// searching for pokemon in xml that equals arrTypes.name
		Search foo = new Search();
		arrEvolutions = foo.getResult(POKEDETAILS, arrTypes);
		arrTypes.clear();
		for (Element evolution : arrEvolutions) {
			this.arrTypes.add(new JLabel(evolution.getChildText("name")));
			JLabel evo = Scaler.scaleImage("images/" + evolution.getAttributeValue("ident") + ".png", 50, 50);
			evo.addMouseListener(new ContentBubbleMouseListener(evolution));
			this.arrTypes.add(evo);
		}
		
		content.removeAll();
		for (int i = 0; i < arrTypes.size(); i++) {
			content.add(arrTypes.get(i));
		}
	}
}
