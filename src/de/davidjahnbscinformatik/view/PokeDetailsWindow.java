package de.davidjahnbscinformatik.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import org.jdom2.Element;

import de.davidjahnbscinformatik.model.Abilities;
import de.davidjahnbscinformatik.model.Attributes;
import de.davidjahnbscinformatik.model.ContentBubble;
import de.davidjahnbscinformatik.model.Evolution;
import de.davidjahnbscinformatik.model.Scaler;
import de.davidjahnbscinformatik.model.Types;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PokeDetailsWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private final Element POKEDETAILS;
	private final Color BACKGROUNDCOLOR = new Color(240, 240, 240);

	public PokeDetailsWindow(Element pokeDetails) {
		this.POKEDETAILS = pokeDetails;
		this.view("Details");
	}

	public void view(String title) {
		this.setResizable(false);
		this.setTitle(title);
		this.setSize(640, 480);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.add(this.initHeader(100, 100), BorderLayout.NORTH);
		this.add(this.initImage(300, 300), BorderLayout.EAST);
		this.add(this.initContent(150, 150), BorderLayout.CENTER);
		this.add(this.initFooter(), BorderLayout.SOUTH);
	}

	private JPanel initHeader(int x, int y) {
		JPanel header = new JPanel();
		header.setBackground(this.BACKGROUNDCOLOR);
		header.setPreferredSize(new Dimension(x, y));
		
		JLabel content = new JLabel("Nr: " + this.POKEDETAILS.getAttributeValue("ident") + " - " + this.POKEDETAILS.getChildText("name"));
		content.setFont(new Font("serif", Font.PLAIN, 30));
		content.setBorder(new EmptyBorder(25, 25, 25, 25));
		
		header.add(content);
		
		return header;
	}
	
	private JPanel initImage(int x, int y) {
		JPanel imagePanel = new JPanel();
		imagePanel.setPreferredSize(new Dimension(x, y));
		imagePanel.add(Scaler.scaleImage("images/" + POKEDETAILS.getAttributeValue("ident") + ".png", 250, 250));
		return imagePanel;
	}

	private JPanel initContent(int x, int y) {
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		content.setBackground(this.BACKGROUNDCOLOR);
		content.setPreferredSize(new Dimension(150, 50));
		
		JPanel upperContent = new JPanel();
		upperContent.setLayout(null);
		upperContent.setPreferredSize(new Dimension(150, 100));
		JPanel upperLeft = new ContentBubble(5, 0, 166, 100, "Type");
		upperContent.add(upperLeft);
		JPanel upperRight = new ContentBubble(173, 0, 166, 100, "Weakness");
		upperContent.add(upperRight);
		
		JPanel lowerContent = new JPanel();
		lowerContent.setLayout(new BorderLayout());
		lowerContent.setPreferredSize(new Dimension(150, 175));
		lowerContent.setBorder(new EmptyBorder(10, 0, 0, 0));

		new Attributes(lowerContent, this.POKEDETAILS);
		new Abilities(upperLeft, upperRight, this.POKEDETAILS);
		
		content.add(upperContent, BorderLayout.NORTH);
		content.add(lowerContent, BorderLayout.SOUTH);
		
		return content;
	}

	private JPanel initFooter() {
		JPanel footer = new JPanel();
		footer.setLayout(new BorderLayout());
		footer.setBorder(new EmptyBorder(10, 10, 10, 10));
		footer.setPreferredSize(new Dimension(640, 75));
		
		JPanel footerLeft = new JPanel();
		footerLeft.setPreferredSize(new Dimension(320, 75));
		new Evolution(footerLeft, POKEDETAILS);
		
		JPanel footerRight = new JPanel();
		footerRight.setPreferredSize(new Dimension(320, 75));
		System.out.println(footer.getX());
		new Types(footerRight, POKEDETAILS, getBounds().width, getBounds().height);
		footer.add(footerRight, BorderLayout.EAST);
		footer.add(footerLeft, BorderLayout.WEST);
		
		return footer;
	}
}
