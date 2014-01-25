package br.edu.ifms.pykota.main;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.orm.PersistentException;

import br.edu.ifms.pykota.entidades.Users;
import br.edu.ifms.pykota.front.*;
import br.edu.ifms.pykota.controle.Cadastros;
import br.edu.ifms.pykota.controle.Consultas;
import br.edu.ifms.pykota.dao.ListPykotaData;

public class Main extends JFrame{

	public Main(){
		
		ver v = new ver();
		
		this.setLayout(null);
	    this.setExtendedState(MAXIMIZED_BOTH);
	    this.setVisible(true);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.add(v);
	}
	
	
	
	public static void main(String[] args) throws PersistentException {
		/*Cadastros cadastro = new Cadastros();
		cadastro.Insere_User();*/
		/*Consultas c = new Consultas();
		c.Consulta(5);
		System.exit(0);
		/*Consultas c = new Consultas();
		try{
		c.Apaga(4);
		}catch(NullPointerException npc){
			JOptionPane.showMessageDialog(null, "O usuario nao Existe");
		}*/
		
		
		//Consultas.Deletar(Users.class, 8);
		//new Main();
	}

}
