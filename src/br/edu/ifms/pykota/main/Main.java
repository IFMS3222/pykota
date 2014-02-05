package br.edu.ifms.pykota.main;

import javax.swing.JFrame;
import br.edu.ifms.pykota.front.*;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {
		
		//Splash.main(args);
		Aplicacao a = new Aplicacao();
		a.Show();
	}
}
