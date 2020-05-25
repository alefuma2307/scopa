package scopa;

public enum Color {
	cuori, ori, fiori, picche;

	public static Color getColor (int a) {	
		if(a==1) {
			return cuori;
		}else {
			if(a==2) {
				return ori; 
			}else {
				if(a==3) {
					return fiori;
				}else {
					return picche;
				}
			}
		}
	}
}
// questa classe crea i colori da assegnare alle carte