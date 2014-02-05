package br.edu.ifms.pykota.itens.grupos;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
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
import br.edu.ifms.pykota.utilitarios.BordaRedonda;
import br.edu.ifms.pykota.utilitarios.Botao;
import br.edu.ifms.pykota.utilitarios.FundoPanel;

@SuppressWarnings("serial")
class Form extends FundoPanel
{
	
	private JTextField groupname;
	private JTextArea description; 
	
	private Botao bt_add;
	private Botao bt_salvar;
	private Botao bt_editar;
	private Botao bt_deletar;
	private Botao bt_cancelar;
	
	private Font font_bd = new Font("Arial",Font.PLAIN,15);
	private Font font = new Font("Arial",Font.PLAIN,13);
	
	public static Groups group;
	private BufferedImage img;
	
	public Form()
	{
		/*try {
		      img = ImageIO.read(getClass().getResource("/br/edu/ifms/pykota/img/fundo_ap.png"));
		    } catch(IOException e) {
		      e.printStackTrace();
		    }*/
		
		this.setLayout(null);
		this.setBounds(10,20,470,270);
		
		this.Labels();
		this.Botoes();
	} 
	
	/*@Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	  }*/
	
	
	public void Labels()
	{	
		//ADICIONA O CAMPO GROUPNAME
		JLabel lb_groupname = new JLabel("Nome:");
		lb_groupname.setBounds(20,50,80,25);
		lb_groupname.setFont(this.font_bd);
		this.add(lb_groupname);
		
		this.groupname = new BordaRedonda();
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
		this.bt_add = new Botao("Adicionar Novo Grupo","f-add-group-icon.png",60);
		this.bt_add.setBounds(340,25,100,80);
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
		this.bt_editar = new Botao("Editar Grupo","f-edit-group-icon.png",60);
		this.bt_editar.setBounds(340,95,100,80);
		this.bt_editar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(group != null)
				{
					groupname.setEditable(true);
					description.setEditable(true);
					remove(bt_editar);
					remove(bt_add);
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
					remove(bt_cancelar);
					add(bt_add);
					add(bt_editar);
					add(bt_deletar);
					repaint();
					groupname.setEditable(false);
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
				groupname.setEditable(false);
				description.setEditable(false);
								
			}});
		
		
		//ADICIONA O BOTAO DELETAR
		this.bt_deletar = new Botao("Deletar","f-delete-group-icon.png",60);
		this.bt_deletar.setBounds(340,165,100,80);
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
