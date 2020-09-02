package scopa;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.io.*;

public class Scopa extends AbstractAction{
	private static final long serialVersionUID = 1L;
	public static final int FACILE = 2;
	public static final int DIFFICILE = 1;
	Gui finestra;
	Mazzo dato; //indica le carte uscite (mano dei giocatori o prese dal centro)
	Mazzo centrale;
	AssCarte ultimaMano; //raccolta carte dal banco all'ultimo turno
	Mazzo ultimaPresa;
	Giocatore computer;
	Giocatore io;
	boolean myturn;
	public boolean booleanScopa;
	int difficolta;
	private boolean carteNoValue; //carte che non hanno valore, solo per fare numero (es. 2-3-4-5 ecc. picche/cuori/fiori)
	private boolean myUltimaMano;
	private Thread action;
	private boolean modeApplet;
	
	Scopa(boolean modeApplet1){
		booleanScopa = false;
		difficolta = FACILE;
		action = new Thread();
		//finestra = new Gui(this,);
		modeApplet = modeApplet1;
		computer = new Giocatore();
		io = new Giocatore();
		dato = new Mazzo();
		centrale = new Mazzo();                  
	}
	public Scopa() {
		// TODO Auto-generated constructor stub
	}
	
	
	void inizializzazione() {
		String diff;
		int i;
		String[] list = {"FACILE","DIFFICILE"};
		JComboBox jcb = new JComboBox(list);
		jcb.setEditable(false);
		JOptionPane.showMessageDialog( null, jcb, "scegli la difficoltà", JOptionPane.QUESTION_MESSAGE);
		diff = (String) jcb.getSelectedItem();
		System.out.println(diff);
		if(diff=="DIFFICILE") {
			difficolta = DIFFICILE;
		}else {
			difficolta = FACILE;
		}
		booleanScopa = false;
		action = new Thread();
		//finestra = new Gui(this);
		
		computer = new Giocatore();
		io = new Giocatore();
		dato = new Mazzo();
		centrale = new Mazzo();
		carteNoValue = false;
		//centrale.clear();
		//computer.clear();
		io.clear();
		dato = Mazzo.getSemi();
		for( i = 0; i < 4; i++)
		{
			centrale.add((AssCarte)dato.removeFirst());
		}
		ultimaMano = null;
		ultimaPresa = null;
		distribuzione();
		//disegna();
	/*	if(!myturn)
		{
			compturn();
		}*/
	}

	void distribuzione() {
		int i ;
		for( i = 0; i<3; i++) {
			computer.gioco.add((AssCarte)dato.removeFirst());
			io.gioco.add((AssCarte)dato.removeFirst());
		}
		//disegna();
		if(dato.isEmpty()) {
			popUp("Ultima distribuzione!!!", "Fai le tue ultime mosse!");
		}
	}
	
	void compturn() {
		try { Thread.sleep(1500L); }
		catch(InterruptedException e) {	e.printStackTrace(); }
		
		LinkedList<CoppiaDaProvare> daProvare = new LinkedList<CoppiaDaProvare>();
		for(Iterator<?> iterator = computer.gioco.iterator(); iterator.hasNext();) {
			AssCarte carte = (AssCarte)iterator.next();
			if(carte.getValue() == 1) {
				daProvare.add(new CoppiaDaProvare(carte, centrale.clone()));
			} else {
				boolean collectAsso = false;
				boolean impossibleCollect = true;
				Iterator<?> iterator1 = centrale.combinazioni().iterator();
				while(iterator1.hasNext()) {
					Mazzo element = (Mazzo)iterator1.next();
					if(element.somma() != carte.getValue()) {
						continue;
					}
					impossibleCollect = false;
					if(element.size() == 1) {
						collectAsso = true;
					} else if(collectAsso) {
							break;
						}
					daProvare.add(new CoppiaDaProvare(carte, element));
				}
				if(impossibleCollect) {
					daProvare.add(new CoppiaDaProvare(carte, null));
				}
			}
		}
		CoppiaDaProvare intelligente = intelligenzaArtificiale(daProvare);
		giocataMigliore(computer, intelligente.carte, intelligente.raccolta);
	}
	
	/*private void disegna()
	{
		finestra.disegna(this);
		finestra.setVisible(true);
	}*/
	
	/*private void disegnaPiega(AssCarte carte, Mazzo raccolta) {
		if(raccolta == null) {
			return;
		}
		finestra.disegnaPiega(this, carte, raccolta);
		finestra.setVisible(true);
		try
		{
			Thread.sleep(1500L);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}*/
	
	public void myturn(AssCarte carte) {
		if(carte.getValue() == 1) {
			giocataMigliore(io, carte, centrale.clone());
		} else {
			LinkedList<Mazzo> possibilita = new LinkedList<Mazzo>();
			boolean collectAsso = false;
			Iterator<?> iterator = centrale.combinazioni().iterator();
			while(iterator.hasNext()) {
				Mazzo element = (Mazzo)iterator.next();
				if(element.somma() != carte.getValue()) {
					continue;
				}
				if(element.size() == 1) {
					collectAsso = true;
				} else if (collectAsso) {
					break;
					}
				possibilita.add(element);
			}
			switch(possibilita.size()) {
			case 0:
				giocataMigliore(io, carte, null);
				break;
				
			case 1:
				giocataMigliore(io, carte, possibilita.getFirst());
				break;
				
			default:
				giocataMigliore(io, carte, indecisioneIo(carte, possibilita));
				break;
			}
		}
	}
	
	void rigioca() {
		computer.risultato = 0;
		io.risultato = 0;
		myturn = true;
		inizializzazione();
	}
	
	
	
	public void actionPerformed(final ActionEvent e) {
		if(action.isAlive())
		{
			return;
		} else
		{
			action = new Thread() {

				public void run() {
					Object source = e.getSource();
					if((source instanceof PulsanteCarte) && myturn)
					{
						myturn(((PulsanteCarte)source).carte);
					}
					if(!myturn) { compturn(); }
					if(source instanceof JMenuItem)
					{
						if(source.equals(finestra.rigioca)) { rigioca(); }
						if(source.equals(finestra.esci)) { System.exit(0); }
						computer.risultato = 0;
						io.risultato = 0;
						inizializzazione();
						if(source.equals(finestra.FACILE)) { difficolta = FACILE; rigioca(); }
						if(source.equals(finestra.DIFFICILE)) { difficolta = DIFFICILE; rigioca(); }
						//disegna();
					}
				}
			};
			action.start();
			return;
			
		}
	}
	
	private void giocataMigliore(Giocatore giocatore, AssCarte carte, Mazzo raccolta) {
		booleanScopa = false;
		giocatore.gioco.remove(carte);
		//disegnaPiega(carte, raccolta);
		myturn = !giocatore.equals(io);
		ultimaPresa = raccolta;
		ultimaMano = carte;
		if(raccolta == null) {
			centrale.add(carte);
		} else {
			myUltimaMano = giocatore.equals(io);
			centrale.removeAll(raccolta);
			giocatore.raccolta.add(carte);
			giocatore.raccolta.addAll(raccolta);
			if(centrale.isEmpty() && carte.getValue() != 1) {
				giocatore.numScopa++;
				JOptionPane.showMessageDialog(finestra, "scopaaaaa!!");
				booleanScopa = true;
				Toolkit.getDefaultToolkit().beep();
			}
		}
		if(io.gioco.isEmpty() && computer.gioco.isEmpty()) {
			if(dato.isEmpty()) {
				finePartita();
			} else {
				distribuzione();
			}
		}
		//disegna();
	}
	
	private Mazzo indecisioneIo (AssCarte carte, LinkedList<Mazzo> possibilita) {
		Mazzo ret;
		for(ret = null; ret == null; ret = (Mazzo)JOptionPane.showInputDialog(finestra, "Scegli cosa raccogliere", "Mazzo", 3, null, possibilita.toArray(), possibilita.getFirst())) {
		}
		return ret;
	}
	
	private void finePartita() {
		myturn = !myturn;
	//	disegna();
		try{
			Thread.sleep(1500L);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		if(myUltimaMano) {
			io.raccolta.addAll(centrale);
		}
		else {
			computer.raccolta.addAll(centrale);
		}
		centrale.clear();
		
		int scoreIo = io.risultato();
		int scoreComputer = computer.risultato();
		int dati[] = io.raccolta.risultato();
		computer.risultato += scoreComputer;
		io.risultato += scoreIo;
		
		StringBuilder result = new StringBuilder();
		result.append((new StringBuilder(String.valueOf(myUltimaMano ? "Tuo score" : "Computer score"))).append("Ultima mano.").append('\n').toString());
		
		if (dati[2] > 5) {
			result.append("Hai fatto Ori");
		}
		if(dati[2] == 5) {
			result.append("Gli Ori sono pari");
		}
		if(dati[2] < 5) {
			result.append("L'avversario ha fatto Ori");
		}
		result.append(", ");
		if(dati[0] == 1) {
			result.append("hai i sette");
		}
		else {
			result.append("L'avversario ha i sette");
		}
		result.append(", ");
		if(dati[3] == 1) {
			result.append("hai il sette bello");
		} 
		else {
			result.append("L'avversario ha il sette bello");
		}
		result.append(", ");
		if(dati[1] > 20) {
			result.append("Hai fatto Carte");
		}
		if(dati[1] < 20) {
			result.append("L'avversario ha fatto Carte");
		}
		if(dati[1] == 20) {
			result.append("Carte pari");
		}
		result.append(".");
		int risultatoSenza123Ori = (dati[2] <= 5 ? 0 : 1) + (dati[1] <= 20 ? 0 : 1) + dati[0] + dati[3] + io.numScopa;
		if (scoreIo != risultatoSenza123Ori) {
			if(scoreIo == 21) {
				result.append("\n Hai tutti gli ori");
			} else {
				result.append((new StringBuilder("\nHai l'asso ")).append(scoreIo - risultatoSenza123Ori).append("d'oro").toString());
			}
			risultatoSenza123Ori = (((((dati[2] >= 5 ? 0 : 1) + (dati[1] >= 20 ? 0 : 1) + 1) - dati[0]) + 1) - dati[3]) + computer.numScopa;
			if(scoreComputer == 21) {
				result.append("L'avversario ha tutti gli ori");
			}
			else
			{
				result.append((new StringBuilder("\nL'avversario ha l'asso ")).append(scoreComputer - risultatoSenza123Ori).append(" d' oro ").toString());
			}
		}
		result.append('\n');
		result.append((new StringBuilder("\nHai ")).append(io.numScopa).append(" punti di scopa").toString());
		result.append((new StringBuilder("\nL'avversario ha ")).append(computer.numScopa).append("punti di scopa").toString());
		result.append((new StringBuilder("\n\nScore della manche : ")).append(scoreIo).append(" / ").append(scoreComputer).toString());
		result.append((new StringBuilder("\n\n")).append(myturn ? "Tocca a te." : "Tocca all'avversario.").toString());
		
		popUp((new StringBuilder("Tu ")).append(io.risultato).append(" / Lui ").append(computer.risultato).toString(), result.toString());
		if((io.risultato >= 21 || computer.risultato >= 21) && io.risultato != computer.risultato)
		{
			if(io.risultato >= computer.risultato)
			{
				if(difficolta != DIFFICILE)
				{
					popUp("Fine della partita!", "Vittoria!");
				} else
				{
					popUp("Fine della partita", "Gioca in modalità difficile per aumentare la difficoltà dell'AI");
				}
			} else
			{
				popUp("fine della partita", "Hai perso!");
			}
			io.risultato = 0;
			computer.risultato = 0;
		}
		inizializzazione();
	}
	
	private CoppiaDaProvare intelligenzaArtificiale(LinkedList<CoppiaDaProvare> daProvare) {
		//ScopaSimple scopaClone = new ScopaSimple(dato, centrale, computer, io, difficolta);
		double maxiOttenuto = -50D;
		CoppiaDaProvare migliore = null;
		for(Iterator<CoppiaDaProvare> iterator = daProvare.iterator(); iterator.hasNext();) {
			CoppiaDaProvare attuale = iterator.next();
			double risultatoTotale = 0.0D;
			int diff = 0;
			switch(difficolta) {
			case DIFFICILE:
				diff = 50000;
				break;
				
			case FACILE:
				diff = 2;
				break;
			}
			int n = difficolta != DIFFICILE ? diff : diff / (daProvare.size() * (dato.size() + 5));
			for(int i = 0; i < n; i++)
			{
				//scopaClone.reset();
				//scopaClone.giocataMigliore(scopaClone.computer, migliore.carte, migliore.raccolta);
				//scopaClone.giocaTutto();
				//risultatoTotale += scopaClone.deltaScore;
			}
			
			risultatoTotale /= n;
			if(risultatoTotale > maxiOttenuto) {
				maxiOttenuto = risultatoTotale;
				migliore = attuale;
			}
		}
		if(maxiOttenuto > 4D && !carteNoValue && (difficolta & DIFFICILE)!=0) {
			popUp("EHY! ","il tuo avversario ha fatto una vittoria totale!!!");
			carteNoValue = true;
		}
		return migliore;
	}
	
/*	public String difficultString() {
		switch(difficolta) {
		case FACILE:
			return "facile";
		case DIFFICILE:
			return "difficile";
		default:
			return "bug difficultString() scopa";
		}
	}*/
	
	protected void popUp(String titolo, String testo)
	{
		JOptionPane.showMessageDialog(finestra, testo, titolo, 1);
	}
	
	/*TODO LIST:
	 * * Artificial Intelligence CLASS
	 * * grafica metodi
	 */
}