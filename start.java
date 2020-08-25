package scopa;

import java.awt.EventQueue;

public class start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				try {
					Scopa gioco = new Scopa();
					Gui window = new Gui(gioco);
					gioco.inizializzazione();
					window.initialize();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		};
}


