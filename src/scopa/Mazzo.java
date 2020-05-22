package scopa;

import java.util.Iterator;
import java.util.LinkedList;

public class Mazzo extends LinkedList<AssCarte> {
	
	private static final long serialVersionUID = 0L; //non so cosa sia ma guardaci
	
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
	
	/*DEVO FARE IL METODO DI CONTEGGIO PUNTI IN BASE ALLE CARTE E LO SCORE FINALE*/
		/*LO FACCIO IO --FILIPPO --*/
	
	public Mazzo clone()
    {
        return (Mazzo)super.clone();
    }
}
