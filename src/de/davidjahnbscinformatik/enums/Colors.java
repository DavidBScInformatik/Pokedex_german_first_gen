package de.davidjahnbscinformatik.enums;

import java.awt.Color;

public enum Colors {
	FEUER(new Color(255, 115, 65)), PFLANZE(new Color(50, 200, 60)), WASSER(new Color(55, 130, 230)),
	KÄFER(new Color(180, 200, 50)), NORMAL(new Color(250, 250, 250)), BODEN(new Color(200, 160, 50)),
	GESTEIN(new Color(140, 140, 140)), GEIST(new Color(120, 80, 140)), KAMPF(new Color(200, 100, 0)),
	GIFT(new Color(180, 120, 220)), FLUG(new Color(130, 230, 255)), PSYCHO(new Color(255, 130, 235)),
	ELEKTRO(new Color(255, 255, 100)), FEE(new Color(250, 190, 255)), STAHL(new Color(235, 235, 235)),
	DRACHE(new Color(110, 160, 200)), EIS(new Color(190, 226, 255)),
	TYPE(new Color(235, 255, 235)), WEAKNESS(new Color(255, 235, 235)), DEFAULT(new Color(235, 235, 235));
	
	private final Color color;

	Colors(Color color) {
		this.color = color;
	}
	
	public static Color getColor(String type) {
		switch (type) {
			case ("Pflanze"):
				return PFLANZE.getRBG();
			case ("Feuer"):
				return FEUER.getRBG();
			case ("Wasser"):
				return WASSER.getRBG();
			case ("Käfer"):
				return KÄFER.getRBG();
			case ("Boden"):
				return BODEN.getRBG();
			case ("Gestein"):
				return GESTEIN.getRBG();
			case ("Kampf"):
				return KAMPF.getRBG();
			case ("Geist"):
				return GEIST.getRBG();
			case ("Normal"):
				return NORMAL.getRBG();
			case ("Gift"):
				return GIFT.getRBG();
			case ("Flug"):
				return FLUG.getRBG();
			case ("Psycho"):
				return PSYCHO.getRBG();
			case ("Elektro"):
				return ELEKTRO.getRBG();
			case ("Fee"):
				return FEE.getRBG();
			case ("Stahl"):
				return STAHL.getRBG();
			case ("Drache"):
				return DRACHE.getRBG();
			case ("Eis"):
				return EIS.getRBG();
			case ("Type"):
				return TYPE.getRBG();
			case ("Weakness"):
				return WEAKNESS.getRBG();
			default:
				return DEFAULT.getRBG();
		}
	}
	
	private Color getRBG() {
		return this.color;
	}
}
