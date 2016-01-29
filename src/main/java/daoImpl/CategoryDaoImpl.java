package daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import entity.Category;

import persistence.HibernateUtil;
import dao.CategoryDao;


public class CategoryDaoImpl implements CategoryDao {



	@Override
	public Category getCategory(int id) throws SQLException {
		Category result=null;
		
		Session session = null;
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			 result = (Category) session.get(Category.class, id);		 
				
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if ((session!= null) && (session.isOpen()))
				session.close();
		}
		return result;
	}

	@Override
	public List<Category> getCategorys() throws SQLException {
		List<Category> categories = null;
		Session session = null;
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			 categories = (List<Category>) session.createQuery("from Category").list();	 
				
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if ((session!= null) && (session.isOpen()))
				session.close();
		}
		return categories;
	}
	
}
