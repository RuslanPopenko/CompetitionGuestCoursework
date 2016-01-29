package daoImpl;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import entity.AppForParticip;

import persistence.HibernateUtil;
import dao.AppForParticipDao;
public class AppForParticipDaoImpl implements AppForParticipDao{
	private int identif;

	@Override
	public void addAppForParticip(AppForParticip appForParticip) throws SQLException {
		Session session = null;
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			 session.beginTransaction();
			 session.save(appForParticip);
			 identif=appForParticip.getAppForParticipID();
			 session.getTransaction().commit();			
				
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if ((session!= null) && (session.isOpen()))
				session.close();
		}
		
	}

	@Override
	public void updateAppForParticip(AppForParticip appForParticip) throws SQLException {
		Session session = null;
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			 session.beginTransaction();
			 session.update(appForParticip);
			 session.getTransaction().commit();			
				
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if ((session!= null) && (session.isOpen()))
				session.close();
		}
		
	}

	@Override
	public void deleteAppForParticip(AppForParticip appForParticip) throws SQLException {
		Session session = null;
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			 session.beginTransaction();
			 session.delete(appForParticip);
			 session.getTransaction().commit();			
				
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if ((session!= null) && (session.isOpen()))
				session.close();
		}
		
	}

	@Override
	public AppForParticip getAppForParticip(int id) throws SQLException {
		AppForParticip result=null;
		
		Session session = null;
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			 result = (AppForParticip) session.get(AppForParticip.class, id);		 
				
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if ((session!= null) && (session.isOpen()))
				session.close();
		}
		return result;
	}

	@Override
	public List<AppForParticip> getAppForParticips() throws SQLException {
		List<AppForParticip> appForParticips = null;
		Session session = null;
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			 appForParticips = session.createCriteria(AppForParticip.class).list();	 
				
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if ((session!= null) && (session.isOpen()))
				session.close();
		}
		return appForParticips;
	}
	@Override
	public int getIdentif () {
		return identif;
	}

}
