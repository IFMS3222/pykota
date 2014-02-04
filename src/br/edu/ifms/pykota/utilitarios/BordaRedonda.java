package br.edu.ifms.pykota.utilitarios;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JTextField;

public class BordaRedonda extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paintComponent(Graphics g) {
		if (!isOpaque()) {
			int w = getWidth();
			int h = getHeight();
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(Color.WHITE);
			g2.fillRoundRect(0, 0, w - 1, h - 1, 12, 12);
			g2.setColor(Color.decode("#8692AA"));
			g2.drawRoundRect(0, 0, w - 1, h - 1, 8, 8);
			g2.dispose();
		}
		super.paintComponent(g);
	}
	
	
}
