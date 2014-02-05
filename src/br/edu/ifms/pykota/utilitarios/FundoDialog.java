package br.edu.ifms.pykota.utilitarios;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FundoDialog extends JPanel{
	private BufferedImage img;
	
	public FundoDialog(){
		this.setBounds(0, 0, 800, 600);
		this.setLayout(null);

		try {
		      img = ImageIO.read(getClass().getResource("/br/edu/ifms/pykota/img/fundo_ap.png"));
		    } catch(IOException e) {
		      e.printStackTrace();
		    }
	}
	@Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	  }

}
