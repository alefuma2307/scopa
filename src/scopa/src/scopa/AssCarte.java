package scopa;

import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public enum AssCarte {
	CUORI_1(1, Color.cuori),
	CUORI_2(2, Color.cuori),
	CUORI_3(3, Color.cuori),
	CUORI_4(4, Color.cuori),
	CUORI_5(5, Color.cuori),
	CUORI_6(6, Color.cuori),
	CUORI_7(7, Color.cuori),
	CUORI_8(8, Color.cuori),
	CUORI_9(9, Color.cuori),
	CUORI_10(10, Color.cuori),
	ORI_1(1, Color.ori),
	ORI_2(2, Color.ori),
	ORI_3(3, Color.ori),
	ORI_4(4, Color.ori),
	ORI_5(5, Color.ori),
	ORI_6(6, Color.ori),
	ORI_7(7, Color.ori),
	ORI_8(8, Color.ori),
	ORI_9(9, Color.ori),
	ORI_10(10, Color.ori),
	FIORI_1(1, Color.fiori),
	FIORI_2(2, Color.fiori),
	FIORI_3(3, Color.fiori),
	FIORI_4(4, Color.fiori),
	FIORI_5(5, Color.fiori),
	FIORI_6(6, Color.fiori),
	FIORI_7(7, Color.fiori),
	FIORI_8(8, Color.fiori),
	FIORI_9(9, Color.fiori),
	FIORI_10(10, Color.fiori),
	PICCHE_1(1, Color.picche),
	PICCHE_2(2, Color.picche),
	PICCHE_3(3, Color.picche),
	PICCHE_4(4, Color.picche),
	PICCHE_5(5, Color.picche),
	PICCHE_6(6, Color.picche),
	PICCHE_7(7, Color.picche),
	PICCHE_8(8, Color.picche),
	PICCHE_9(9, Color.picche),
	PICCHE_10(10, Color.picche);
	
	private final int value;
	private final Color color;
	
	private static AssCarte semi[][];
    static {
    	semi = new AssCarte[10][Color.values().length];
    	for (AssCarte carte : AssCarte.values()) {
			semi[carte.value - 1][carte.color.ordinal()] = carte;
		}
    }
    public static AssCarte getCarte(int a, Color color)
    {
        return semi[a - 1][color.ordinal()];
    }

    private AssCarte(int a, Color b)
    {
        value = a;
        color = b;
    }

    public String toString()
    {
        return (new StringBuilder(String.valueOf(Integer.toString(value)))).append(color).toString();
    }
    
    public JLabel image()
    {
        return new JLabel(getImage());
    }
    
 
    
    private ImageIcon getImage()
    {
    	 StringBuilder sb = new StringBuilder();
         sb.append((new StringBuilder("carte/")).append(value).toString()); 
         switch(color)
         {
         case picche:
             sb.append("picche");
             break;

         case cuori:
             sb.append("cuori");
             break;

         case ori:
             sb.append("ori");
             break;

         case fiori:
             sb.append("fiori");
             break;
         }
 
         sb.append(".png");
         return new ImageIcon(getClass().getResource(sb.toString()));
    }
    
    
    public PulsanteCarte pulsante(ActionListener actionListener)
    {
        PulsanteCarte pulsante = new PulsanteCarte(getImage(), this);
        pulsante.setMargin(new Insets(0, 0, 0, 0));
        pulsante.addActionListener(actionListener);
        return pulsante;
    }

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}
}
