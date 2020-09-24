package scopa;

import java.util.Iterator;
import java.util.LinkedList;

public class Mazzo extends LinkedList<AssCarte> {
	
	private static final long serialVersionUID = 0L; 
	
	public Mazzo()
    {
    }
	
	public AssCarte removeCartaRandom()
    {
        return (AssCarte)remove((int)(Math.random() * (double)size()));
    }
	
	public static Mazzo getSemi()
    {
        Mazzo source = new Mazzo();
        for(int i = 1; i < 11; i++)
        {
            source.add(AssCarte.getCarte(i, Color.ori));
            source.add(AssCarte.getCarte(i, Color.fiori));
            source.add(AssCarte.getCarte(i, Color.picche));
            source.add(AssCarte.getCarte(i, Color.cuori));
        }

        return source.cloneMix();
    }
	
	public Mazzo cloneMix()
    {
        Mazzo ret = new Mazzo();
        for(int i = 0; i < 40; i++)
        {
            ret.add(removeCartaRandom());
        }

        return ret;
    }
	
	public LinkedList<Mazzo> combinazioni(){
		LinkedList<Mazzo> ret = new LinkedList<Mazzo>();
        int size = size();
        Mazzo element = new Mazzo();
		for(int i = 0; i < size; i++)
        {
            element.clear();
            element.add((AssCarte)get(i));
            ret.add(element.clone());
        }
        if(size > 1)
        {
            for(int i = 0; i < size; i++)
            {
                for(int j = i + 1; j < size; j++)
                {
                    element.clear();
                    element.add((AssCarte)get(i));
                    element.add((AssCarte)get(j));
                    ret.add(element.clone());
                }

            }

        }
        if(size > 2)
        {
            for(int i = 0; i < size; i++)
            {
                for(int j = i + 1; j < size; j++)
                {
                    for(int k = j + 1; k < size; k++)
                    {
                        element.clear();
                        element.add((AssCarte)get(i));
                        element.add((AssCarte)get(j));
                        element.add((AssCarte)get(k));
                        ret.add(element.clone());
                    }

                }

            }

        }
        if(size > 3)
        {
            for(int i = 0; i < size; i++)
            {
                for(int j = i + 1; j < size; j++)
                {
                    for(int k = j + 1; k < size; k++)
                    {
                        for(int l = k + 1; l < size; l++)
                        {
                            element.clear();
                            element.add((AssCarte)get(i));
                            element.add((AssCarte)get(j));
                            element.add((AssCarte)get(k));
                            element.add((AssCarte)get(l));
                            ret.add(element.clone());
                        }

                    }

                }

            }

        }
        return ret;
	}
	
	public int score() {
		int ori = 0;
		int score = 0;
		int numCarte = 0;
		double sette = 0.0D;
		boolean unduetre[] = new boolean[10]; 
		for(Iterator<?> iterator = iterator(); iterator.hasNext();) {
			AssCarte carte = (AssCarte)iterator.next();
			int value = carte.getValue();
			if(carte.getColor() == Color.ori) {
				ori++;
				if(value == 7) {
					score++;
				}
				unduetre[value - 1] = true;
			}
			numCarte++;
			if(value <= 7) {
				sette += Math.pow(10D, value - 7);
			}
		}
		
		if (ori > 5) {
			score++;
		}
		if(numCarte > 20) {
			score++;
		}
		if(sette > 2.2222222199999999D)
        {
            score++;
        }
		int n;
		for(n = 0; unduetre[n];) {
			if(++n == 10)
            {
                return 21;
            }
		}
		
		if(n >= 3)
        {
            score += n;
        }
		return score;
	}
	
	public int[] risultato() {
		int ret[] = new int[4];
		int ori = 0;
		int numCarte = 0;
		double sette = 0.0D;
		for(Iterator<?> iterator = iterator(); iterator.hasNext();) {
			AssCarte carte = (AssCarte)iterator.next();
			int value = carte.getValue();
			if(carte.getColor() == Color.ori) {
				ori++;
				if(value == 7) {
					ret[3] = 1;
				}
			}
			numCarte++;
			if(value <= 7) {
				sette += Math.pow(10D, value -7);
			}
		}
		ret[0] = sette <= 2.2222222199999999D ? 0 : 1;
        ret[1] = numCarte;
        ret[2] = ori;
		return ret;
	}
	
	public int somma() {
		int ret = 0;
		int i = 0;
		for(i=0; i< size(); i++) {
			ret += ((AssCarte)get(i)).getValue();
		}
		return ret;
	}
	
	public Mazzo clone()
    {
        return (Mazzo)super.clone();
    }
}
