package br.edu.ifms.pykota.controle;

import java.io.Serializable;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.edu.ifms.pykota.dao.DAOHibernateUtil;
import br.edu.ifms.pykota.entidades.Users;

public class Consultas
{
	private static Session session;
	
	private static void getSession()
	{
		if (session == null)
			session = DAOHibernateUtil.getSessionFactory().getCurrentSession();
	}
	
	public static Object Selecionar(Class classe, Serializable id)
	{
		getSession();
		
		session.beginTransaction();
		Object object = session.get(classe, id);
		session.getTransaction().commit();
		
		return object;
	}
	
	public static void Deletar(Class classe, Serializable id)
	{
		getSession();
		
		session.beginTransaction();
		Object object = session.get(classe, id);
		session.delete(object);
		session.getTransaction().commit();
	}
	
	public static void Deletar(Object object)
	{
		getSession();
		
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
	}
	
	public static void Atualizar(Object object)
	{
		getSession();
		
		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();
	}
	
	public static void Inserir(Object object)
	{
		getSession();
		
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
	}
	
	public static List Listar(Class classe)
	{
		getSession();
		
		return session.createCriteria(classe).list();
	}
}

/*public class Consultas {
	
	public String Consulta(int id){
		Session session = DAOHibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Users user = (Users) session.get(Users.class, id);
		String volta = user.getUsername();
		session.getTransaction().commit();
		
		return volta;
	}
	public void Apaga(int id){ 
		Session session = DAOHibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		Users user = (Users) session.get(Users.class, new Integer(id));
		String usuario = user.getUsername();
		session.delete(user);
		session.getTransaction().commit();
		JOptionPane.showMessageDialog(null, "O usuario "+usuario+" foi excluido com sucesso");
		 
	}
}*/
