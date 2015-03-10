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
import play.db.jpa.Model;

import com.google.gson.annotations.Expose;
import com.sun.xml.internal.ws.api.server.Module;

@Entity
@Table(name="subjects")
public class Subject extends GenericModel{
	
	@Id
	@Expose
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
    
	@Expose
	private String name;
	
	@Expose(serialize = false)
	@ManyToMany(mappedBy = "subjects")
	private List <Class> classes = new ArrayList<Class>();
	
	@Expose(serialize = false)
	@OneToMany(cascade=CascadeType.ALL, mappedBy="subject")
	private List <Teacher> teachers = new ArrayList<Teacher>(); 
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
