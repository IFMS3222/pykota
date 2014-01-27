package br.edu.ifms.pykota.controle;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Criteria;

import br.edu.ifms.pykota.dao.DAOHibernateUtil;
import br.edu.ifms.pykota.entidades.Users;

public class Consultas {
	private static Session session;

	private static void getSession() {
		if (session == null)
			session = DAOHibernateUtil.getSessionFactory();
	}

	public static Criteria getNovoFiltro(Class classe) {
		getSession();

		return session.createCriteria(classe);
	}

	public static Object Selecionar(Class classe, Serializable id) {
		getSession();

		session.beginTransaction();
		Object object = session.get(classe, id);
		session.getTransaction().commit();

		return object;
	}

	public static void Deletar(Class classe, Serializable id) {
		getSession();

		session.beginTransaction();
		Object object = session.get(classe, id);
		session.delete(object);
		session.getTransaction().commit();
	}

	public static void Deletar(Object object) {
		getSession();

		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
	}

	public static void Editar(Object object) {
		getSession();

		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();
	}

	public static void Inserir(Object object) {
		getSession();

		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
	}

	public static List Listar(Class classe) {
		getSession();

		session.beginTransaction();
		List lista = getNovoFiltro(classe).list();
		session.getTransaction().commit();

		return lista;
	}

	public static List ListarComFiltro(Criteria filtro) {
		getSession();

		session.beginTransaction();
		List lista = filtro.list();
		session.getTransaction().commit();

		return lista;
	}
}
