package br.edu.ifms.pykota.utilitarios;

import java.awt.Image;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Icone extends ImageIcon 
{
	public Icone(String url) 
	{
		ImageIcon imgic = new ImageIcon(getClass().getResource("../img/"+url));
		Image img = imgic.getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		this.setImage(img);
	}
	
	public Icone(String url,int tam) 
	{
		ImageIcon imgic = new ImageIcon(getClass().getResource("../img/"+url));
		Image img = imgic.getImage().getScaledInstance(tam, tam,Image.SCALE_SMOOTH);
		this.setImage(img);
	}
}
