package com.dimitrisli.springHibernateMySQL.dao;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.dimitrisli.springHibernateMySQL.model.Person;

public class PersonRowMapper implements RowMapper<Person> {

	public Person mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Person person = new Person();
		person.setName(resultSet.getString(1));
		person.setSurname(resultSet.getString(2));
		return person;
	}	
}


