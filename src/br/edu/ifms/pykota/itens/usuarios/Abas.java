package br.edu.ifms.pykota.itens.usuarios;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import br.edu.ifms.pykota.utilitarios.Icone;

public class Abas extends JTabbedPane
{
	public Abas()
	{
		this.setBounds(10,300,470,250);
		this.addTab("Cotas",new Icone("impressoras.png",15),new JPanel());
		this.addTab("Membro de",new Icone("grupos.png",15),new JPanel());
	}
}
