package com.metacube.training3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.metacube.training2.TextEditor2;

public class PersonMain {

	public static void main(String[] args) {
		ApplicationContext context1 = new ClassPathXmlApplicationContext("singletonPerson.xml");
		//ApplicationContext context2 = new ClassPathXmlApplicationContext("prototypePerson.xml");
		Person p1 = (Person) context1.getBean("singPerson");
		//Person p2 = (Person) context2.getBean("protoPerson");
		p1.showPerson();
		//p2.showPerson();
	}

}
