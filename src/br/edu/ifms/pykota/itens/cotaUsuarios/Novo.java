package br.edu.ifms.pykota.itens.cotaUsuarios;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.edu.ifms.pykota.controle.Consultas;
import br.edu.ifms.pykota.entidades.Printers;
import br.edu.ifms.pykota.entidades.Userpquota;
import br.edu.ifms.pykota.entidades.Users;
import br.edu.ifms.pykota.utilitarios.BordaRedonda;
import br.edu.ifms.pykota.utilitarios.Botao;
import br.edu.ifms.pykota.utilitarios.FundoPanel;

@SuppressWarnings("serial")
public class Novo extends JDialog
{	
	public static Novo novo;
	
	public Novo()
	{
		novo = this;
		this.setSize(400,300);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setResizable(false);
		this.setTitle("Adicionar Grupo");
		
		this.add(new Painel());
	}
}

@SuppressWarnings("serial")
class Painel extends FundoPanel
{
private Userpquota userpquota;
	
	private JComboBox tf_user;
	private JComboBox tf_printer;
	private BordaRedonda tf_cota;
	
	private Font font = new Font("Times New Roman",Font.PLAIN,15);
	private Font font_bd = new Font("Times New Roman",Font.BOLD,15);
	
	public Painel()
	{
		this.setBounds(400,15,320,270);
		this.setLayout(null);
		
		this.tf_user = new JComboBox();
		this.tf_printer = new JComboBox();
		this.tf_cota = new BordaRedonda();
		
		this.Labels();
	}
	
	public void Labels()
	{
		JLabel lb_user = new JLabel("Usuário:");
		lb_user.setFont(font_bd);
		lb_user.setBounds(20,20,100,25);
		this.add(lb_user);
		
		this.tf_user.setBounds(120,20,200,25);
		this.tf_user.setFont(font);
		this.add(this.tf_user);
		
		
		JLabel lb_printer = new JLabel("Impressoras:");
		lb_printer.setFont(font_bd);
		lb_printer.setBounds(20,60,100,25);
		this.add(lb_printer);
		
		this.tf_printer.setBounds(120,60,200,25);
		this.tf_printer.setFont(font);
		this.add(this.tf_printer);
		
		
		List<Users> users = Consultas.Listar(Users.class);
		List<Printers> printers = Consultas.Listar(Printers.class);
		for(Users us : users)
		{
			this.tf_user.addItem(us);
		}
		for(Printers pr : printers)
		{
			this.tf_printer.addItem(pr);
		}
		
		JLabel lb_cota = new JLabel("Cota Mensal:");
		lb_cota.setFont(font_bd);
		lb_cota.setBounds(20,100,100,25);
		this.add(lb_cota);
		
		this.tf_cota.setBounds(120,100,50,25);
		this.tf_cota.setOpaque(false);
		this.tf_cota.setFont(font);
		this.tf_cota.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
		this.add(this.tf_cota);

		//ADICIONA O BOTAO SALVAR
		Botao salvar = new Botao("Salvar","f-save-icon.png",25);
		salvar.setBounds(280,225,100,30);
		salvar.setFont(this.font);
		salvar.setHorizontalTextPosition(JButton.RIGHT);
		salvar.setVerticalTextPosition(JButton.CENTER);
		salvar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				try
				{
					int test = Integer.parseInt(tf_cota.getText());
					
					if(!tf_user.getSelectedItem().toString().equals("") && !tf_printer.getSelectedItem().toString().equals("")  && !tf_cota.equals(""))
					{
						Userpquota userpquota = new Userpquota();
						
						userpquota.setUsers((Users)tf_user.getSelectedItem());
						userpquota.setPrinters((Printers)tf_printer.getSelectedItem());
						
						if(Consultas.Inserir(userpquota))
						{
							JOptionPane.showMessageDialog(null,"GRUPO ADICIONADO COM SUCESSO!!!","ADICIONADO COM SUCESSO",JOptionPane.INFORMATION_MESSAGE);
							CotaUsuarios.tabela.Buscar("");
						}
						else
							JOptionPane.showMessageDialog(null,"ERRO AO INSERIR GRUPO!!!","ERRO!!!",JOptionPane.ERROR_MESSAGE);
						
						Novo.novo.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "FAVOR PREENCHER TODOS OS CAMPOS","ERRO!!!",JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception erro)
				{
					JOptionPane.showMessageDialog(null, "FAVOR PREENCHER OS CAMPOS CORRETAMENTE","ERRO!!!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		this.add(salvar);
	}
}
