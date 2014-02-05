package br.edu.ifms.pykota.itens.cotaUsuarios;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import br.edu.ifms.pykota.entidades.Userpquota;
import br.edu.ifms.pykota.utilitarios.BordaRedonda;
import br.edu.ifms.pykota.utilitarios.Botao;
import br.edu.ifms.pykota.utilitarios.Dialog;
import br.edu.ifms.pykota.utilitarios.FundoDialog;
import br.edu.ifms.pykota.utilitarios.FundoPanel;

@SuppressWarnings("serial")
public class CotaUsuarios extends Dialog
{
	private JPanel Panel;
	private JPanel topPanel;
	private JPanel bottomPanel; 
	
	private JTextField busca;
	public static Tabela tabela;
	private JScrollPane scroll;
	private Form form;
	
	private String[] campos = {"Usuario","Impressora","Total Impresso","Páginas no Mês","Cota Restante","Cota Mensal"};
	private int[] lar = {126,126,126,126,126,126};
	
	public CotaUsuarios()
	{
		super(Dialog.USUARIOS);
		this.setLayout(null);
		this.Componentes();
		this.Eventos();
		this.Botoes();
	}
	
	public void Componentes()
	{	
		this.Panel = new FundoDialog();
		this.topPanel = new FundoPanel();//PAINEL ESQUERDO
		this.bottomPanel = new FundoPanel();//PAINEL DIREITO
		this.tabela = new Tabela(this.campos,this.lar); //TABELA
		this.scroll = new JScrollPane();
		this.busca = new BordaRedonda();//CAIXA DE TEXTO DO INSTANT
		this.form = new Form(); //FORMULARIO
		
		this.busca.setBounds(520,20,240,25);
		
		this.scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.scroll.setBounds(7,60,770,350);
		this.scroll.setViewportView(this.tabela);
		
		//this.Panel.setBounds(0, 0, 800,600);
		//this.Panel.setLayout(null);
		
		
		this.topPanel.setBounds(5,5,785,420);
		this.topPanel.setBorder(BorderFactory.createTitledBorder(null,
				"BUSCAR", TitledBorder.RIGHT, TitledBorder.TOP, new Font(
						"times new roman", Font.PLAIN, 10), Color
						.decode("#8692AA")));
		this.topPanel.setLayout(null);
		this.topPanel.add(this.busca);
		this.topPanel.add(this.scroll);
		//this.add(this.topPanel);
		
		this.bottomPanel.setBounds(45,440,705,100);
		this.bottomPanel.setBorder(BorderFactory.createTitledBorder(null,
				"AÇÕES", TitledBorder.RIGHT, TitledBorder.TOP, new Font(
						"times new roman", Font.PLAIN, 10), Color
						.decode("#8692AA")));
		this.bottomPanel.setLayout(null);
		//this.add(this.bottomPanel);
		this.Panel.add(topPanel);
		this.Panel.add(bottomPanel);
		this.add(Panel);
	}
	
	public void Eventos()
	{
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
				Userpquota userpquota = (Userpquota) ((DefaultTableModel)tabela.getModel()).getValueAt(tabela.getSelectedRow(), 0);
			}
			public void mouseEntered(MouseEvent c){}
			public void mouseExited(MouseEvent c){}
			public void mousePressed(MouseEvent c){}
			public void mouseReleased(MouseEvent c){}
		});
	}
	
	public void Botoes()
	{
		Botao bt_add = new Botao("Adicionar","f-add-user-icon.png",80);
		bt_add.setBounds(100, 0, 100,100);
		bt_add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Novo novo = new Novo();
				novo.setVisible(true);
			}
		});
		this.bottomPanel.add(bt_add);
		
		Botao bt_edit = new Botao("Editar Cota","f-edit-user-icon.png",80);
		bt_edit.setBounds(300, 0, 100,100);
		this.bottomPanel.add(bt_edit);
		
		Botao bt_delete = new Botao("Deletar","f-delete-user-icon.png",80);
		bt_delete.setBounds(500, 0, 100,100);
		this.bottomPanel.add(bt_delete);
	}
}