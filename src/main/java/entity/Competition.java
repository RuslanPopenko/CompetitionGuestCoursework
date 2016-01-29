package entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * Клас представляє сутність Змагання
 * @author Руслан Попенко
 * @version 1.0
 * @since 2015-04-14
 */
@Entity
@Table(name="competition")
public class Competition {

	/**
	 * Ідентифікатор змагання
	 */
	@Id
	@Column(name="competition_id",unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	/**
	 * Місце змагання
	 */
	@Column(name="place")
	private String place;

	/**
	 * Дата змагання
	 */
	@Column(name="date")
	private Timestamp date;

	/**
	 * Опис змагання
	 */
	@Column(name="description")
	private String description;

	/**
	 * Нагородження учасників змаганяя
	 */
	@Column(name="rewarding")
	private String rewarding;
	
	public void setId (int id){
		this.id=id;
	}
	public void setPlace (String place)	{
		this.place=place;	
	}
	public void setDate (Timestamp date)	{
		this.date=date;	
	}
	public void setDescription (String description)	{
		this.description=description;	
	}
	public void setRewarding (String rewarding)	{
		this.rewarding=rewarding;	
	}
	
	public int getId (){
		return id;
	}
	public String getPlace (){
		return place;
	}
	public Timestamp getDate (){
		return date;
	}
	public String getDescription (){
		return description;
	}
	public String getRewarding (){
		return rewarding;
	}
	
		
}

