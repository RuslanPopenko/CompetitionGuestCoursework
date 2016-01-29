package dao;


import java.sql.SQLException;
import java.util.List;

import entity.Competition;


public interface CompetitionDao {

	public void addCompetition (Competition competition) throws SQLException;
	public void updateCompetition (Competition competition) throws SQLException;
	public void deleteCompetition (Competition competition) throws SQLException;
	public Competition getCompetition (int id) throws SQLException;
	public List<Competition> getCompetitions () throws SQLException;
}

