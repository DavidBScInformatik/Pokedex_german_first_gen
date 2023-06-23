package de.davidjahnbscinformatik.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import org.jdom2.Element;

import de.davidjahnbscinformatik.enums.Colors;

public class ContentBubble extends JPanel {

	private static final long serialVersionUID = 1L;
	private final int WIDTH;
	private final int HEIGHT;
	private final int X;
	private final int Y;
	private Color color;
	private String type;
	private int cornerRadius = 15;

	public ContentBubble(int x, int y, int width, int heigth, Element xml) {
		this.X = x;
		this.Y = y;
		this.WIDTH = width;
		this.HEIGHT = heigth;
		this.initContent();
	}
	
	public ContentBubble(int x, int y, int width, int heigth, String type) {
		this.X = x;
		this.Y = y;
		this.WIDTH = width;
		this.HEIGHT = heigth;
		this.type = type;
		this.initContent();
	}
	
	private void initContent() {
		this.setBounds(this.X, this.Y, this.WIDTH, this.HEIGHT);
		this.setBackgroundColorWithString();
	}
	
	private void setBackgroundColorWithString() {
		this.color = Colors.getColor(this.type);
	}

	/**
	 * Much thanks to user Ryan from StackOverFlow forum for this simple example how
	 * to creat a JPanel with rounded corners https://stackoverflow.com/a/44851882
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension arcs = new Dimension(cornerRadius, cornerRadius);
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Draws the rounded panel with borders.
		if (color != null) {
			graphics.setColor(this.color);
		} else {
			graphics.setColor(this.getBackground());
		}
		graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // paint background
		graphics.setColor(getForeground());
		graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // paint border
	}
}