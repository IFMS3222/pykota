package br.edu.ifms.pykota.controle;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import org.hibernate.Session;

import br.edu.ifms.pykota.entidades.Users;;

public class Cadastros {
	
/*essa classe insere novos usuarios a partir do pykotaadmin, setado no sql*/
public void Insere_User() {		
		
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pykota"); 
		
		/*manipular as entidades da nossa aplicação*/
		EntityManager em = emf.createEntityManager();
		
		Session session = (Session) em.getDelegate();
		
		Users dados = new Users();
		
		em.getTransaction().begin(); 
		
		Random gerador = new Random();
		dados.setUsername("teste"+gerador.nextInt());
		dados.setEmail("Tads");
		dados.setLifetimepaid((float) 1.0);
		dados.setDescription("teste");
		dados.setLimitby("teste");
		dados.setBalance((float) 1.0);
		
		/*armazena as informações de um objeto no banco de dados, */
		em.persist(dados);
		
		
		/*Para conﬁrmar uma transação, devemos usar o método commit(). Quando esse método é invo-
		do, ocorre uma sincronização como banco de dados e a transação é ﬁnalizada.*/
		em.getTransaction().commit(); 
		JOptionPane.showMessageDialog(null, "Gravado com sucesso !");
		emf.close();
	}
	
}
