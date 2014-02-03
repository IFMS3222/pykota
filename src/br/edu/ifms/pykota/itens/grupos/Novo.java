package br.edu.ifms.pykota.itens.grupos;

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
import br.edu.ifms.pykota.entidades.Groups;
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
		this.setTitle("Adicionar Grupo");
		
		this.add(new Painel());
	}
}

@SuppressWarnings("serial")
class Painel extends JPanel
{
	private JTextField groupname;
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
		JLabel lb_groupname = new JLabel("Nome:");
		lb_groupname.setBounds(20,50,80,25);
		lb_groupname.setFont(this.font_bd);
		this.add(lb_groupname);
		
		this.groupname = new JTextField();
		this.groupname.setBounds(100,50,200,25);
		this.groupname.setFont(this.font);
		this.add(this.groupname);
				
		
		//ADICIONA O CAMPO DESCRIPTION
		JLabel lb_description = new JLabel("Descrição:");
		lb_description.setFont(this.font_bd);
		lb_description.setBounds(20,100,80,25);
		this.add(lb_description);
		
		this.description = new JTextArea();
		this.description.setFont(this.font);
		this.description.setWrapStyleWord(true);
		this.description.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(100,100,200,100);
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
				if(!groupname.getText().equals("") && !description.getText().equals(""))
				{
					Groups groups = new Groups();
					
					groups.setGroupname(groupname.getText());
					groups.setDescription(description.getText());
					
					Consultas.Inserir(groups);
					
					JOptionPane.showMessageDialog(null,"GRUPO ADICIONADO COM SUCESSO!!!","ADICIONADO COM SUCESSO",JOptionPane.INFORMATION_MESSAGE);
					
					setVisible(false);
				}
			}
		});
		this.add(salvar);
	}
}
