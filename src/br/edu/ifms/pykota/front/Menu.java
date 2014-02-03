package br.edu.ifms.pykota.front;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.ifms.pykota.utilitarios.Icone;
import br.edu.ifms.pykota.itens.grupos.Grupos;
import br.edu.ifms.pykota.itens.usuarios.Usuarios;

@SuppressWarnings("serial")
public class Menu extends JPanel 
{
	public Menu()
	{
		this.setLayout(new GridLayout(1,0));
		
		//ADICIONA OS BOTOES
		Botao usuarios = new Botao("Usuários","usuarios.png",Botao.USUARIOS);
		this.add(usuarios);
		
		Botao cotaUsuarios = new Botao("Cotas de Usuários","cotaUsuarios.png",Botao.COTA_USUARIOS);
		this.add(cotaUsuarios);
		
		Botao grupos = new Botao("Grupos","grupos.png",Botao.GRUPOS);
		this.add(grupos);
		
		Botao cotaGrupos = new Botao("Cota Grupos","cotaGrupos.png",Botao.COTA_GRUPOS);
		this.add(cotaGrupos);
	}
}

@SuppressWarnings("serial")
class Botao extends JLabel
{
	public static final int USUARIOS = 1;
	public static final int COTA_USUARIOS = 2;
	public static final int GRUPOS = 3;
	public static final int COTA_GRUPOS = 4;
	
	public Botao(String title,String icone,final int pos)
	{
		super(title);
		
		this.setBorder(null);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setIcon(new Icone(icone));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setFont(new Font("Calibri",Font.PLAIN,15));
		this.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent arg0) 
			{
				switch(pos)
				{
					case 1: 
						//DIALOG DO USUARIO
						Usuarios usuarios = new Usuarios();
						usuarios.Show();
					break;  
					case 2: 
						
					break;
					case 3: 
						//DIALOG DO USUARIO
						Grupos grupos = new Grupos();
						grupos.Show();
					break;
					case 4: 
						
					break;
				}
			}
			public void mouseEntered(MouseEvent arg0)
			{
				setFont(new Font("Calibri",Font.BOLD,15));
			}
			public void mouseExited(MouseEvent arg0)
			{
				setFont(new Font("Calibri",Font.PLAIN,15));
			}
			public void mousePressed(MouseEvent arg0){}
			public void mouseReleased(MouseEvent arg0){}});
	}
}
