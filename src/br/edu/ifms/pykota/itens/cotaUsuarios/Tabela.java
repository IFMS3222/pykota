package br.edu.ifms.pykota.itens.cotaUsuarios;

import java.awt.Color;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import br.edu.ifms.pykota.controle.Consultas;
import br.edu.ifms.pykota.entidades.Userpquota;
import br.edu.ifms.pykota.utilitarios.AntiInjection;

@SuppressWarnings("serial")
class UserpquotaCellRenderer extends DefaultTableCellRenderer
{
	public UserpquotaCellRenderer()
	{
		super();
		this.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
	}

    public void setValue(Object value) {
    	try
    	{
    		setText((value == null) ? "" : ((Userpquota) value).getUsers().getUsername());
    	}
    	catch(Exception e)
    	{
    		setText((value == null) ? "" : (String) value);
    	}
    }
}

@SuppressWarnings("serial")
public class Tabela extends JTable 
{	
	private UserpquotaCellRenderer userCellRenderer = new UserpquotaCellRenderer();
	
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
		return userCellRenderer;
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
		List<Userpquota> userpquota = Consultas.CriarConsultaHQL("select uq from Userpquota as uq where uq.users.username like '%"+busca+"%' or uq.printers.printername like '%"+busca+"%'").list();
		
		for (Userpquota uq : userpquota)
		{
			((DefaultTableModel)this.getModel()).addRow(new Object[]{uq,uq.getPrinters().getPrintername(),uq.getLifepagecounter()+"",uq.getPagecounter()+"",uq.getSoftlimit()+"",uq.getHardlimit()+""});
		}
	}
	
	public boolean isCellEditable(int Rows,int Colss)
	{
		return false;
	}
	
}