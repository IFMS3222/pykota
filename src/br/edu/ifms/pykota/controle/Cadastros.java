package br.edu.ifms.pykota.controle;

import java.util.Random;

import javax.swing.JOptionPane;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.*;


import br.edu.ifms.pykota.dao.DAOHibernateUtil;
import br.edu.ifms.pykota.entidades.Users;;

public class Cadastros {
	
/*essa classe insere novos usuarios a partir do pykotaadmin, setado no sql*/
public void Insere_User() {		
		
		Session session = DAOHibernateUtil.getSessionFactory().getCurrentSession();
		
		Users dados = new Users();
		
		Random gerador = new Random();
		dados.setUsername("Felipe"+gerador.nextInt());
		dados.setEmail("Tads");
		dados.setLifetimepaid((float) 1.0);
		dados.setDescription("teste");
		dados.setLimitby("teste");
		dados.setBalance((float) 1.0);
		
		session.beginTransaction();
		session.save(dados);
		session.getTransaction().commit();
		JOptionPane.showMessageDialog(null, "Gravado com sucesso !");
		
	}
	
}