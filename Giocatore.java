package scopa;

public class Giocatore {
	public Mazzo gioco;
	public Mazzo raccolta;
	public int risultato;
	public int numScopa;
	
	Giocatore(){
		risultato = 0;
		numScopa = 0;
		gioco = new Mazzo();
		raccolta = new Mazzo();
	}
	
	public void clear() {
		gioco.clear();
		raccolta.clear();
		numScopa = 0;
	}
	
	public Giocatore clone() {
		Giocatore ret = new Giocatore();
		ret.gioco = gioco.clone();
		ret.raccolta = raccolta.clone();
		ret.risultato = risultato;
		ret.numScopa = numScopa;
		return ret;
	}
	
	public int risultato(){
		return Math.min(raccolta.score() + numScopa, 21);
    }
}
