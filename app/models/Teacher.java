package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.db.jpa.GenericModel;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="teachers")
public class Teacher extends GenericModel {
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
	private Subject subject;
	
	
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
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	
	

}
