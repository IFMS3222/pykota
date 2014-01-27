package br.edu.ifms.pykota.dao;

import javax.swing.JOptionPane;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 * 
 * @author Felipe
 */
@SuppressWarnings("deprecation")
public class DAOHibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			// Create the SessionFactory from standard (hibernate.cfg.xml)
			// config file.

			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			// Log the exception.
			JOptionPane
					.showMessageDialog(null,
							"Não foi Posiivel estabelecer conexão, por favor contate o administrador");
			System.err.println("Initial SessionFactory creation failed." + ex);
			System.exit(0);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSessionFactory() {
		return sessionFactory.openSession();

	}

}
