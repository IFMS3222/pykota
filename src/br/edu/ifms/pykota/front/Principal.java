package br.edu.ifms.pykota.front;

import javax.swing.JFrame;

public class Principal extends JFrame {
	public Principal() {
		ver v = new ver();

		this.setLayout(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(v);
	}

	public static void main(String[] args) {
		new Principal();
	}
}
