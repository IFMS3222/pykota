package br.edu.ifms.pykota.front;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.edu.ifms.pykota.utilitarios.Icone;

@SuppressWarnings("serial")
public class Aplicacao extends JPanel
{
	private SpringLayout layout;
	private Menu menu;
	private Centro centro;
	
	public Aplicacao()
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//SETA O LAYOUT DA APLICACAO
		this.layout = new SpringLayout();
		this.setLayout(layout);
		
		this.Componentes();
		this.Layout();
	}
	
	//SETA OS COMPONENTES
	public void Componentes()
	{
		this.menu = new Menu();
		this.add(menu,BorderLayout.NORTH);
		
		this.centro = new Centro();
		this.add(centro,BorderLayout.CENTER);
	}
	
	public void Layout()
	{
		this.layout.putConstraint(SpringLayout.NORTH,this.menu, 0,SpringLayout.NORTH,this);
		this.layout.putConstraint(SpringLayout.SOUTH,this.menu,80,SpringLayout.NORTH,this);
		this.layout.putConstraint(SpringLayout.WEST, this.menu, 0,SpringLayout.WEST, this);
		this.layout.putConstraint(SpringLayout.EAST, this.menu, 0,SpringLayout.EAST, this);
		
		this.layout.putConstraint(SpringLayout.NORTH,this.centro, 0,SpringLayout.NORTH,this.menu);
		this.layout.putConstraint(SpringLayout.SOUTH,this.centro, 0,SpringLayout.SOUTH,this);
		this.layout.putConstraint(SpringLayout.WEST, this.centro, 0,SpringLayout.WEST, this);
		this.layout.putConstraint(SpringLayout.EAST, this.centro, 0,SpringLayout.EAST, this);
	}
	
	public void Show()
	{
		new FrameRoot();
	}
}

@SuppressWarnings("serial")
class FrameRoot extends JFrame
{	
	public FrameRoot()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setIconImage(new Icone("impressoras.png").getImage());
		this.setBounds(200,100,800,600);
		this.setTitle("Pykota");
		this.setContentPane(new Aplicacao());
		this.setVisible(true);
	}
}


@SuppressWarnings("serial")
class Centro extends JPanel
{
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(new ImageIcon(getClass().getResource("../img/url.jpg")).getImage(),0,0,this.getWidth(),this.getHeight(),null);
	}
}