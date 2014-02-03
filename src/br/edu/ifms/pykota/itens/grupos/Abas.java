package br.edu.ifms.pykota.itens.grupos;

import java.awt.Color;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.ifms.pykota.controle.Consultas;
import br.edu.ifms.pykota.entidades.Grouppquota;
import br.edu.ifms.pykota.utilitarios.Icone;

@SuppressWarnings("serial")
public class Abas extends JTabbedPane
{
	public Cotas cotas = new Cotas();
	
	public Abas()
	{
		this.setBounds(10,300,470,250);
		this.addTab("Cotas",new Icone("impressoras.png",15),this.cotas);
		this.addTab("Membros",new Icone("grupos.png",15),new JPanel());
	}
}


@SuppressWarnings("serial")
class Cotas extends JPanel
{	
	
	public Cotas()
	{
		this.setLayout(null);
	}
	
	public void Buscar()
	{
		@SuppressWarnings("unchecked")
		List<Grouppquota> grouppquota = Consultas.ListarComFiltro(Consultas.getNovoFiltro(Grouppquota.class).add(Restrictions.like("groupid",Form.group.getId()+"", MatchMode.EXACT)));
		//List<Users> users = Consultas.ListarComFiltro(Consultas.getNovoFiltro(Users.class).add(Restrictions.like("username", busca, MatchMode.ANYWHERE)).addOrder(Order.asc("username")));
		
		int i = 0;
		for (Grouppquota gppqta : grouppquota)
		{
			this.removeAll();
			JLabel f = new JLabel(gppqta.getPrinters().getPrintername());
			f.setBounds(0,23*i++,470,22);
			f.setBackground(Color.decode("#CCC"));
			this.add(f);
			
			this.repaint();
		}
	}
}