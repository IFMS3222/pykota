package br.edu.ifms.pykota.itens.usuarios;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.ifms.pykota.controle.Consultas;
import br.edu.ifms.pykota.entidades.Users;
import br.edu.ifms.pykota.utilitarios.AntiInjection;

@SuppressWarnings("serial")
public class Novo extends JDialog
{	
	public Novo()
	{
		this.setSize(400,300);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setResizable(false);
		this.setTitle("Adicionar Usuário");
		
		this.add(new Painel());
	}
}

@SuppressWarnings("serial")
class Painel extends JPanel
{
	private JTextField username;
	private JTextField email;
	private JTextArea description; 
	
	private Font font_bd = new Font("Arial",Font.BOLD,15);
	private Font font = new Font("Arial",Font.PLAIN,13);
	
	public Painel()
	{	
		this.setLayout(null);
		this.setSize(400,300);
		
		this.Labels();
	}
	
	public void Labels()
	{		
		
		//ADICIONA O CAMPO USAENAME
		JLabel lb_username = new JLabel("Nome:");
		lb_username.setBounds(20,40,80,25);
		lb_username.setFont(this.font_bd);
		this.add(lb_username);
		
		this.username = new JTextField();
		this.username.setBounds(100,40,200,25);
		this.username.setFont(this.font);
		this.add(this.username);
		
		
		//ADICIONA O CAMPO EMAIL
		JLabel lb_email = new JLabel("Email:");
		lb_email.setBounds(20,80,80,25);
		lb_email.setFont(this.font_bd);
		this.add(lb_email);
		
		this.email = new JTextField();
		this.email.setBounds(100,80,200,25);
		this.email.setFont(this.font);
		this.add(this.email);
		
		
		//ADICIONA O CAMPO DESCRIPTION
		JLabel lb_description = new JLabel("Descrição:");
		lb_description.setFont(this.font_bd);
		lb_description.setBounds(20,120,80,25);
		this.add(lb_description);
		
		this.description = new JTextArea();
		this.description.setFont(this.font);
		this.description.setWrapStyleWord(true);
		this.description.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(100,120,200,100);
		scroll.setViewportView(this.description);
		this.add(scroll);
		
		//ADICIONA O BOTAO SALVAR
		Botao salvar = new Botao("Salvar","save.png",22);
		salvar.setBounds(280,225,100,30);
		salvar.setFont(this.font);
		salvar.setHorizontalTextPosition(JButton.RIGHT);
		salvar.setVerticalTextPosition(JButton.CENTER);
		salvar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(!username.getText().equals("") && !email.getText().equals("") && !description.getText().equals(""))
				{
					Users users = new Users();
					
					users.setUsername(username.getText());
					users.setEmail(email.getText());
					users.setDescription(description.getText());
					
					Consultas.Inserir(users);
					
					JOptionPane.showMessageDialog(null,"USUÁRIO ADICIONADO COM SUCESSO!!!","ADICIONADO COM SUCESSO",JOptionPane.INFORMATION_MESSAGE);
					
					setVisible(false);
				}
			}
		});
		this.add(salvar);
	}
}
