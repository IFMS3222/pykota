package br.edu.ifms.pykota.utilitarios;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FundoPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage img;
	
	public FundoPanel()
	{
		try {
	      img = ImageIO.read(getClass().getResource("/br/edu/ifms/pykota/img/fundo_ap.png"));
	    } catch(IOException e) {
	      e.printStackTrace();
	    }
	}
	@Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    // paint the background image and scale it to fill the entire space
	    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	  }

}
