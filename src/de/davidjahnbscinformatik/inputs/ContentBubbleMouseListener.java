package de.davidjahnbscinformatik.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import org.jdom2.Element;

import de.davidjahnbscinformatik.view.PokeDetailsWindow;

public class ContentBubbleMouseListener implements MouseListener {

	private Element pokemonDetails;
	
	public ContentBubbleMouseListener(Element pokemonDetails) {
		this.pokemonDetails = pokemonDetails;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		new PokeDetailsWindow(pokemonDetails);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
