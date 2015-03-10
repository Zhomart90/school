package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.jpa.GenericModel;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="classes")
public class Class  extends GenericModel{
	
	@Id
	@Expose
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Expose
	private String name;
	
	@Expose(serialize = false)
	@OneToMany(cascade=CascadeType.ALL, mappedBy="clas")
	private List<Student> students = new ArrayList<Student>();
	
	@Expose(serialize = false) 
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Subject> subjects = new ArrayList<Subject>();
	
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
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
 	

}
