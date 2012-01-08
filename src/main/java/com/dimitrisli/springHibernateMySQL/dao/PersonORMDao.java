package com.dimitrisli.springHibernateMySQL.dao;

import com.dimitrisli.springHibernateMySQL.model.Person;

public interface PersonORMDao {

	public void create(Person person);
	public Person read(String name, String surname);
	public void update(Person person);
	public void delete(Person person);
}
