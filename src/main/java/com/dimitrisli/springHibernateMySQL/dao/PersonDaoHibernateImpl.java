package com.dimitrisli.springHibernateMySQL.dao;

import java.util.List;

import com.dimitrisli.springHibernateMySQL.model.Person;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PersonDaoHibernateImpl extends HibernateDaoSupport implements PersonORMDao{

	public void create(Person person) {
		getHibernateTemplate().save(person);
	}

	public Person read(String name, String surname) {
		List<Person> list = getHibernateTemplate().find("from PERSON_RECORD where NAME=? AND SURNAME=?",name,surname);
		return (Person) list.get(0);
	}
	
	public List<Person> readAll() {
		List<Person> list = getHibernateTemplate().find("from " + Person.class.getName());
		return list;
	}

	public void update(Person person) {
		getHibernateTemplate().update(person);
	}

	public void delete(Person person) {
		getHibernateTemplate().delete(person);
	}
	
	public void deleteAll() {
		getHibernateTemplate().deleteAll(readAll());
	}
}
