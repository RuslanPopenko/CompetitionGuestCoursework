package daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import entity.Profile;
import persistence.HibernateUtil;
import dao.ProfileDao;

public class ProfileDaoImpl implements ProfileDao {

	@Override
	public void addProfile(Profile profile) throws SQLException {
		Session session = null;
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			 session.beginTransaction();
			 session.save(profile);
			 session.getTransaction().commit();			
				
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if ((session!= null) && (session.isOpen()))
				session.close();
		}
		
	}

	@Override
	public void deleteProfile(Profile profile) throws SQLException {
		Session session = null;
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			 session.beginTransaction();
			 session.delete(profile);
			 session.getTransaction().commit();			
				
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if ((session!= null) && (session.isOpen()))
				session.close();
		}
		
	}

	@Override
	public Profile getProfile(int id) throws SQLException {
		Profile result=null;
		
		Session session = null;
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			 result = (Profile) session.get(Profile.class, id);		 
				
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if ((session!= null) && (session.isOpen()))
				session.close();
		}
		return result;
	}

	@Override
	public List<Profile> getProfiles() throws SQLException {
		List<Profile> profiles = null;
		Session session = null;
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			 profiles = session.createCriteria(Profile.class).list();	 
				
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if ((session!= null) && (session.isOpen()))
				session.close();
		}
		return profiles;
	}

	@Override
	public void updateProfile(Profile profile) throws SQLException {
		Session session = null;
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			 session.beginTransaction();
			 session.update(profile);
			 session.getTransaction().commit();			
				
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if ((session!= null) && (session.isOpen()))
				session.close();
		}
		
	}
	  

}
