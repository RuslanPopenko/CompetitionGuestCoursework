package persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Клас для взаємодії з конфіг файлами і створення обєкту SessionFactory,котрий відповідає за створення hibernate-сесії
 * @author Руслан Попенко
 * @version 1.0
 * @since 2015-04-14
 */
public class HibernateUtil {
	/**
	 * об'єкт SessionFactory,котрий відповідає за створення hibernate-сесії
	 */
	private static SessionFactory sessionFactory;


	private HibernateUtil () {

	}

	/**
	 * Створює нову сесію із hibernate.cfg.xml
	 */
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable e){
			throw new ExceptionInInitializerError(e);
		}
		
	}

	/**
	 * Повертає обєкт SessionFactory
	 * @return обєкт SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	
	 
 
}
