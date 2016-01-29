package factoryDao;

import dao.AppForParticipDao;
import dao.CategoryDao;
import dao.CompetitionDao;
import dao.ProfileDao;
import daoImpl.AppForParticipDaoImpl;
import daoImpl.CategoryDaoImpl;
import daoImpl.CompetitionDaoImpl;
import daoImpl.ProfileDaoImpl;


public class Factory {
	public static Factory instance = new Factory();
	private ProfileDao profileDao;
	private CategoryDao categoryDao;
	private CompetitionDao competitionDao;
	private AppForParticipDao appForParticipDao;
	
	private Factory (){
		
	}
	
	public static Factory getInstance(){
		return Factory.instance;
	}
	
	public ProfileDao getProfileDao (){
		if (profileDao == null) {
			profileDao = new ProfileDaoImpl();
		}
		return profileDao;
	}
	
	public CategoryDao getCategoryDao (){
		if (categoryDao == null) {
			categoryDao = new CategoryDaoImpl();
		}
		return categoryDao;
	}
	
	public CompetitionDao getCompetitionDao (){
		if (competitionDao == null) {
			competitionDao = new CompetitionDaoImpl();
		}
		return competitionDao;
	}
	public AppForParticipDao getAppForParticipDao (){
		if (appForParticipDao == null) {
			appForParticipDao = new AppForParticipDaoImpl();
		}
		return appForParticipDao;
	}
	

}
