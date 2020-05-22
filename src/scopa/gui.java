package scopa;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;

public class gui {

	private JFrame frame;
	private JTextField txtPunteggio;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public gui() {
		initialize();
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
