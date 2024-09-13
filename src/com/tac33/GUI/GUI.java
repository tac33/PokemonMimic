package com.tac33.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUI implements ActionListener {
	
	JFrame frame;
	JTextField textfield;
	JButton[] buttons = new JButton[5];
	JPanel startPanel;
	GUI(){
		frame = new JFrame("Breeding Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);
		frame.setLayout(null);
		
		startPanel = new JPanel(new GridLayout(1, 3));
		startPanel.setBounds(300, 200, 600, 400);
		startPanel.setBackground(Color.RED);
		
		
		frame.add(startPanel);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		GUI gui = new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// e.getSource will get the button that was clicked.
		
	}
}
