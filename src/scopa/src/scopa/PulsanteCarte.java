package scopa;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PulsanteCarte extends JButton {
	private static final long serialVersionUID = 1L;
	public AssCarte carte;
	
	public PulsanteCarte(ImageIcon icon, AssCarte carte0) {
		super(icon);
	    carte = carte0;
	}
}
