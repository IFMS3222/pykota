package br.edu.ifms.pykota.front;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.ifms.pykota.controle.Consultas;
import br.edu.ifms.pykota.entidades.Printers;
import br.edu.ifms.pykota.entidades.Users;

public class ver extends JPanel{
	public ver()
	{
		JLabel label = new JLabel();
		Users user = (Users) Consultas.Selecionar(Users.class, 4);
		label.setText(user.getUsername());
		label.setBounds(0, 0, 200, 50);
		
		this.setLayout(null);
	    this.setVisible(true);
	    this.setBounds(0, 0, 500, 500);
	    this.add(label);
	    	
	}

}
