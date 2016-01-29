package entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Клас представляє сутність Заявка на участь
 * @author Руслан Попенко
 * @version 1.0
 * @since 2015-04-14
 */
@Entity
@Table (name="appForParticip")
public class AppForParticip {

	/**
	 * Ідентифікатор заявки на участь
	 */
	@Id
	@Column (name="appForParticipID",unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int appForParticipID;

	/**
	 * Дата створення заявки
	 */
	@Column (name="date")
	private Timestamp date;

	/**
	 * Результат реєстрації заявки
	 */
	@Column (name="result", columnDefinition = "TINYINT(1)")
	private boolean result;

	/**
	 * Ідентифікатор змагання
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name="competitionID", referencedColumnName="competition_id")
	private Competition competition;

	/**
	 * Ідентифікатор категорії користувача
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name="usersCategoryID", referencedColumnName="users_categ_id")
	private Category category;

	/**
	 * Ідентифікатор профілю
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name="profileID", referencedColumnName="profileID")
	private Profile profile;


	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public int getAppForParticipID() {
		return appForParticipID;
	}
	
	public void setAppForParticipID(int appForParticipID) {
		this.appForParticipID = appForParticipID;
	}
	
	public Timestamp getDate() {
		return date;
	}
	
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	public boolean getResult() {
		return result;
	}
	
	public void setResult(boolean result) {
		this.result = result;
	}



}
