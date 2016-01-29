package daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import entity.Competition;


import persistence.HibernateUtil;
import dao.CompetitionDao;

public class CompetitionDaoImpl implements CompetitionDao{

	@Override
	public void addCompetition(Competition competition) throws SQLException {
		Session session = null;
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			 session.beginTransaction();
			 session.save(competition);
			 session.getTransaction().commit();			
				
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if ((session!= null) && (session.isOpen()))
				session.close();
		}
		
	}

	@Override
	public void updateCompetition(Competition competition) throws SQLException {
		Session session = null;
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			 session.beginTransaction();
			 session.update(competition);
			 session.getTransaction().commit();			
				
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if ((session!= null) && (session.isOpen()))
				session.close();
		}
		
	}

	@Override
	public void deleteCompetition(Competition competition) throws SQLException {
		Session session = null;
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			 session.beginTransaction();
			 session.delete(competition);
			 session.getTransaction().commit();			
				
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if ((session!= null) && (session.isOpen()))
				session.close();
		}
		
		
	}

	@Override
	public Competition getCompetition(int id) throws SQLException {
		Competition result=null;
		
		Session session = null;
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			 result = (Competition) session.get(Competition.class, id);		 
				
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if ((session!= null) && (session.isOpen()))
				session.close();
		}
		return result;
	
	}

	@Override
	public List<Competition> getCompetitions() throws SQLException {
		List<Competition> competitions = null;
		Session session = null;
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			 competitions = session.createCriteria(Competition.class).list();	 
				
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if ((session!= null) && (session.isOpen()))
				session.close();
		}
		return competitions;
		
	}
	

}
