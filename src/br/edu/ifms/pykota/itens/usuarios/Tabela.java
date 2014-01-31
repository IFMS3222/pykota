package br.edu.ifms.pykota.itens.usuarios;

import java.awt.Color;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.edu.ifms.pykota.controle.Cadastros;
import br.edu.ifms.pykota.controle.Consultas;
import br.edu.ifms.pykota.entidades.Users;

@SuppressWarnings("serial")
public class Tabela extends JTable 
{
	
	public Tabela(String[] nom_col,int[] lar_col)
	{
		this.setModel(new DefaultTableModel(nom_col,0));
		this.setBackground(Color.decode("#DFDFDF"));
		this.setAutoCreateRowSorter(true);
		this.setRowHeight(20);
		this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		this.Buscar("");
		
		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
		centro.setHorizontalAlignment(SwingConstants.CENTER);
		
		//GERA AS LARGURAS DAS CoLUNAS
		int i = 0;
		while(true)
		{
			try
			{
				this.getColumnModel().getColumn(i).setPreferredWidth(lar_col[i]);
				this.getColumnModel().getColumn(i).setCellRenderer(centro);
			}
			catch(Exception erro)
			{
				break;
			}
			i++;
		}
	}
	
	
	public void RemoverTudo()
	{
		while(true)
		{
			try
			{
				((DefaultTableModel)this.getModel()).removeRow(0);
			}
			catch(Exception cabô)
			{
				break;
			}
		}
	}
	
	public void Buscar(String busca)
	{	
		this.RemoverTudo();
		//LOOP COM OS DADOS DO BANCO
		
		@SuppressWarnings("unchecked")
		List<Users> users = Consultas.ListarComFiltro(Consultas.getNovoFiltro(Users.class).add(Restrictions.like("username", busca, MatchMode.ANYWHERE)).addOrder(Order.asc("username")));
		
		for (Users us : users)
		{
			((DefaultTableModel)this.getModel()).addRow(new String[]{us.getUsername()});
		}
	}
	
	public boolean isCellEditable(int Rows,int Colss)
	{
		return false;
	}
}
