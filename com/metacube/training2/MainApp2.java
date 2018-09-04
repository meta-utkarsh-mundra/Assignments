package com.metacube.training2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.metacube.training.TextEditor;

public class MainApp2 {

	public static void main(String[] args) {
		
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext context = new ClassPathXmlApplicationContext("springUsingCollection.xml");
		TextEditor2 te = (TextEditor2) context.getBean("text_editor2");
		te.textEditor2();
	}

}
