package scopa;

import java.awt.EventQueue;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.awt.GridLayout;
import java.awt.Image;

public class Gui extends JFrame{

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
	private JMenuBar menu;
	private JMenu difficolta;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Gui window = new Gui(Scopa scopa, boolean modeApplet);
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Gui(Scopa scopa,boolean modeApplet) {
		initialize();
	}

	void disegna(Scopa scopa) {
		setContentPane(buildContentPane(scopa));
	}

	public void initialize() {
		ImageIcon carta = new ImageIcon(getClass().getResource("carte/retro.jpg"));
	
		frame = new JFrame("SCOPA");
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.RED));
		panel.setBackground(Color.GREEN);
		frame.getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		txtPunteggio = new JTextField();
		txtPunteggio.setText("punteggio");
		panel.add(txtPunteggio, BorderLayout.NORTH);
		txtPunteggio.setColumns(10);
		
		JLabel label = new JLabel(carta);//mazzo
		 
		panel.add(label, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.RED));
		panel_1.setBackground(Color.GREEN);
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label_2 = new JLabel(carta);//g1 carta
		label_2.setMaximumSize(new Dimension(400,200));
		panel_1.add(label_2, BorderLayout.NORTH);
		
		JLabel label_3 = new JLabel(carta);//g2 carte
		panel_1.add(label_3, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.BLUE));
		panel_2.setBackground(Color.GREEN);
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		//g2
		Label label_1 = new Label();
		panel_2.add(label_1);
		
		JLabel label_1_1 = new JLabel(carta);
		panel_2.add(label_1_1);
		
		JLabel label_1_2 = new JLabel(carta);
		panel_2.add(label_1_2);
		
		JLabel label_1_3 = new JLabel(carta);
		panel_2.add(label_1_3);
		
		
		JLabel label_1_5 = new JLabel();
		panel_2.add(label_1_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.BLUE));
		panel_3.setBackground(Color.GREEN);
		frame.getContentPane().add(panel_3, BorderLayout.NORTH);
		
		JLabel label_1_6 = new JLabel("-");
		panel_3.add(label_1_6);
		
		JLabel label_1_1_1 = new JLabel(carta);
		panel_3.add(label_1_1_1);
		
		JLabel label_1_2_1 = new JLabel(carta);
		panel_3.add(label_1_2_1);
		
		JLabel label_1_3_1 = new JLabel(carta);
		panel_3.add(label_1_3_1);
		
		
		JLabel label_1_5_1 = new JLabel();
		panel_3.add(label_1_5_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(60, 179, 113));
		frame.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
	}
	
	/*private JPanel buildContentPanel () {
		StringBuilder titolo = new StringBuilder();
		titolo.append((new StringBuilder("SCOPA (")));
	} STO FACENDO LO STRING BUILDER MA DEVO PRIMA COSTRUIRE LA CLASSE CON LE DIFFICOLTA, SCORE E TURNO*/
	
	 
	private JPanel buildContentPane(Scopa scopa) {
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
	}
	
	public class Select implements MouseListener {


		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
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
