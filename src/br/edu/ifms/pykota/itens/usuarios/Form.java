package br.edu.ifms.pykota.itens.usuarios;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.ifms.pykota.controle.Consultas;
import br.edu.ifms.pykota.entidades.Users;
import br.edu.ifms.pykota.utilitarios.AntiInjection;
import br.edu.ifms.pykota.utilitarios.BordaRedonda;
import br.edu.ifms.pykota.utilitarios.Botao;
import br.edu.ifms.pykota.utilitarios.FundoPanel;

@SuppressWarnings("serial")
class Form extends FundoPanel
{
	
	private JTextField username;
	private JTextField email;
	private JTextArea description; 
	
	private Botao bt_add;
	private Botao bt_salvar;
	private Botao bt_editar;
	private Botao bt_cancelar;
	private Botao bt_deletar;
	
	private Font font_bd = new Font("Times New Roman",Font.PLAIN,15);
	private Font font = new Font("Times New Roman",Font.PLAIN,13);
	
	public static Users user;
	
	public Form()
	{
		this.setLayout(null);
		this.setBounds(10,20,470,270);
		
		this.Labels();
		this.Botoes();
	} 
	
	
	public void Labels()
	{	
		//ADICIONA O CAMPO USAENAME
		JLabel lb_username = new JLabel("Nome:");
		lb_username.setBounds(20,40,80,25);
		lb_username.setFont(this.font_bd);
		this.add(lb_username);
		
		this.username = new BordaRedonda();
		this.username.setBounds(100,40,200,25);
		this.username.setFont(this.font);
		this.username.setEditable(false);
		this.add(this.username);
		
		
		//ADICIONA O CAMPO EMAIL
		JLabel lb_email = new JLabel("Email:");
		lb_email.setBounds(20,80,80,25);
		lb_email.setFont(this.font_bd);
		this.add(lb_email);
		
		this.email = new BordaRedonda();
		this.email.setBounds(100,80,200,25);
		this.email.setFont(this.font);
		email.setEditable(false);
		this.add(this.email);
		
		
		//ADICIONA O CAMPO DESCRIPTION
		JLabel lb_description = new JLabel("Descri��o:");
		lb_description.setBounds(20,120,80,25);
		lb_description.setFont(this.font_bd);
		this.add(lb_description);
		
		this.description = new JTextArea();
		this.description.setFont(this.font);
		this.description.setWrapStyleWord(true);
		description.setEditable(false);
		this.description.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(100,120,200,100);
		scroll.setViewportView(this.description);
		this.add(scroll);
		
	}
		
	public void Botoes()
	{
		//ADICIONA O BOTAO ADICIONAR
		this.bt_add = new Botao("Criar novo usu�rio","f-add-user-icon.png",60);
		this.bt_add.setBounds(340,25,100,80);
		this.bt_add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				remove(bt_salvar);
				add(bt_editar);
				repaint();
				username.setText("");
				email.setText("");
				description.setText("");
				username.setEditable(false);
				email.setEditable(false);
				description.setEditable(false);
				
				Novo novo = new Novo();
				novo.setVisible(true);
			}
		});
		this.add(this.bt_add);
		
		
		
		//ADICIONA O BOTAO EDITAR
		this.bt_editar = new Botao("Editar usu�rio","f-edit-user-icon.png",60);
		this.bt_editar.setBounds(340,95,100,80);
		this.bt_editar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(user != null)
				{
					username.setEditable(true);
					email.setEditable(true);
					description.setEditable(true);
					username.requestFocus();
					remove(bt_add);
					remove(bt_editar);
					remove(bt_deletar);
					add(bt_salvar);
					add(bt_cancelar);
					repaint();
				}
			}
		});
		this.add(this.bt_editar);
		
		
		//ADICIONA O BOTAO SALVAR
		this.bt_salvar = new Botao("Salvar","f-save-icon.png",60);
		this.bt_salvar.setBounds(340,95,100,80);
		this.bt_salvar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(user != null)
				{
					user.setUsername(AntiInjection.Verificar(username.getText()));
					user.setEmail(AntiInjection.Verificar(email.getText()));
					user.setDescription(AntiInjection.Verificar(description.getText()));
					
					Consultas.Editar(user);
					
					JOptionPane.showMessageDialog(null,"O USU�RIO FOI ALTERADO COM SUCESSO!!!","SUCESSO",JOptionPane.INFORMATION_MESSAGE);
					
					remove(bt_salvar);
					remove(bt_cancelar);
					add(bt_add);
					add(bt_editar);
					add(bt_deletar);
					repaint();
					username.setEditable(false);
					email.setEditable(false);
					description.setEditable(false);
				}
			}
		});
		
		//ADICIONA O BOTAO CANCELAR
				this.bt_cancelar = new Botao("Cancelar","f-cancel-icon.png",60);
				this.bt_cancelar.setBounds(340,165,100,80);
				
				this.bt_cancelar.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						remove(bt_salvar);
						remove(bt_cancelar);
						add(bt_add);
						add(bt_editar);
						add(bt_deletar);
						repaint();
						username.setEditable(false);
						email.setEditable(false);
						description.setEditable(false);
										
					}});

		
		//ADICIONA O BOTAO DELETAR
		this.bt_deletar = new Botao("Excluir Usu�rio","f-delete-user-icon.png",60);
		this.bt_deletar.setBounds(340,165,100,80);
		this.bt_deletar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(user != null)
				{
					int option = JOptionPane.showConfirmDialog(null,"DESEJA REALMENTE DELETAR O USU�RIO?","SER� QUE � ISSO MESMO?",JOptionPane.WARNING_MESSAGE);
					if(option == 0)
					{
						Consultas.Deletar(user);
						user = null;
					
						JOptionPane.showMessageDialog(null,"O USU�RIO FOI DELETADO COM SUCESSO!!!","SUCESSO",JOptionPane.INFORMATION_MESSAGE);
						
						remove(bt_salvar);
						add(bt_editar);
						repaint();
						username.setText("");
						email.setText("");
						description.setText("");
						username.setEditable(false);
						email.setEditable(false);
						description.setEditable(false);
						
						Usuarios.tabela.RemoverLinha();
					}
				}
			}
		});
		this.add(this.bt_deletar);
	}
	
	//METODO CHAMADO PELA TABELA QUE PEENCHE OS CAMPOS DO FORMULARIO
	public void SetarDados(Users user)
	{
		this.user = user;
		this.username.setText(this.user.getUsername());
		this.email.setText(this.user.getEmail());
		this.description.setText(this.user.getDescription());
		username.setEditable(false);
		email.setEditable(false);
		description.setEditable(false);
		
		this.remove(this.bt_salvar);
		this.remove(this.bt_cancelar);
		this.add(this.bt_editar);
		this.add(this.bt_deletar);
		this.repaint();
	}
}
