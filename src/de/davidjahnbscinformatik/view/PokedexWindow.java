package de.davidjahnbscinformatik.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import org.jdom2.Element;

import de.davidjahnbscinformatik.inputs.ContentBubbleMouseListener;
import de.davidjahnbscinformatik.inputs.SearchMouseListener;
import de.davidjahnbscinformatik.model.ContentBubble;
import de.davidjahnbscinformatik.model.Copyright;
import de.davidjahnbscinformatik.model.Scaler;

public class PokedexWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private int x = 10;
	private int y = 10;
	private Element xml;
	ArrayList<JPanel> arrBubbles = new ArrayList<JPanel>();
	ImageIcon icon;

	public PokedexWindow(Element xml) {
		this.xml = xml;
		this.fillPokedexArray();
		this.initLayout();
		
	}
	
	/**
	 * add content bubbles filled with information of 
	 * every pokemon form this.xml to this.arrBubbles 
	 */
	private void fillPokedexArray() {
		// counter for max. 3 bubbles per line
		int columnCounter = 1;

		List<Element> pokedexEntries = this.xml.getChildren("pokedex");
		for (Element pokemon : pokedexEntries) {

			// fill the array with bubbles
			this.arrBubbles.add(this.creatContentBubble(pokemon));

			// for correct position on pokedex window
			if (columnCounter < 3) {
				this.x += 160;
				columnCounter++;
			} else {
				this.x = 10;
				this.y += 165;
				columnCounter = 1;
			}
		}
	}
	
	/**
	 * Create a new Bubble and fill it with information
	 * @return JPanel content
	 */
	private JPanel creatContentBubble(Element pokemon) {
		JPanel content = new JPanel();
		
		/*
		 * Set Background color with first type of pokemon
		 */
		List<Element> pokedex = pokemon.getChildren("types");
		for (Element types : pokedex) {
			List<Element> type = types.getChildren("type");
			content = new ContentBubble(this.x, this.y, 150, 150, type.get(0).getText());
		}
		
		/*
		 * ... and fill the bubble with information
		 */
		content.add(new JLabel(pokemon.getChildText("name")));
		JLabel logo = new JLabel(icon);
		scaleImage(logo, pokemon.getAttributeValue("ident"));
		content.add(logo);
		content.addMouseListener(new ContentBubbleMouseListener(pokemon));
		
		return content;
	}
	
	/**
	 * initialize the full content of the main frame
	 */
	private void initLayout() {
		this.add(this.generateHeaderPanel(), BorderLayout.BEFORE_FIRST_LINE);
		this.add(this.generateFooterPanel(), BorderLayout.AFTER_LAST_LINE);
		this.add(this.generateScrollPanel());
		this.setTitle(this.xml.getAttributeValue("gen"));
		this.setResizable(false);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * Generate and fill header panel for main frame
	 * @return JPanel header
	 */
	private JPanel generateHeaderPanel() {
		JPanel search = new JPanel();
		search.add(Scaler.scaleImage("images/search.png", 40, 40));
		search.addMouseListener(new SearchMouseListener(this.xml));
		
		JPanel header = new JPanel();
		header.add(Scaler.scaleImage("images/pokedex_logo.png", 250, 100));
		header.add(search);
		
		return header;
	}
	
	/**
	 * Generate and fill center content panel for main frame
	 * @return JScrollPane scrollPane
	 */
	public JScrollPane generateScrollPanel() {
		// Damit dass Frame Scrollbar ist wird ihm ein Panel welches Größer ist
		// hinzugefügt
		// Add the main panel with full content on scroll panel from pokedex windows
		
		JPanel mainPanel = new JPanel();
		for (int i = 0; i < this.arrBubbles.size(); i++) {
			mainPanel.add(this.arrBubbles.get(i));
		}
		mainPanel.setLayout(null);
		mainPanel.setPreferredSize(new Dimension(510, y));
		
		JPanel scrollPanel = new JPanel();
		scrollPanel.setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(scrollPanel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(510, 800));
		scrollPanel.add(mainPanel, BorderLayout.CENTER);

		return scrollPane;
	}
	
	/**
	 * Generate and fill footer label for main frame
	 * @return JLabel footer
	 */
	private JLabel generateFooterPanel() {
		JLabel footer = new JLabel(Copyright.getCopyright(), SwingConstants.CENTER);
		footer.setVerticalAlignment(SwingConstants.BOTTOM);
		
		return footer;
	}
	
	private void scaleImage(JLabel label, String pokeId) {
		icon = new ImageIcon("images/" + pokeId + ".png");
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		label.setIcon(scaledIcon);
	}
}
