package br.edu.ifms.pykota.front;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import br.edu.ifms.pykota.dao.DAOHibernateUtil;
import br.edu.ifms.pykota.utilitarios.Icone;

public class Splash extends SwingWorker<Void, Integer> {
	private static JFrame tela = new JFrame();
	private static JLabel texto = new JLabel();
	private static JProgressBar progresso = new JProgressBar();
	private static JLabel lblNewLabel = new JLabel("");

	public Splash() {
		tela.setLayout(null);
		tela.setSize(700, 500);
		tela.setLocationRelativeTo(null);
		tela.setUndecorated(true);
		tela.setIconImage(new Icone("impressoras.png").getImage());

		lblNewLabel.setIcon(new ImageIcon(Splash.class
				.getResource("/br/edu/ifms/pykota/img/PykotaV.png")));
		progresso.setIndeterminate(true);

		lblNewLabel.setBounds(0, 0, 700, 500);
		progresso.setBounds(438, 460, 232, 5);
		texto.setBounds(510, 465, 200, 20);

		progresso.setForeground(new Color(255, 0, 0));
		progresso.setBackground(new Color(255, 255, 255));

		texto.setFont(new Font("Monospaced", Font.PLAIN, 12));
		texto.setForeground(Color.WHITE);

		tela.add(texto);
		tela.add(lblNewLabel);
		tela.add(progresso);

		texto.setVisible(true);
		progresso.setVisible(true);
		lblNewLabel.setVisible(true);
		tela.setVisible(true);

	}

	@Override
	protected Void doInBackground() throws Exception {
		texto.setText("Conectando aplicação...");
		DAOHibernateUtil.getSessionFactory();
		Thread.sleep(500);
		texto.setText(" Conectado com sucesso.");
		Thread.sleep(500);
		texto.setText("   Abrindo Aplicação...");
		Thread.sleep(1000);
		tela.dispose();
		Aplicacao a = new Aplicacao();
		a.Show();
		return null;
	}

	public static void main(String[] args) throws Exception {
		Splash h = new Splash();
		h.tela.setVisible(true);
		h.doInBackground();
	}

}
