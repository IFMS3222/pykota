package br.edu.ifms.pykota.utilitarios;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Botao extends JButton
{
	public Botao(String tooltip,String URL_icon,int tam)
	{
		this.setToolTipText(tooltip);
		this.setIcon(new Icone(URL_icon,tam));
		this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setRolloverIcon(new Icone(URL_icon,tam+10));
        this.setContentAreaFilled(false); 
	}
}
