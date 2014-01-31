package br.edu.ifms.pykota.itens.usuarios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.edu.ifms.pykota.controle.Consultas;
import br.edu.ifms.pykota.entidades.Users;
import br.edu.ifms.pykota.utilitarios.Icone;

@SuppressWarnings("serial")
class Form extends JPanel
{
	
	private JTextField username;
	private JTextField email;
	private JTextArea description; 
	
	private Botao bt_salvar;
	private Botao bt_editar;
	private Botao bt_deletar;
	
	private Font font_bd = new Font("Arial",Font.PLAIN,15);
	private Font font = new Font("Arial",Font.PLAIN,13);
	
	private Users user;
	
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
		
		this.username = new JTextField();
		this.username.setBounds(100,40,200,25);
		this.username.setFont(this.font);
		username.setEditable(false);
		this.add(this.username);
		
		
		//ADICIONA O CAMPO EMAIL
		JLabel lb_email = new JLabel("Email:");
		lb_email.setBounds(20,80,80,25);
		lb_email.setFont(this.font_bd);
		this.add(lb_email);
		
		this.email = new JTextField();
		this.email.setBounds(100,80,200,25);
		this.email.setFont(this.font);
		email.setEditable(false);
		this.add(this.email);
		
		
		//ADICIONA O CAMPO DESCRIPTION
		JLabel lb_description = new JLabel("Descrição:");
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
		//ADICIONA O BOTAO EDITAR
		this.bt_editar = new Botao("Editar","edit_user.png");
		this.bt_editar.setBounds(340,40,120,100);
		this.bt_editar.setFont(this.font_bd);
		this.bt_editar.setHorizontalTextPosition(JButton.CENTER);
		this.bt_editar.setVerticalTextPosition(JButton.BOTTOM);
		this.bt_editar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(user != null)
				{
					username.setEditable(true);
					email.setEditable(true);
					description.setEditable(true);
				}
			}
		});
		this.add(this.bt_editar);
	}
	
	
	public void SetarDados(int id)
	{
		@SuppressWarnings("unchecked")
		List<Users> user = Consultas.ListarComFiltro(Consultas.getNovoFiltro(Users.class).add(Restrictions.idEq(id)));
		this.user = user.get(0);
		this.username.setText(this.user.getUsername());
		this.email.setText(this.user.getEmail());
		this.description.setText(this.user.getDescription());
		username.setEditable(false);
		email.setEditable(false);
		description.setEditable(false);
	}
}


@SuppressWarnings("serial")
class Botao extends JButton
{
	public Botao(String texto,String URL_icon)
	{
		super(texto);
		this.setIcon(new Icone("edit_user.png"));
		this.setSelected(false);
	}
}
