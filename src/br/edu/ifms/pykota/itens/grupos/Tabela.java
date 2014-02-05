package br.edu.ifms.pykota.itens.grupos;

import java.awt.Color;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.edu.ifms.pykota.controle.Consultas;
import br.edu.ifms.pykota.entidades.Groups;
import br.edu.ifms.pykota.utilitarios.AntiInjection;

@SuppressWarnings("serial")
class GroupCellRenderer extends DefaultTableCellRenderer
{
	public GroupCellRenderer()
	{
		super();
		this.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
	}

    public void setValue(Object value) {
        setText((value == null) ? "" : ((Groups) value).getGroupname());
    }
}

@SuppressWarnings("serial")
public class Tabela extends JTable 
{	
	private GroupCellRenderer groupCellRenderer = new GroupCellRenderer();
	
	public Tabela(String[] nom_col,int[] lar_col)
	{
		this.setModel(new DefaultTableModel(nom_col,0));
		this.setBackground(Color.decode("#DFDFDF"));
		this.setRowHeight(20);
		this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.setBackground(Color.WHITE);
		this.getTableHeader().setReorderingAllowed(false);
		
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
	
	public TableCellRenderer getCellRenderer(int row, int column) {
            return groupCellRenderer;
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
	
	public void RemoverLinha()
	{
		((DefaultTableModel)this.getModel()).removeRow(this.getSelectedRow());
	}
	
	public void Buscar(String busca)
	{	
		this.RemoverTudo();
		
		busca = AntiInjection.Verificar(busca);
		
		//LOOP COM OS DADOS DO BANCO
		@SuppressWarnings("unchecked")
		List<Groups> groups = Consultas.ListarComFiltro(Consultas.getNovoFiltro(Groups.class).add(Restrictions.like("groupname", busca, MatchMode.ANYWHERE)).addOrder(Order.asc("groupname")));
		
		for (Groups us : groups)
		{
			((DefaultTableModel)this.getModel()).addRow(new Groups[]{us});
		}
	}
	
	public boolean isCellEditable(int Rows,int Colss)
	{
		return false;
	}
	
}