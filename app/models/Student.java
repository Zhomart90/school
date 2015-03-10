package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import play.db.jpa.GenericModel;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="students")
public class Student  extends GenericModel{
	@Id
	@Expose
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Expose 
	private String name;
	@Expose
	private String surname;
	@Expose 
	private String patronymic;
	
	@Expose
	@ManyToOne
	private Class clas;
	
	

	
	
	public Class getClas() {
		return clas;
	}
	public void setClas(Class clas) {
		this.clas = clas;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	

}
