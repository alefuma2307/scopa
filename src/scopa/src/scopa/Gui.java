package scopa;

import java.awt.EventQueue;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;

import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.awt.GridLayout;
import java.awt.Image;

public class Gui extends JFrame{
	static Scopa gioco = new Scopa();
	static Gui window = new Gui(gioco);
	private JFrame frame;
	private JTextField txtPunteggio;
	private static final long serialVersionUID = 1L;
	JMenuItem rigioca;
	JMenuItem esci;
	JMenuItem FACILE;
	JMenuItem DIFFICILE;
	JPanel alto;
	JPanel medio;
	JPanel basso;
	JPanel panel;
	JPanel panel_2;
	JPanel panel_4;
	JPanel panel_1;
	JPanel panel_sc = new JPanel(new BorderLayout());
	static JLabel label_1_1;
	static JLabel label_1_2;
	static JLabel label_1_3;
	static JLabel label_1_1_1;
	static JLabel label_1_2_1;
	static JLabel label_1_3_1;
	static JLabel label_1_1_1_1;
	static JLabel label_1_1_1_2;
	static JLabel label_1_1_1_3;
	static JLabel label_1_1_1_4;
	static JLabel label_1_1_1_5 ;
	static JLabel label_1_1_1_6 ;
	static JLabel label_1_1_1_7 ;
	static JLabel label_1_1_1_8 ;
	static JLabel label_1_1_1_9 ;
	static JLabel label_4_1 = new JLabel();
	static JLabel label_3_1 = new JLabel();
	static JLabel label_2_1 = new JLabel();
	static JLabel label_5_1 = new JLabel();
	static JLabel label_6_1 = new JLabel();
	private JMenuBar menu;
	private JMenu difficolta;
	int smazzo = 30;
	Select ml = new Select();
	
	
	
public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gioco.inizializzazione();
					window.initialize();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Gui(Scopa scopa) {
		
		
		gioco = scopa;
		
	}

	void disegna(Scopa scopa) {
		//setContentPane(buildContentPane(scopa));
	}

	public void initialize() {
	
		ImageIcon carta = new ImageIcon(getClass().getResource("carte/retro.jpg"));
		frame = new JFrame("SCOPA");
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		label_1_1_1_1 = new JLabel(carta);
		label_1_1_1_2 = new JLabel(carta);
		label_1_1_1_3 = new JLabel(carta);
		label_1_1_1_4 = new JLabel(carta);
		label_1_1_1_5 = new JLabel(carta);
		label_1_1_1_6 = new JLabel(carta);
		label_1_1_1_7 = new JLabel(carta);
		label_1_1_1_8 = new JLabel(carta);
		label_1_1_1_9 = new JLabel(carta);
		label_1_1 = new JLabel(carta);
		label_1_2 = new JLabel(carta);
		label_1_3 = new JLabel(carta);
		label_1_1_1 = new JLabel(carta);
		label_1_2_1 = new JLabel(carta);
		label_1_3_1 = new JLabel(carta);
		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.RED));
		panel.setBackground(Color.GREEN);
		frame.getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		panel_sc.setBackground(Color.green);
		panel.add(panel_sc, BorderLayout.CENTER);
		
		txtPunteggio = new JTextField();
		txtPunteggio.setText("punteggio");
		txtPunteggio.setColumns(10);
		txtPunteggio.setEnabled(false);
		
		JLabel label = new JLabel(carta);//mazzo
		 
		panel.add(label, BorderLayout.SOUTH);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.RED));
		panel_1.setBackground(Color.GREEN);
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label_2 = new JLabel(carta);//g1 carta
		label_2.setMaximumSize(new Dimension(400,200));
		
		panel_1.add(label_2, BorderLayout.NORTH);
		
		JLabel label_3 = new JLabel(carta);//g2 carte

		panel_1.add(label_3, BorderLayout.SOUTH);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.BLUE));
		panel_2.setBackground(Color.GREEN);
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(1, 3));
		//g2
		Label label_1 = new Label();
		panel_2.add(label_1);		
		JLabel label_1_5 = new JLabel();
		panel_2.add(label_1_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.BLUE));
		panel_3.setBackground(Color.GREEN);
		frame.getContentPane().add(panel_3, BorderLayout.NORTH);
		
		JLabel label_1_6 = new JLabel("-");
		panel_3.add(label_1_6);
		

		panel_3.add(label_1_1_1);
		

		panel_3.add(label_1_2_1);
		
	
		panel_3.add(label_1_3_1);
		
		
		JLabel label_1_5_1 = new JLabel();
		panel_3.add(label_1_5_1);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(60, 179, 113));
		frame.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
	
	
		System.out.println(gioco.io.gioco);
		upTable(gioco.io.gioco, gioco.centrale, gioco.computer.gioco, 0,0,0,0);		
	}
	private JLabel disable (JLabel l ) {
		
		l.setEnabled(false);
		l.setVisible(false);
		return l;
	}
	private JLabel able(JLabel l ) {
		l.setEnabled(true);
		l.setVisible(true);
		l.addMouseListener(ml);
		return l;
	}
	public void upTable(Mazzo gioco, Mazzo tavolo, Mazzo cmp, int puntg1, int puntcmp, int scopag1, int scopacmp) {
		
		int sgiocatore;
		int stavolo;
		int scmp;
		
		scmp = cmp.size();
		stavolo = tavolo.size();
		sgiocatore = gioco.size();
		System.out.println("tavolo da " +stavolo);
		System.out.println("mano da "+sgiocatore);
		label_1_1.setVisible(false);
		label_1_2.setVisible(false);
		label_1_3.setVisible(false);
		label_1_1_1_1.setVisible(false);
		label_1_1_1_2.setVisible(false);
		label_1_1_1_3.setVisible(false);
		label_1_1_1_4.setVisible(false);
		label_1_1_1_5.setVisible(false);
		label_1_1_1_6.setVisible(false);
		label_1_1_1_7.setVisible(false);
		label_1_1_1_8.setVisible(false);
		label_1_1_1_9.setVisible(false);
		label_1_1_1.setVisible(false);
		label_1_2_1.setVisible(false);
		label_1_3_1.setVisible(false);
		label_4_1.setVisible(false);
		label_2_1.setVisible(false);
		label_3_1.setVisible(false);
		label_5_1.setVisible(false);
		label_6_1.setVisible(false);
		panel_2.remove(label_1_1);
		panel_2.remove(label_1_2);
		panel_2.remove(label_1_3);
		panel_4.remove(label_1_1_1_1);
		panel_4.remove(label_1_1_1_2);
		panel_4.remove(label_1_1_1_3);
		panel_4.remove(label_1_1_1_4);
		panel_4.remove(label_1_1_1_5);
		panel_4.remove(label_1_1_1_6);
		panel_4.remove(label_1_1_1_7);
		panel_4.remove(label_1_1_1_8);
		panel_4.remove(label_1_1_1_9);
		switch(scmp) {
		case 1 : 
			label_1_1_1.setVisible(true);
			break;
		case 2 :
			label_1_1_1.setVisible(true);
			label_1_2_1.setVisible(true);
			break;
		case 3 :
			label_1_1_1.setVisible(true);
			label_1_2_1.setVisible(true);
			label_1_3_1.setVisible(true);
			break;
		default : 
	
			break;
			
		}
		switch(sgiocatore) {
			case 1:
				System.out.println("g1");
				label_1_1= gioco.get(0).image();
				label_1_1 = able (label_1_1);
				label_1_2 = disable(label_1_2);
				label_1_3 = disable(label_1_3);
				break;
			case 2:
				System.out.println("g2");
				label_1_1=gioco.get(0).image();
				label_1_1 = able (label_1_1);
				label_1_2 = gioco.get(1).image();
				label_1_2 = able (label_1_2);
				label_1_3 = disable(label_1_3);
				break;
			case 3:
				System.out.println("g3");
				label_1_1=gioco.get(0).image();
				label_1_1 = able (label_1_1);
				label_1_2 = gioco.get(1).image();
				label_1_2 = able (label_1_2);
				label_1_3 = gioco.get(2).image();
				label_1_3 = able (label_1_3);
				break;
			default :
				JOptionPane.showMessageDialog(frame, "turno finito");
				smazzo = smazzo - 6 ;
			
			
				break;		
		}
		label_1_1.setName("uno");
		label_1_2.setName("due");
		label_1_3.setName("tre");
		switch(stavolo) {
			case 1 :
				//System.out.println("t1");
				label_1_1_1_1 = tavolo.peekFirst().image();
				label_1_1_1_1.setVisible(true);
				label_1_1_1_2 = disable(label_1_1_1_2);
				label_1_1_1_3 = disable(label_1_1_1_3);
				label_1_1_1_4 = disable(label_1_1_1_4);
				label_1_1_1_5 = disable(label_1_1_1_5);
				label_1_1_1_6 = disable(label_1_1_1_6);
				label_1_1_1_7 = disable(label_1_1_1_7);
				label_1_1_1_8 = disable(label_1_1_1_8);
				label_1_1_1_9 = disable(label_1_1_1_9);
				break;
			case 2 :
				//System.out.println("t2");
				label_1_1_1_1 = tavolo.peekFirst().image();
				label_1_1_1_1.setVisible(true);
				label_1_1_1_2 = tavolo.peekLast().image();
				label_1_1_1_2.setVisible(true);
				label_1_1_1_3 = disable(label_1_1_1_3);
				label_1_1_1_4 = disable(label_1_1_1_4);
				label_1_1_1_5 = disable(label_1_1_1_5);
				label_1_1_1_6 = disable(label_1_1_1_6);
				label_1_1_1_7 = disable(label_1_1_1_7);
				label_1_1_1_8 = disable(label_1_1_1_8);
				label_1_1_1_9 = disable(label_1_1_1_9);
				break;
			case 3 :
				//System.out.println("t3");
				label_1_1_1_1 = tavolo.peekFirst().image();
				label_1_1_1_1.setVisible(true);
				label_1_1_1_2 = tavolo.get(1).image();
				label_1_1_1_2.setVisible(true);
				label_1_1_1_3 = tavolo.getLast().image();
				label_1_1_1_3.setVisible(true);
				label_1_1_1_4 = disable(label_1_1_1_4);
				label_1_1_1_5 = disable(label_1_1_1_5);
				label_1_1_1_6 = disable(label_1_1_1_6);
				label_1_1_1_7 = disable(label_1_1_1_7);
				label_1_1_1_8 = disable(label_1_1_1_8);
				label_1_1_1_9 = disable(label_1_1_1_9);
				break;
			case 4 :
				//System.out.println("t4");
				label_1_1_1_1 = tavolo.peekFirst().image();
				label_1_1_1_1.setVisible(true);
				label_1_1_1_2 = tavolo.get(1).image();
				label_1_1_1_2.setVisible(true);
				label_1_1_1_3 = tavolo.get(2).image();
				label_1_1_1_3.setVisible(true);
				label_1_1_1_4 = tavolo.getLast().image();
				label_1_1_1_4.setVisible(true);
				label_1_1_1_5 = disable(label_1_1_1_5);
				label_1_1_1_6 = disable(label_1_1_1_6);
				label_1_1_1_7 = disable(label_1_1_1_7);
				label_1_1_1_8 = disable(label_1_1_1_8);
				label_1_1_1_9 = disable(label_1_1_1_9);
				break;
			case 5 :
				//System.out.println("t5");
				label_1_1_1_1 = tavolo.peekFirst().image();
				label_1_1_1_1.setVisible(true);
				label_1_1_1_2 = tavolo.get(1).image();
				label_1_1_1_2.setVisible(true);
				label_1_1_1_3 = tavolo.get(2).image();
				label_1_1_1_3.setVisible(true);
				label_1_1_1_4 = tavolo.get(3).image();
				label_1_1_1_4.setVisible(true);
				label_1_1_1_5 = tavolo.peekLast().image();
				label_1_1_1_5.setVisible(true);
				label_1_1_1_6 = disable(label_1_1_1_6);
				label_1_1_1_7 = disable(label_1_1_1_7);
				label_1_1_1_8 = disable(label_1_1_1_8);
				label_1_1_1_9 = disable(label_1_1_1_9);
				break;
			case 6 :
				//System.out.println("t6");
				label_1_1_1_1 = tavolo.peekFirst().image();
				label_1_1_1_1.setVisible(true);
				label_1_1_1_2 = tavolo.get(1).image();
				label_1_1_1_2.setVisible(true);
				label_1_1_1_3 = tavolo.get(2).image();
				label_1_1_1_3.setVisible(true);
				label_1_1_1_4 = tavolo.get(3).image();
				label_1_1_1_4.setVisible(true);
				label_1_1_1_5 = tavolo.get(4).image();
				label_1_1_1_5.setVisible(true);
				label_1_1_1_6 = tavolo.peekLast().image();
				label_1_1_1_6.setVisible(true);
				label_1_1_1_7 = disable(label_1_1_1_7);
				label_1_1_1_8 = disable(label_1_1_1_8);
				label_1_1_1_9 = disable(label_1_1_1_9);
				break;
			case 7 :
				//System.out.println("t7");
				label_1_1_1_1 = tavolo.peekFirst().image();
				label_1_1_1_1.setVisible(true);
				label_1_1_1_2 = tavolo.get(1).image();
				label_1_1_1_2.setVisible(true);
				label_1_1_1_3 = tavolo.get(2).image();
				label_1_1_1_3.setVisible(true);
				label_1_1_1_4 = tavolo.get(3).image();
				label_1_1_1_4.setVisible(true);
				label_1_1_1_5 = tavolo.get(4).image();
				label_1_1_1_5.setVisible(true);
				label_1_1_1_6 = tavolo.get(5).image();
				label_1_1_1_6.setVisible(true);
				label_1_1_1_7 = tavolo.peekLast().image();
				label_1_1_1_7.setVisible(true);
				label_1_1_1_8 = disable(label_1_1_1_8);
				label_1_1_1_9 = disable(label_1_1_1_9);
				break;
			case 8 :
				//System.out.println("t8");
				label_1_1_1_1 = tavolo.peekFirst().image();
				label_1_1_1_1.setVisible(true);
				label_1_1_1_2 = tavolo.get(1).image();
				label_1_1_1_2.setVisible(true);
				label_1_1_1_3 = tavolo.get(2).image();
				label_1_1_1_3.setVisible(true);
				label_1_1_1_4 = tavolo.get(3).image();
				label_1_1_1_4.setVisible(true);
				label_1_1_1_5 = tavolo.get(4).image();
				label_1_1_1_5.setVisible(true);
				label_1_1_1_6 = tavolo.get(5).image();
				label_1_1_1_6.setVisible(true);
				label_1_1_1_7 = tavolo.get(6).image();
				label_1_1_1_7.setVisible(true);
				label_1_1_1_8 = tavolo.peekLast().image();
				label_1_1_1_8.setVisible(true);
				label_1_1_1_9 = disable(label_1_1_1_9);
				break;
			case 9 :
				//System.out.println("t9");
				label_1_1_1_1 = tavolo.peekFirst().image();
				label_1_1_1_1.setVisible(true);
				label_1_1_1_2 = tavolo.get(1).image();
				label_1_1_1_2.setVisible(true);
				label_1_1_1_3 = tavolo.get(2).image();
				label_1_1_1_3.setVisible(true);
				label_1_1_1_4 = tavolo.get(3).image();
				label_1_1_1_4.setVisible(true);
				label_1_1_1_5 = tavolo.get(4).image();
				label_1_1_1_5.setVisible(true);
				label_1_1_1_6 = tavolo.get(5).image();
				label_1_1_1_6.setVisible(true);
				label_1_1_1_7 = tavolo.get(6).image();
				label_1_1_1_7.setVisible(true);
				label_1_1_1_8 = tavolo.get(7).image();
				label_1_1_1_8.setVisible(true);
				label_1_1_1_9 = tavolo.peekLast().image();
				label_1_1_1_9.setVisible(true);
				break;
			default :
				label_1_1_1_1 = disable(label_1_1_1_1);
				label_1_1_1_2 = disable(label_1_1_1_2);
				label_1_1_1_3 = disable(label_1_1_1_3);
				label_1_1_1_4 = disable(label_1_1_1_4);
				label_1_1_1_5 = disable(label_1_1_1_5);
				label_1_1_1_6 = disable(label_1_1_1_6);
				label_1_1_1_7 = disable(label_1_1_1_7);
				label_1_1_1_8 = disable(label_1_1_1_8);
				label_1_1_1_9 = disable(label_1_1_1_9);
				JOptionPane.showMessageDialog(frame, "scopaaaaa!!");
				break;
				
		}

		panel_2.add(label_1_1 );
		panel_2.add(label_1_2);
		panel_2.add(label_1_3);
		panel_4.add(label_1_1_1_1);
		panel_4.add(label_1_1_1_2);
		panel_4.add(label_1_1_1_3);
		panel_4.add(label_1_1_1_4);
		panel_4.add(label_1_1_1_5);
		panel_4.add(label_1_1_1_6);
		panel_4.add(label_1_1_1_7);
		panel_4.add(label_1_1_1_8);
		panel_4.add(label_1_1_1_9);	
		label_2_1.setText("  gct  "+puntg1);
		label_3_1.setText("cmp  "+puntcmp);
		label_2_1.setVisible(true);
		label_3_1.setVisible(true);
		panel_1.add(label_2_1, BorderLayout.EAST);
		panel_1.add(label_3_1, BorderLayout.WEST);
		label_4_1.setText("carte in mazzo "+ smazzo);
		label_4_1.setBackground(Color.white);
		label_4_1.setVisible(true);
		label_5_1.setText("scope cmp "+scopacmp);
		label_6_1.setText("scopa gct "+scopag1);
		label_5_1.setVisible(true);
		label_6_1.setVisible(true);
		panel_sc.add(label_5_1, BorderLayout.WEST);
		panel_sc.add(label_6_1, BorderLayout.EAST);
		panel.add(label_4_1, BorderLayout.NORTH);
	}
		
	
	
	/*private JPanel buildContentPanel () {
		StringBuilder titolo = new StringBuilder();
		titolo.append((new StringBuilder("SCOPA (")));
	} STO FACENDO LO STRING BUILDER MA DEVO PRIMA COSTRUIRE LA CLASSE CON LE DIFFICOLTA, SCORE E TURNO*/
	
	 
	/*private JPanel buildContentPane(Scopa scopa) {
		StringBuilder titolo = new StringBuilder();
		titolo.append((new StringBuilder("SCOPA (")).append(scopa.difficultString()).append(")          Score: ").toString());
		titolo.append((new StringBuilder(String.valueOf(scopa.io.risultato))).append(" / ").append(scopa.computer.risultato).toString());
		titolo.append((new StringBuilder("          Tocca a : ")).append(scopa.myturn ? "te" : "L'avversario").toString());
		 if(scopa.booleanScopa)
	     {
			 titolo.append("          !!!!!!   SCOPA   !!!!!!   SCOPA   !!!!!!   SCOPA   !!!!!!");
	     }
		 setTitle(titolo.toString());
		 alto.removeAll();
		 for(int i = 0; i < scopa.computer.gioco.size(); i++) {
			 alto.add(new JLabel(new ImageIcon(getClass().getResource("0.png"))));
		 }
		 medio.removeAll();
		 
		 if(!scopa.centrale.isEmpty()) {
			 AssCarte carte;
			 
			 for(Iterator<AssCarte> iter = scopa.centrale.iterator(); iter.hasNext(); basso.add(carte.pulsante(scopa))){
				 carte = (AssCarte)iter.next();
			 }
		 }
		 basso.removeAll();
		 AssCarte carte;
		 for(Iterator<AssCarte> iter = scopa.io.gioco.iterator(); iter.hasNext(); basso.add(carte.pulsante(scopa))) {
			 carte = (AssCarte)iter.next();
		 }
		 
		 panel.add(alto);
		 panel.add(medio);
		 panel.add(basso);
		 panel.setBackground(new Color(0, 150, 0));
		 return panel;
	}
	
	public void disegnaPiega(Scopa scopa, AssCarte carte, Mazzo raccolta) {
		medio.removeAll();
		 if(!scopa.myturn) {
			 alto.remove(0); 
		 }
		 if(!scopa.centrale.isEmpty()) {
			AssCarte exec;
			for(Iterator<?> iter = scopa.centrale.iterator(); iter.hasNext(); medio.add(raccolta.contains(exec) ? ((java.awt.Component) (exec.imageSel())) : ((java.awt.Component) (exec.image())))) {
				exec = (AssCarte)iter.next();
			}
			
		 }
		 medio.add(carte.image());
	}*/
	
	public class Select implements MouseListener {


		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
				if(arg0.getComponent().getName()=="uno") {
					gioco.myturn(gioco.io.gioco.get(0));

				}else {
						if(arg0.getComponent().getName() == "due") {
							gioco.myturn(gioco.io.gioco.get(1));
						
						}else if (arg0.getComponent().getName()=="tre") {
								gioco.myturn(gioco.io.gioco.get(2));	
						}
				}
				
				System.out.println("\n\ntavolo dopo gioco utente"+ gioco.centrale+"mano"+gioco.io.gioco);
		
				window.upTable(gioco.io.gioco, gioco.centrale, gioco.computer.gioco, gioco.io.risultato, gioco.computer.risultato, gioco.io.numScopa, gioco.computer.numScopa);
				//JOptionPane.showMessageDialog(frame, "turno del computer");
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gioco.compturn();	
				System.out.println("\n\ntavolo dopo gioco computer"+ gioco.centrale+"mano"+gioco.io.gioco);
				window.upTable(gioco.io.gioco, gioco.centrale, gioco.computer.gioco, gioco.io.risultato, gioco.computer.risultato, gioco.io.numScopa, gioco.computer.numScopa);
				//JOptionPane.showMessageDialog(frame, "tuo turno");
				
		
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		Dimension size = new Dimension();
		int width;
		int height;
			size = arg0.getComponent().getSize();
			height = ( int ) size.getHeight()-10;
			width = (int) size.getWidth()-10;
			arg0.getComponent().setSize(width, height);
			
		
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			Dimension size = new Dimension();
			int width;
			int height;
				size = arg0.getComponent().getSize();
				height = ( int ) size.getHeight()+10;
				width = (int) size.getWidth()+10;
				arg0.getComponent().setSize(width, height);
				
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		 
	 }
}
