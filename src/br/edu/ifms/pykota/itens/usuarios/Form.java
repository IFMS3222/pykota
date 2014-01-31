package br.edu.ifms.pykota.itens.usuarios;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class Form extends JPanel
{
	
	private JTextField username;
	private JTextField email;
	private JTextArea description; 
	
	public Form()
	{
		this.setLayout(null);
		this.setBounds(10,20,470,270);
		this.setBackground(Color.cyan);
	} 
}