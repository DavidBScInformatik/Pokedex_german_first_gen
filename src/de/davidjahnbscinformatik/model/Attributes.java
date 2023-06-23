package de.davidjahnbscinformatik.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

import org.jdom2.Element;

public class Attributes extends JPanel {

	private static final long serialVersionUID = 1L;
	String[] arrAttributesName = { "HP", "AT", "DF", "SA", "SD", "INI" };
	JPanel lowerContent;
	private final Element POKEDETAILS;

	public Attributes(JPanel lowerContent, Element pokeDetails) {
		
		this.lowerContent = lowerContent;
		this.POKEDETAILS = pokeDetails;
		
		this.setLowerContent();
	}
	
	private void setLowerContent() {
		lowerContent.add(this);
	}
	
	/**
	 * We draw two rectangels one of that rectangle draw just the edges and one is
	 * filled
	 * 
	 * To fill the used bar chart I used the appropriate attribute multiply it with
	 * 10 and we got the same view like its on https://www.pokemon.com/de/pokedex
	 * 
	 * Example: We have maximum 15 bars - the KP are 3 of 15 We 150px height for the
	 * bar 3 * 10 are 30px filled from the 150px bar
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		int x = 46;
		g2d.setColor(Color.BLACK);
		for (int i = 1; i <= 6; i++) {
			g2d.drawRect(x, 0, 20, 125);
			x += 46;
		}
		//
		x = 46;
		List<Element> types = POKEDETAILS.getChildren("attributes");
		for (Element element : types) {
			List<Element> foo = element.getChildren();
			for (int i = 0; i < foo.size(); i++) {
				g2d.setColor(new Color(60, 150, 200));
				g2d.fillRect(x, 125 - Integer.valueOf(foo.get(i).getValue()) * 10, 20,
						Integer.valueOf(foo.get(i).getValue()) * 10);
				g2d.setColor(Color.BLACK);
				g2d.drawString(arrAttributesName[i], x, 150);
				x += 46;
			}
		}
	}

}
