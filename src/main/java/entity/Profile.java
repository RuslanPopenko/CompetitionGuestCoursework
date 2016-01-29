package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Клас представляє сутність Профіль
 * @author Руслан Попенко
 * @version 1.0
 * @since 2015-04-14
 */
@Entity
@Table (name="profile")
public class Profile {

	/**
	 * Ідентифікатор профіля
	 */
	@Id
	@Column (name="profileID",unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int profileID;

	/**
	 * Ім'я
	 */
	@Column (name="name")
	private String name;

	/**
	 * Фото
	 */
	@Column (name="photo")
	private String photo;

	/**
	 * Пошта
	 */
	@Column (name="eMail")
	private String eMail;

	/**
	 * Контактний телефон
	 */
	@Column (name="contacts")
	private String contacts;

	/**
	 * Ідентифікатор категорії
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name="usersCategID", nullable = false)
	private Category category;

	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getProfileID() {
		return profileID;
	}

	public void setProfileID(int profileID) {
		this.profileID = profileID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	
	
	
	

}
