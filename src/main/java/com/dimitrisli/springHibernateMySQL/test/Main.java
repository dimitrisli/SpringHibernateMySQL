package com.dimitrisli.springHibernateMySQL.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dimitrisli.springHibernateMySQL.dao.PersonDaoHibernateImpl;
import com.dimitrisli.springHibernateMySQL.model.Person;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/beanLocations.xml");
		PersonDaoHibernateImpl personDao = (PersonDaoHibernateImpl) context.getBean("personHibernateDao"); 
		
		System.out.println("Adding data...");
		Person dimitris = new Person(); dimitris.setName("dimitris"); dimitris.setSurname("liapis");
		Person michalis = new Person(); michalis.setName("michalis"); michalis.setSurname("liapis");
		Person kostas = new Person(); kostas.setName("kostas"); kostas.setSurname("liapis");
		Person stella = new Person(); stella.setName("stella"); stella.setSurname("liapis");
		personDao.create(dimitris);
		personDao.create(michalis);
		personDao.create(kostas);
		personDao.create(stella);
		
		System.out.println("Retrieving data..");
		for(Person currentPerson : personDao.readAll()){
			System.out.println("From DB: name="+currentPerson.getName()+", surname="+currentPerson.getSurname());
		}
		
		System.out.println("Deleting a record and viewing...");
		personDao.delete(kostas);
		for(Person currentPerson : personDao.readAll()){
			System.out.println("From DB: name="+currentPerson.getName()+", surname="+currentPerson.getSurname());
		}
		
		System.out.println("Updating a record and viewing...");
		dimitris.setName("newDimitrisName");
		personDao.update(dimitris);
		for(Person currentPerson : personDao.readAll()){
			System.out.println("From DB: name="+currentPerson.getName()+", surname="+currentPerson.getSurname());
		}
		
		System.out.println("Deleting everything and viewing...");
		personDao.deleteAll();
		for(Person currentPerson : personDao.readAll()){
			System.out.println("From DB: name="+currentPerson.getName()+", surname="+currentPerson.getSurname());
		}
		
	}
}
