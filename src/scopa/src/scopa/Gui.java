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
	static Scopa gioco = new Scopa(); //creo l'oggetto di gioco
	static Gui window = new Gui();
	private JFrame frame;//finestra
	private JTextField txtPunteggio;//box del punteggio
	JMenuItem rigioca;
	JMenuItem esci;
	JMenuItem FACILE;
	JMenuItem DIFFICILE;
	/*JPanel alto;
	JPanel medio;
	JPanel basso;*/
	JPanel panel;
	JPanel panel_2;
	JPanel panel_4;
	JPanel panel_1;
	JPanel panel_sc = new JPanel(new BorderLayout());
	//label carte giocatore
	static JLabel label_1_1;
	static JLabel label_1_2;
	static JLabel label_1_3;
	//label carte computer
	static JLabel label_1_1_1;
	static JLabel label_1_2_1;
	static JLabel label_1_3_1;
	//label carte centrali
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
	
	public Gui() {//costruttore
	
	}

	public void initialize() {
	
		ImageIcon carta = new ImageIcon(getClass().getResource("carte/retro.jpg"));
		frame = new JFrame("SCOPA");//metto il titolo
		frame.setBounds(100, 100, 900, 700);//metto la fimensione della finestra e la posizione
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//attivo i tasti finestra windows
		frame.setResizable(false);//non si può allargare la finestra
		frame.setVisible(true);//rendo la finestra visibile
		//label carte centrali
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
		panel = new JPanel();//istranzio il pannello
		panel.setBorder(new LineBorder(Color.RED));//setto il bordo del pannello
		panel.setBackground(Color.GREEN); //setto lo sfondo del pannello
		frame.getContentPane().add(panel, BorderLayout.EAST); //inserisco il pannello nel frame
		panel.setLayout(new BorderLayout(0, 0));
		panel_sc.setBackground(Color.green);
		panel.add(panel_sc, BorderLayout.CENTER);
		
		txtPunteggio = new JTextField();
		txtPunteggio.setText("punteggio");
		txtPunteggio.setColumns(10);
		txtPunteggio.setEnabled(false);
		//_________________________________________________
		JLabel label = new JLabel(carta);//mazzo	 
		panel.add(label, BorderLayout.SOUTH);
		//_________________________________________________
		panel_1 = new JPanel(); //pannello a sinistra
		panel_1.setBorder(new LineBorder(Color.RED));
		panel_1.setBackground(Color.GREEN);
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label_2 = new JLabel(carta);//g1 carta
		label_2.setMaximumSize(new Dimension(400,200));
		
		panel_1.add(label_2, BorderLayout.NORTH);
		
		JLabel label_3 = new JLabel(carta);//g2 carte

		panel_1.add(label_3, BorderLayout.SOUTH);
		//_________________________________________________
		panel_2 = new JPanel();//pannello del giocatore 
		panel_2.setBorder(new LineBorder(Color.BLUE));
		panel_2.setBackground(Color.GREEN);
		panel_2.setLayout(new GridLayout(1, 3));
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		Label label_1 = new Label();
		panel_2.add(label_1);		
		JLabel label_1_5 = new JLabel();
		panel_2.add(label_1_5);
		//_________________________________________________
		JPanel panel_3 = new JPanel(); //pannello del computer
		panel_3.setBorder(new LineBorder(Color.BLUE));
		panel_3.setBackground(Color.GREEN);
		frame.getContentPane().add(panel_3, BorderLayout.NORTH);
		panel_3.add(label_1_1_1);
		panel_3.add(label_1_2_1);	
		panel_3.add(label_1_3_1);	
		JLabel label_1_5_1 = new JLabel();
		panel_3.add(label_1_5_1);	
		//_________________________________________________
		panel_4 = new JPanel(); //pannello carte centrali
		panel_4.setBackground(new Color(60, 179, 113));
		frame.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		System.out.println(gioco.io.gioco);
		upTable(gioco);		
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
	public void upTable(Scopa gioco) {
		
		int sgiocatore;
		int stavolo;
		int scmp;
		
		scmp = gioco.computer.gioco.size();
		stavolo = gioco.centrale.size();
		sgiocatore = gioco.io.gioco.size();
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
				label_1_1= gioco.io.gioco.get(0).image();
				label_1_1 = able (label_1_1);
				label_1_2 = disable(label_1_2);
				label_1_3 = disable(label_1_3);
				break;
			case 2:
				System.out.println("g2");
				label_1_1=gioco.io.gioco.get(0).image();
				label_1_1 = able (label_1_1);
				label_1_2 = gioco.io.gioco.get(1).image();
				label_1_2 = able (label_1_2);
				label_1_3 = disable(label_1_3);
				break;
			case 3:
				System.out.println("g3");
				label_1_1=gioco.io.gioco.get(0).image();
				label_1_1 = able (label_1_1);
				label_1_2 = gioco.io.gioco.get(1).image();
				label_1_2 = able (label_1_2);
				label_1_3 = gioco.io.gioco.get(2).image();
				label_1_3 = able (label_1_3);
				break;
			default :
				JOptionPane.showMessageDialog(frame, "turno finito");
				gioco.smazzo = gioco.smazzo - 6 ;
				break;		
		}
		label_1_1.setName("uno");
		label_1_2.setName("due");
		label_1_3.setName("tre");
		switch(stavolo) {
			case 1 :
				//System.out.println("t1");
				label_1_1_1_1 = gioco.centrale.peekFirst().image();
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
				label_1_1_1_1 = gioco.centrale.peekFirst().image();
				label_1_1_1_1.setVisible(true);
				label_1_1_1_2 = gioco.centrale.peekLast().image();
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
				label_1_1_1_1 = gioco.centrale.peekFirst().image();
				label_1_1_1_1.setVisible(true);
				label_1_1_1_2 = gioco.centrale.get(1).image();
				label_1_1_1_2.setVisible(true);
				label_1_1_1_3 = gioco.centrale.getLast().image();
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
				label_1_1_1_1 = gioco.centrale.peekFirst().image();
				label_1_1_1_1.setVisible(true);
				label_1_1_1_2 = gioco.centrale.get(1).image();
				label_1_1_1_2.setVisible(true);
				label_1_1_1_3 = gioco.centrale.get(2).image();
				label_1_1_1_3.setVisible(true);
				label_1_1_1_4 = gioco.centrale.getLast().image();
				label_1_1_1_4.setVisible(true);
				label_1_1_1_5 = disable(label_1_1_1_5);
				label_1_1_1_6 = disable(label_1_1_1_6);
				label_1_1_1_7 = disable(label_1_1_1_7);
				label_1_1_1_8 = disable(label_1_1_1_8);
				label_1_1_1_9 = disable(label_1_1_1_9);
				break;
			case 5 :
				//System.out.println("t5");
				label_1_1_1_1 = gioco.centrale.peekFirst().image();
				label_1_1_1_1.setVisible(true);
				label_1_1_1_2 = gioco.centrale.get(1).image();
				label_1_1_1_2.setVisible(true);
				label_1_1_1_3 = gioco.centrale.get(2).image();
				label_1_1_1_3.setVisible(true);
				label_1_1_1_4 = gioco.centrale.get(3).image();
				label_1_1_1_4.setVisible(true);
				label_1_1_1_5 = gioco.centrale.peekLast().image();
				label_1_1_1_5.setVisible(true);
				label_1_1_1_6 = disable(label_1_1_1_6);
				label_1_1_1_7 = disable(label_1_1_1_7);
				label_1_1_1_8 = disable(label_1_1_1_8);
				label_1_1_1_9 = disable(label_1_1_1_9);
				break;
			case 6 :
				//System.out.println("t6");
				label_1_1_1_1 = gioco.centrale.peekFirst().image();
				label_1_1_1_1.setVisible(true);
				label_1_1_1_2 = gioco.centrale.get(1).image();
				label_1_1_1_2.setVisible(true);
				label_1_1_1_3 = gioco.centrale.get(2).image();
				label_1_1_1_3.setVisible(true);
				label_1_1_1_4 = gioco.centrale.get(3).image();
				label_1_1_1_4.setVisible(true);
				label_1_1_1_5 = gioco.centrale.get(4).image();
				label_1_1_1_5.setVisible(true);
				label_1_1_1_6 = gioco.centrale.peekLast().image();
				label_1_1_1_6.setVisible(true);
				label_1_1_1_7 = disable(label_1_1_1_7);
				label_1_1_1_8 = disable(label_1_1_1_8);
				label_1_1_1_9 = disable(label_1_1_1_9);
				break;
			case 7 :
				//System.out.println("t7");
				label_1_1_1_1 = gioco.centrale.peekFirst().image();
				label_1_1_1_1.setVisible(true);
				label_1_1_1_2 = gioco.centrale.get(1).image();
				label_1_1_1_2.setVisible(true);
				label_1_1_1_3 = gioco.centrale.get(2).image();
				label_1_1_1_3.setVisible(true);
				label_1_1_1_4 = gioco.centrale.get(3).image();
				label_1_1_1_4.setVisible(true);
				label_1_1_1_5 = gioco.centrale.get(4).image();
				label_1_1_1_5.setVisible(true);
				label_1_1_1_6 = gioco.centrale.get(5).image();
				label_1_1_1_6.setVisible(true);
				label_1_1_1_7 = gioco.centrale.peekLast().image();
				label_1_1_1_7.setVisible(true);
				label_1_1_1_8 = disable(label_1_1_1_8);
				label_1_1_1_9 = disable(label_1_1_1_9);
				break;
			case 8 :
				//System.out.println("t8");
				label_1_1_1_1 = gioco.centrale.peekFirst().image();
				label_1_1_1_1.setVisible(true);
				label_1_1_1_2 = gioco.centrale.get(1).image();
				label_1_1_1_2.setVisible(true);
				label_1_1_1_3 = gioco.centrale.get(2).image();
				label_1_1_1_3.setVisible(true);
				label_1_1_1_4 = gioco.centrale.get(3).image();
				label_1_1_1_4.setVisible(true);
				label_1_1_1_5 = gioco.centrale.get(4).image();
				label_1_1_1_5.setVisible(true);
				label_1_1_1_6 = gioco.centrale.get(5).image();
				label_1_1_1_6.setVisible(true);
				label_1_1_1_7 = gioco.centrale.get(6).image();
				label_1_1_1_7.setVisible(true);
				label_1_1_1_8 = gioco.centrale.peekLast().image();
				label_1_1_1_8.setVisible(true);
				label_1_1_1_9 = disable(label_1_1_1_9);
				break;
			case 9 :
				//System.out.println("t9");
				label_1_1_1_1 = gioco.centrale.peekFirst().image();
				label_1_1_1_1.setVisible(true);
				label_1_1_1_2 = gioco.centrale.get(1).image();
				label_1_1_1_2.setVisible(true);
				label_1_1_1_3 = gioco.centrale.get(2).image();
				label_1_1_1_3.setVisible(true);
				label_1_1_1_4 = gioco.centrale.get(3).image();
				label_1_1_1_4.setVisible(true);
				label_1_1_1_5 = gioco.centrale.get(4).image();
				label_1_1_1_5.setVisible(true);
				label_1_1_1_6 = gioco.centrale.get(5).image();
				label_1_1_1_6.setVisible(true);
				label_1_1_1_7 = gioco.centrale.get(6).image();
				label_1_1_1_7.setVisible(true);
				label_1_1_1_8 = gioco.centrale.get(7).image();
				label_1_1_1_8.setVisible(true);
				label_1_1_1_9 = gioco.centrale.peekLast().image();
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
				break;
				
		}
		//aggiungo le carte alò tavolo
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
		label_2_1.setText("  gct  "+gioco.io.risultato);
		label_3_1.setText("cmp  "+gioco.computer.risultato);
		label_2_1.setVisible(true);
		label_3_1.setVisible(true);
		panel_1.add(label_2_1, BorderLayout.EAST);
		panel_1.add(label_3_1, BorderLayout.WEST);
		label_4_1.setText("carte in mazzo "+ gioco.smazzo);
		label_4_1.setBackground(Color.white);
		label_4_1.setVisible(true);
		label_5_1.setText("scope gct "+gioco.io.numScopa+"\n");
		label_6_1.setText("scopa cmp "+gioco.computer.numScopa+"\n");
		label_5_1.setVisible(true);
		label_6_1.setVisible(true);
		panel_sc.add(label_5_1, BorderLayout.NORTH);
		panel_sc.add(label_6_1, BorderLayout.SOUTH);
		panel.add(label_4_1, BorderLayout.NORTH);
	}
		
	
	public class Select implements MouseListener {


		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			//controllo quale label è stata cliccata
				if(arg0.getComponent().getName()=="uno") {
					System.out.println("giocata la carta "+gioco.io.gioco.get(0).getValue());
					if(gioco.io.gioco.get(0).getValue()==1) {
						JOptionPane.showMessageDialog(frame, "asso prende tutto");
					}
					gioco.myturn(gioco.io.gioco.get(0));
					

				}else {
						if(arg0.getComponent().getName() == "due") {
							if(gioco.io.gioco.get(1).getValue()==1) {
								JOptionPane.showMessageDialog(frame, "asso prende tutto");
							}
							gioco.myturn(gioco.io.gioco.get(1));
							
						
						}else if (arg0.getComponent().getName()=="tre") {
							if(gioco.io.gioco.get(2).getValue()==1) {
								JOptionPane.showMessageDialog(frame, "asso prende tutto");
							}
								gioco.myturn(gioco.io.gioco.get(2));
								
						}
				}
				
				System.out.println("\n\ntavolo dopo gioco utente"+ gioco.centrale+"mano"+gioco.io.gioco);
		
				window.upTable(gioco);
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				AssCarte c = gioco.compturn();
				System.out.println("il computer ha giocato " + c.getValue() + " di "+c.getColor() );	
				System.out.println("\n\ntavolo dopo gioco computer"+ gioco.centrale+"mano"+gioco.io.gioco);
				window.upTable(gioco);
	
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
