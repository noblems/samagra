package controllers;
import entity.PersonDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import freemarker.template.TemplateException;
import mail.EmailService;
import mail.Mail;
import service.basic.PersonService;

import java.util.List;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
@RestController
public class BirthdayController {
	@RequestMapping(value="/birthday")
    public String findAllBirthDay() {
    	Date dateOfBirth = new Date();
    	PersonService ps = new PersonService();
    	try {
			List<PersonDAO> personDao=ps.getAllPersonByBirthDate((java.sql.Date) dateOfBirth);
			if(personDao!=null) {
				
			}
			return "sent mail tom employee";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "some erro";
		}
    }
 
}