package br.edu.ifms.pykota.itens.usuarios;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.edu.ifms.pykota.utilitarios.Dialog;

@SuppressWarnings("serial")
public class Usuarios extends Dialog
{
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JTextField busca;
	private JScrollPane scroll;
	private Tabela tabela ;
	
	
	public Usuarios()
	{
		super(Dialog.USUARIOS);
		this.setLayout(null);
		this.Componentes();
	}
	
	public void Componentes()
	{	
		this.leftPanel = new JPanel();//PAINEL ESQUERDO
		this.rightPanel = new JPanel();//PAINEL DIREITO
		
		this.busca = new JTextField();//CAIXA DE TEXTO DO INSTANT 
		this.scroll = new JScrollPane();//SCROLL
		this.tabela = new Tabela(new String[]{"Usu�rios"},new int[]{268}); //TABELA COM OS USUARIOS
		
		
		this.busca.setBounds(10,20,270,25);
		this.busca.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent arg0){}
			public void keyReleased(KeyEvent e) 
			{	
				if(e.getKeyChar() != ' ')
				{
					tabela.Buscar(busca.getText());
				}
			}
			public void keyTyped(KeyEvent arg0){}
		});
		
		
		this.scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.scroll.setBounds(2,80,286,480);
		this.scroll.setViewportView(this.tabela);
		
		this.leftPanel.setBounds(5,5,290,560);
		this.leftPanel.setBorder(BorderFactory.createTitledBorder("BUSCAR"));
		this.leftPanel.setLayout(null);
		this.leftPanel.add(this.busca);
		this.leftPanel.add(this.scroll);
		this.add(this.leftPanel);
		
		this.rightPanel.setBounds(300,5,490,560);
		this.rightPanel.setLayout(null);
		this.rightPanel.setBorder(BorderFactory.createTitledBorder("INFORMA��ES"));
		this.rightPanel.add(new Form());
		this.add(this.rightPanel);
	}	
}