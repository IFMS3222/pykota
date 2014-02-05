package br.edu.ifms.pykota.itens.usuarios;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import br.edu.ifms.pykota.entidades.Userpquota;
import br.edu.ifms.pykota.utilitarios.Icone;

@SuppressWarnings("serial")
public class Abas extends JTabbedPane
{	
	public Cotas cotas = new Cotas();
	
	public Abas()
	{
		this.setBounds(10,300,470,250);
		this.addTab("Cotas",new Icone("impressoras.png",15),this.cotas);
		this.addTab("Membro de",new Icone("grupos.png",15),new JPanel());
	}
}


@SuppressWarnings("serial")
class Cotas extends JScrollPane
{	
	String[] str = {"Impressora","Total Impresso","Páginas no Mês","Cota Restante","Cota Mensal"};
	int[] lar = {90,90,90,90,90};
	public TabelaCotas tabelascotas =  new TabelaCotas(str,lar);
	
	public Cotas()
	{
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.setViewportView(this.tabelascotas);
	}
	
	public void Buscar()
	{
		this.tabelascotas.Buscar();
	}
}

class TabelaCotas extends JTable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8168682852479827678L;

	public TabelaCotas(String[] nom_col,int[] lar_col)
	{
		this.setModel(new DefaultTableModel(nom_col,0));
		this.setBackground(Color.decode("#DFDFDF"));
		this.setRowHeight(20);
		this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.setBackground(Color.WHITE);
		
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
	
	public void RemoverLinha()
	{
		((DefaultTableModel)this.getModel()).removeRow(this.getSelectedRow());
	}
	
	public void Buscar()
	{	
		this.RemoverTudo();
		
		for (Userpquota us : Form.user.getUserpquotas())
		{
			String[] s = {us.getPrinters().getPrintername(),us.getLifepagecounter()+"",us.getPagecounter()+"",us.getSoftlimit()+"",us.getHardlimit()+""};
			((DefaultTableModel)this.getModel()).addRow(s);
		}
	}
	
	public boolean isCellEditable(int Rows,int Colss)
	{
		return false;
	}
	
	
}