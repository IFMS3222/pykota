package br.edu.ifms.pykota.itens.cotaUsuarios;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import br.edu.ifms.pykota.entidades.Users;
import br.edu.ifms.pykota.utilitarios.Dialog;
import br.edu.ifms.pykota.utilitarios.FundoPanel;

@SuppressWarnings("serial")
public class CotaUsuarios extends Dialog
{
	private JPanel topPanel;
	private JPanel bottomPanel; 
	
	private JTextField busca;
	private Tabela tabela;
	private JScrollPane scroll;
	private String[] campos = {"Usuario","Impressora","Total Impresso","Páginas no Mês","Cota Restante","Cota Mensal"};
	private int[] lar = {126,126,126,126,126,126};
	
	public CotaUsuarios()
	{
		super(Dialog.USUARIOS);
		this.setLayout(null);
		this.Componentes();
	}
	
	public void Componentes()
	{	
		this.topPanel = new FundoPanel();//PAINEL ESQUERDO
		this.bottomPanel = new FundoPanel();//PAINEL DIREITO
		this.tabela = new Tabela(this.campos,this.lar); //TABELA
		this.scroll = new JScrollPane();
		this.busca = new JTextField();//CAIXA DE TEXTO DO INSTANT
		
		this.busca.setBounds(520,20,240,25);
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
		
		
		this.tabela.addMouseListener(new MouseListener()
		{
			
			public void mouseClicked(MouseEvent c)
			{
				Users user = (Users) ((DefaultTableModel)tabela.getModel()).getValueAt(tabela.getSelectedRow(), 0);
				//form.SetarDados(user);
				//abas.cotas.Buscar();
			}
			public void mouseEntered(MouseEvent c){}
			public void mouseExited(MouseEvent c){}
			public void mousePressed(MouseEvent c){}
			public void mouseReleased(MouseEvent c){}
		});
		
		
		this.scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.scroll.setBounds(7,60,770,200);
		this.scroll.setViewportView(this.tabela);
		
		this.topPanel.setBounds(5,5,785,270);
		this.topPanel.setBorder(BorderFactory.createTitledBorder(null,
				"BUSCAR", TitledBorder.RIGHT, TitledBorder.TOP, new Font(
						"times new roman", Font.PLAIN, 10), Color
						.decode("#8692AA")));
		this.topPanel.setLayout(null);
		this.topPanel.add(this.busca);
		this.topPanel.add(this.scroll);
		this.add(this.topPanel);
		
		this.bottomPanel.setBounds(5,275,785,300);
		this.bottomPanel.setLayout(null);
		this.bottomPanel.setBorder(BorderFactory.createTitledBorder("INFORMAÇÕES"));
		//this.bottomPanel.add(this.form);
		//this.bottomPanel.add(this.abas);
		this.add(this.bottomPanel);
	}	
}
