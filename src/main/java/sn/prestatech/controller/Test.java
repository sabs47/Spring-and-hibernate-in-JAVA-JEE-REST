package sn.prestatech.controller;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.*;


public class Test {
	
public void sendMail(String nom) {
	
	Resource r=new ClassPathResource("applicationContext.xml");
	BeanFactory b=new XmlBeanFactory(r);
	MailMail m=(MailMail)b.getBean("mailMail");
	
	m.sendMail("hadjisabs@gmail.com","eminemsabaly@hotmail.fr","hi",""+nom);
	
	System.out.println("success");
}
}
