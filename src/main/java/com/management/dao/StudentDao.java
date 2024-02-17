package com.management.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.management.model.Student;
import com.management.utils.HibernateUtils;

import exceptions.SQLIntegrityConstraintViolationException;

public class StudentDao implements Dao<Student> {

	private List<Student> persons = new ArrayList<>();
	private static String DEFAULT_DATABASE = "management";
	
	public StudentDao() {
		HibernateUtils.setup(DEFAULT_DATABASE);
		persons = HibernateUtils.findAllStudentsWithJpql();
    }

	@Override
	public Optional<Student> get(long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(persons.get((int) id));
	}

	@Override
	public List<Student> getAll() {
		persons = HibernateUtils.findAllStudentsWithJpql();

		return persons;
	}

	@Override
	public void save(Student s) {
		HibernateUtils.save(s);
		persons = HibernateUtils.findAllStudentsWithJpql();
	}

	@Override
	public void update(Student p, String[] params) {
		// TODO Auto-generated method stub
		p.setFirstname(Objects.requireNonNull(
		        params[0], "Name cannot be null"));
		p.setLastname(Objects.requireNonNull(
		        params[1], "Email cannot be null"));
		p.setAge(Objects.requireNonNull(
		        Integer.parseInt(params[2]), "Age cannot be null"));
		p.setEmail(Objects.requireNonNull(
		        params[3], "Age cannot be null"));
		        
		persons.add(p);
	}

	@Override
	public void delete(Student p) {
		// TODO Auto-generated method stub
		if (persons.contains(p))
			persons.remove(p);
		HibernateUtils.delete(p);
	}
	
	@Override
	public void deleteAll() {
		persons = new ArrayList<>();
		HibernateUtils.deleteAll();
	}
}
