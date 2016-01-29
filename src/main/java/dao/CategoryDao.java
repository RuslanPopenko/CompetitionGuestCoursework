package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Category;
import entity.Profile;

public interface CategoryDao {
	public Category getCategory (int id) throws SQLException;
	
	public List<Category> getCategorys() throws SQLException;

}
