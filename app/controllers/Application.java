package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.*;
import models.Class;

public class Application extends Controller {

	public static void index() {
		render();
	}

	public static void adminPage() {
		render();
	};

	public static void addSubject(Subject subject) {
		System.out.println("addSubject method is called");
		System.out.println("subject name: " + subject.getName());
		subject.save();
		adminPage();
	}

	public static void addTeacher(String name, String surname,
			String patronymic, String subject) {
		System.out.println("addTeacher method is called");
		System.out.println("name: " + name);
		System.out.println("surname: " + surname);
		System.out.println("patronymic: " + patronymic);
		System.out.println("subject: " + subject);
		Teacher teacher = new Teacher();
		teacher.setName(name);
		teacher.setSurname(surname);
		teacher.setPatronymic(patronymic);
		Subject sub = Subject.find("byName", subject).first();
		if (sub != null) {
			teacher.setSubject(sub);
		}
		teacher.save();
		adminPage();
	}

	public static void addStudent(String name, String surname,
			String patronymic, String clas) {
		System.out.println("addTeacher method is called");
		System.out.println("name: " + name);
		System.out.println("surname: " + surname);
		System.out.println("patronymic: " + patronymic);
		System.out.println("clas: " + clas);
		Student student = new Student();
		student.setName(name);
		student.setSurname(surname);
		student.setPatronymic(patronymic);
		Class cl = Class.find("byName", clas).first();
		if (cl != null) {
			student.setClas(cl);
		}
		student.save();
		adminPage();
	}

	public static void addClass(String name, String subjects) {
		Class clas = new Class();
		List<Subject> classSubjects = new ArrayList<Subject>();
		System.out.println("classSubjects" +classSubjects);
		System.out.println("name: " + name);
		System.out.println("subjects: " + subjects);
		String[] subs = subjects.split(", ");
		for (int i = 0; i < subs.length; i++) {
			System.out.println("sub:" + subs[i]);
			Subject subject = Subject.find("byName", subs[i]).first();
			if (subject != null) {
				classSubjects.add(subject);
			}
		}
		System.out.println("classSubjects size: " + classSubjects.size());
		
		
		clas.setName(name);
		clas.setSubjects(classSubjects);
		ArrayList<Subject> array = (ArrayList) clas.getSubjects();
		for (Subject s: array){
			System.out.println("S name: "+s.getName());
		}
		clas.save();
		
		long id = 47;
		
		Class c = Class.findById(id);
		System.out.println("c name: "+c.getName());
		List<Subject> list = c.getSubjects();
		System.out.println("list size: "+list.size());
		for (Subject s: list){
			System.out.println("subject id 47 and name------- : "+s.getName());
		}
		
		
		
		

	}

	public static void getAllSubjects() {
		System.out.println("Trying to get all subjects");
		List<Subject> subjects = Subject.findAll();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(subjects);
		renderJSON(json);

	}

	public static void getAllTeachers() {
		System.out.println("Trying to get all teachers");
		List<Teacher> teachers = Teacher.findAll();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(teachers);
		renderJSON(json);

	}

	public static void getAllStudents() {
		System.out.println("Trying to get all subjects");
		List<Student> students = Student.findAll();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(students);
		renderJSON(json);
	}

	public static void getAllClasses() {
		System.out.println("Trying to get all subjects");
		List<Class> classes = Class.findAll();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(classes);
		renderJSON(json);
	}

}