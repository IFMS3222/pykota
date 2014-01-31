package br.edu.ifms.pykota.main;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.edu.ifms.pykota.controle.Cadastros;
import br.edu.ifms.pykota.controle.Consultas;
import br.edu.ifms.pykota.entidades.Users;
import br.edu.ifms.pykota.front.*;

public class Main extends JFrame {

	public static void main(String[] args) throws Exception {
		String menu=null;
		
		Splash.main(args);
		
		/*
		//Consultas.Deletar(Users.class, 15); //new Main(); String menu=null;
		do {
			menu = JOptionPane.showInputDialog("insira um numero para Menu");
			switch (menu) {
			case "1":
				Cadastros c = new Cadastros();
				Consultas.Inserir(c.Insere_User());
				break;
			case "2":
				String chama = "null";
				do {
					chama = JOptionPane
							.showInputDialog("insira um numero para consulta");
					try {
						Users a = (Users) Consultas.Selecionar(Users.class,Integer.parseInt(chama));
						JOptionPane.showConfirmDialog(null, a.getUsername());
					} catch (NullPointerException npe) {
						JOptionPane.showConfirmDialog(null,
								"Usuario nao Encontrado");
					}
				} while (!chama.equals("0"));
				break;
			case "3":
				List<Users> p1 = Consultas.Listar(Users.class);
				for (Users p : p1)
					System.out.println("Nome: " + p.getUsername() + " E-mail "
							+ p.getEmail());
				break;
			case "4":
				String nome = "1";
				List<Users> p3 = Consultas.ListarComFiltro(Consultas.getNovoFiltro(Users.class).add(Restrictions.like("username", "1", MatchMode.ANYWHERE))
				.addOrder(Order.asc("username")));

				for (Users p : p3)
					System.out.println("findPessoasByNome: " + p.getUsername());
				break;
			}

		} while (!menu.equals("0"));

		*/

	}
}
