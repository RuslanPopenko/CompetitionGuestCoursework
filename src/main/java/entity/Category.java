package entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * Клас представляє сутність Категорія
 * @author Руслан Попенко
 * @version 1.0
 * @since 2015-04-14
 */
@Entity
@Table(name="users_categ")
public class Category {

	/**
	 * Ідентифікатор категорії
	 */
	@Id
	@Column(name="users_categ_id",unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	/**
	 * Категорія користувача
	 */
	@Column(name="category")
	private String categ;
	
	
	public void setId (int id){
		this.id=id;
	}
	public void setCateg (String categ)	{
		this.categ=categ;	
	}
	public int getId (){
		return id;
	}
	public String getCateg (){
		return categ;
	}
}

