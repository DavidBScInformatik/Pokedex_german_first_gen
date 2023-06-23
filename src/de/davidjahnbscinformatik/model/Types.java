package de.davidjahnbscinformatik.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdom2.Element;

public class Types {
	
	private JPanel content;
	private final Element POKEDETAILS;
	private int width;
	private int height;
	
	public Types(JPanel content, Element pokemonDetails, int width, int height){
		this.content = content;
		this.POKEDETAILS = pokemonDetails;
		this.width = width;
		this.height = height;
		this.setTypes();
	}
	
	private void setTypes() {
		ArrayList<JPanel> arrTypes = new ArrayList<>();
		int collumCounter = 1;
		
//		int x = 120;
//		int y = 10;
		
		int x = width/4;
		int y = height-470;
		
		System.out.println("H:" + height);
		System.out.println("W:" + width);
		
		/*
		 * Set Background color with first type of pokemon
		 */
		List<Element> pokedex = POKEDETAILS.getChildren("types");
		for (Element types : pokedex) {
			List<Element> type = types.getChildren("type");
			for (int i=0; i<type.size(); i++) {
				JPanel content = new ContentBubble(x, y, 55, 25, type.get(i).getText());
				content.add(new JLabel(type.get(i).getText()));
				arrTypes.add(content);
				
				if(collumCounter < 2) {
					collumCounter++;
					x += 62;
				}else{
					y+=28;
					x = 25;
					collumCounter = 1;
				}
			}
		}
		
		content.setLayout(null);
		for (int i = 0; i < arrTypes.size(); i++) {
			content.add(arrTypes.get(i));
		}
	}
}
