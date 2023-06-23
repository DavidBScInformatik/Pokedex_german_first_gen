package de.davidjahnbscinformatik.model;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Scaler {
	/**
	 * Scale an image to an defined height and width
	 * put it an a Label and give it back 
	 */
	public static JLabel scaleImage(String path, int width, int height) {
		JLabel imgLabel = new JLabel();
		ImageIcon icon = new ImageIcon(path);
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		imgLabel.setIcon(scaledIcon);
		return imgLabel;
	}
}
