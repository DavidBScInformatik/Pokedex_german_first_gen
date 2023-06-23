package de.davidjahnbscinformatik.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdom2.Element;

public class Abilities {

	private JPanel upperLeft;
	private JPanel upperRight;
	private final Element POKEDETAILS;
	
	public Abilities(JPanel upperLeft, JPanel upperRight, Element pokeDetails) {
		this.upperLeft = upperLeft;
		this.upperRight = upperRight;
		this.POKEDETAILS = pokeDetails;
		this.setTypesContent();
		this.setWeaknessContent();
	}
	
	public void setTypesContent() {
		ArrayList<JPanel> arrTypes = new ArrayList<>();
		int collumCounter = 1;
//		upperLeft.setPreferredSize(new Dimension(70, 100));
//		upperLeft.setMaximumSize(new Dimension(70, 100));
//		upperLeft.setMinimumSize(new Dimension(70, 100));
//		
		int x = 25;
		int y = 10;
		
		/*
		 * Set Background color with first type of pokemon
		 */
		List<Element> pokedex = POKEDETAILS.getChildren("strengths");
		for (Element types : pokedex) {
			List<Element> type = types.getChildren("strength");
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
		
		upperLeft.setLayout(null);
		for (int i = 0; i < arrTypes.size(); i++) {
			upperLeft.add(arrTypes.get(i));
		}
	}
	
	public void setWeaknessContent() {
		ArrayList<JPanel> arrTypes = new ArrayList<>();
		int collumCounter = 1;
		
		int x = 25;
		int y = 10;
		
		/*
		 * Set Background color with first type of pokemon
		 */
		List<Element> pokedex = POKEDETAILS.getChildren("weaknesses");
		for (Element types : pokedex) {
			List<Element> type = types.getChildren("weakness");
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
		
		upperRight.setLayout(null);
		for (int i = 0; i < arrTypes.size(); i++) {
			upperRight.add(arrTypes.get(i));
		}
	}
	
}
