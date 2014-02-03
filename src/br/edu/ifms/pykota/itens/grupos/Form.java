package br.edu.ifms.pykota.itens.grupos;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.ifms.pykota.controle.Consultas;
import br.edu.ifms.pykota.entidades.Groups;
import br.edu.ifms.pykota.utilitarios.AntiInjection;
import br.edu.ifms.pykota.utilitarios.Icone;

@SuppressWarnings("serial")
class Form extends JPanel
{
	
	private JTextField groupname;
	private JTextArea description; 
	
	private Botao bt_add;
	private Botao bt_salvar;
	private Botao bt_editar;
	private Botao bt_deletar;
	
	private Font font_bd = new Font("Arial",Font.PLAIN,15);
	private Font font = new Font("Arial",Font.PLAIN,13);
	
	public static Groups group;
	
	public Form()
	{
		this.setLayout(null);
		this.setBounds(10,20,470,270);
		
		this.Labels();
		this.Botoes();
	} 
	
	public void Labels()
	{	
		//ADICIONA O CAMPO GROUPNAME
		JLabel lb_groupname = new JLabel("Nome:");
		lb_groupname.setBounds(20,50,80,25);
		lb_groupname.setFont(this.font_bd);
		this.add(lb_groupname);
		
		this.groupname = new JTextField();
		this.groupname.setBounds(100,50,200,25);
		this.groupname.setFont(this.font);
		this.groupname.setEditable(false);
		this.add(this.groupname);
		
		
		//ADICIONA O CAMPO DESCRIPTION
		JLabel lb_description = new JLabel("Descrição:");
		lb_description.setBounds(20,100,80,25);
		lb_description.setFont(this.font_bd);
		this.add(lb_description);
		
		this.description = new JTextArea();
		this.description.setFont(this.font);
		this.description.setWrapStyleWord(true);
		this.description.setEditable(false);
		this.description.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(100,100,200,100);
		scroll.setViewportView(this.description);
		this.add(scroll);
		
	}
		
	public void Botoes()
	{
		//ADICIONA O BOTAO ADICIONAR
		this.bt_add = new Botao("Novo","add_user.png",30);
		this.bt_add.setBounds(340,45,120,40);
		this.bt_add.setFont(this.font_bd);
		this.bt_add.setHorizontalTextPosition(JButton.RIGHT);
		this.bt_add.setVerticalTextPosition(JButton.CENTER);
		this.bt_add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				remove(bt_salvar);
				add(bt_editar);
				repaint();
				groupname.setText("");
				description.setText("");
				groupname.setEditable(false);
				description.setEditable(false);
				
				Novo novo = new Novo();
				novo.setVisible(true);
			}
		});
		this.add(this.bt_add);
		
		
		
		//ADICIONA O BOTAO EDITAR
		this.bt_editar = new Botao("Editar","edit_user.png",30);
		this.bt_editar.setBounds(340,95,120,40);
		this.bt_editar.setFont(this.font_bd);
		this.bt_editar.setHorizontalTextPosition(JButton.RIGHT);
		this.bt_editar.setVerticalTextPosition(JButton.CENTER);
		this.bt_editar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(group != null)
				{
					groupname.setEditable(true);
					description.setEditable(true);
					remove(bt_editar);
					add(bt_salvar);
					repaint();
				}
			}
		});
		this.add(this.bt_editar);
		
		
		//ADICIONA O BOTAO SALVAR
		this.bt_salvar = new Botao("Salvar","save.png",30);
		this.bt_salvar.setBounds(340,95,120,40);
		this.bt_salvar.setFont(this.font_bd);
		this.bt_salvar.setHorizontalTextPosition(JButton.RIGHT);
		this.bt_salvar.setVerticalTextPosition(JButton.CENTER);
		this.bt_salvar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(group != null)
				{
					group.setGroupname(AntiInjection.Verificar(groupname.getText()));
					group.setDescription(AntiInjection.Verificar(description.getText()));
					
					Consultas.Editar(group);
					
					JOptionPane.showMessageDialog(null,"O GRUPO FOI ALTERADO COM SUCESSO!!!","SUCESSO",JOptionPane.INFORMATION_MESSAGE);
					
					remove(bt_salvar);
					add(bt_editar);
					repaint();
					groupname.setEditable(false);
					description.setEditable(false);
				}
			}
		});
		
		//ADICIONA O BOTAO DELETAR
		this.bt_deletar = new Botao("Deletar","delete_user.png",30);
		this.bt_deletar.setBounds(340,145,120,40);
		this.bt_deletar.setFont(this.font_bd);
		this.bt_deletar.setHorizontalTextPosition(JButton.RIGHT);
		this.bt_deletar.setVerticalTextPosition(JButton.CENTER);
		this.bt_deletar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(group != null)
				{
					int option = JOptionPane.showConfirmDialog(null,"DESEJA REALMENTE DELETAR O GRUPO?","SERÁ QUE É ISSO MESMO?",JOptionPane.WARNING_MESSAGE);
					if(option == 0)
					{
						Consultas.Deletar(group);
						group = null;
					
						JOptionPane.showMessageDialog(null,"O GRUPO FOI DELETADO COM SUCESSO!!!","SUCESSO",JOptionPane.INFORMATION_MESSAGE);
						
						remove(bt_salvar);
						add(bt_editar);
						repaint();
						groupname.setText("");
						description.setText("");
						groupname.setEditable(false);
						description.setEditable(false);
						
						Grupos.tabela.RemoverLinha();
					}
				}
			}
		});
		this.add(this.bt_deletar);
	}
	
	//METODO CHAMADO PELA TABELA QUE PEENCHE OS CAMPOS DO FORMULARIO
	public void SetarDados(Groups group)
	{
		this.group = group;
		this.groupname.setText(this.group.getGroupname());
		this.description.setText(this.group.getDescription());
		groupname.setEditable(false);
		description.setEditable(false);
		
		this.remove(this.bt_salvar);
		this.add(this.bt_editar);
		this.repaint();
	}
}


@SuppressWarnings("serial")
class Botao extends JButton
{
	public Botao(String texto,String URL_icon,int tam)
	{
		super(texto);
		this.setIcon(new Icone(URL_icon,tam));
		
	}
}
