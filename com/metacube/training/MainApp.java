package com.metacube.training;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
@SuppressWarnings("deprecation")
public class MainApp {

	public static void main(String[] args) {
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext context = new ClassPathXmlApplicationContext("springUsingSetter.xml");
		TextEditor te = (TextEditor) context.getBean("text_editor");
		te.textEditor();
		
	}
}
