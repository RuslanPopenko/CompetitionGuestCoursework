package dao;
import java.sql.SQLException;
import java.util.List;

import entity.AppForParticip;



public interface AppForParticipDao {
	public int getIdentif();
	public void addAppForParticip (AppForParticip appForParticip) throws SQLException;
	public void updateAppForParticip (AppForParticip appForParticip) throws SQLException;
	public void deleteAppForParticip (AppForParticip appForParticip) throws SQLException;
	public AppForParticip getAppForParticip (int id) throws SQLException;
	public List<AppForParticip> getAppForParticips () throws SQLException;
}
