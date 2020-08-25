package scopa;

public class CoppiaDaProvare {
	public AssCarte carte;
	public Mazzo raccolta;
	
	public CoppiaDaProvare(AssCarte carte0, Mazzo mazzo0) {
		carte = carte0;
		raccolta = mazzo0;
	}
	
	 public String toString()
	    {
	        return (new StringBuilder(String.valueOf(carte.toString()))).append(raccolta).toString();
	    }
}
