package br.edu.ifms.pykota.main;

import java.awt.Color;

import javax.swing.JFrame;

import br.edu.ifms.pykota.controle.Cadastros;

public class Main extends JFrame{

	public Main(){
		
		
		
		this.setLayout(null);
	    this.setExtendedState(MAXIMIZED_BOTH);
	    this.setVisible(true);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		Cadastros cadastro = new Cadastros();
		cadastro.Insere_User();
		System.exit(0);
	}

}
