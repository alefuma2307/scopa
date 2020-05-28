package scopa;

import java.awt.Toolkit;
import java.util.Iterator;
import java.util.LinkedList;
import java.io.*;

public class Scopa{
	private static final long serialVersionUID = 1L;
	public static final int FACILE = 2;
	public static final int DIFFICILE = 1;
	gui gui;
	Mazzo dato; //indica le carte uscite (ai giocatori o prese da questi ultimi)
	Mazzo centrale;
	AssCarte ultimaMano; //raccolta carte dal banco all'ultimo turno
	Mazzo ultimaPresa;
	Giocatore computer;
	Giocatore io;
	boolean myturn;
	public boolean booleanScopa;
	int difficolta;
	private boolean myUltimaMano;
	private Thread action;
	private boolean modeApplet;
	
	Scopa(boolean modeApplet1){
		booleanScopa = false;
		difficolta = DIFFICILE;
		action = new Thread();
		// gui = new gui(this, modeApplet1);
		modeApplet = modeApplet1;
		computer = new Giocatore();
		io = new Giocatore();
		dato = new Mazzo();
		centrale = new Mazzo();
	}
	
	void inizializzazione() {
		centrale.clear();
		computer.clear();
		io.clear();
		dato = Mazzo.getSemi();
		for(int i = 0; i < 4; i++)
		{
			centrale.add((AssCarte)dato.removeFirst());
		}
		ultimaMano = null;
		ultimaPresa = null;
		distribuzione();
		//grafica(); da fare per interfacciare mosse a GUI
		if(!myturn)
		{
			compturn();
		}
	}
	
	void distribuzione() {
		for(int i = 0; i<3; i++) {
			computer.gioco.add((AssCarte)dato.removeFirst());
			io.gioco.add((AssCarte)dato.removeFirst());
		}
		//grafica(); da fare per interfacciare mosse a GUI
	}
	
	void compturn() {
		try {
			Thread.sleep(1500L);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		LinkedList<CoppiaDaProvare> daProvare = new LinkedList<CoppiaDaProvare>();
		for(Iterator<?> iterator = computer.gioco.iterator(); iterator.hasNext();) {
			AssCarte carte = (AssCarte)iterator.next();
			if(carte.getValue() == 1) {
				daProvare.add(new CoppiaDaProvare(carte, centrale.clone()));
			} else {
				boolean collectAsso = false;
				boolean impossibleCollect = true;
				Iterator<?> iterator0 = centrale.combinazioni().iterator();
				while(iterator0.hasNext()) {
					Mazzo element = (Mazzo)iterator0.next();
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
		//CoppiaDaProvare intelligente = intelligenzaArtificiale(daProvare);
		//giocataMigliore(computer, intelligente.carte, intelligente.raccolta);
	}
	
	private void myturn(AssCarte carte) {
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
	
	private void giocataMigliore(Giocatore giocatore, AssCarte carte, Mazzo raccolta) {
		booleanScopa = false;
		giocatore.gioco.remove(carte);
		graficaBoh(carte, raccolta); //da guardare bene
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
				booleanScopa = true;
				Toolkit.getDefaultToolkit().beep();
			}
		}
		if(io.gioco.isEmpty() && computer.gioco.isEmpty()) {
			if(dato.isEmpty()) {
				fineTurno();
			} else {
				distribuzione();
			}
		}
		grafica();
	}
	
}