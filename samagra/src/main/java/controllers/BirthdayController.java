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
	String signature="thanks and regards.....\r\n<br>" + 
			"<b>NOBLE M SAJI</b>";
	Mail mail = null;
	private static Logger log = LoggerFactory.getLogger(BirthdayController.class);

    @Autowired
    private EmailService emailService;
	 @RequestMapping(value="/birthday")
    public void findAllBirthDay() {
    	Date dateOfBirth = new Date();
    	PersonService ps = new PersonService();
    	try {
			List<PersonDAO> personDao=ps.getAllPersonByBirthDate((java.sql.Date) dateOfBirth);
			if(personDao!=null) {
				for(PersonDAO p:personDao) {
					sendEmail(p.getFirstName(),p.getLastName(),p.getEmailId());
					System.out.println(p.getFirstName()+p.getLastName()+p.getEmailId());
					log.info("sent mail tom employee");
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void sendEmail(String firstName,String LastName,String toAddress) throws MessagingException, IOException, TemplateException {
    	Map model = new HashMap();
        model.put("firstname",firstName);
        model.put("lastname",LastName);
        mail.setTo(toAddress);
        //model.put("location", "Belgium");
        model.put("signature", signature);
        model.put("filename","birthday1.jpg");
        mail.setModel(model);

        emailService.sendSimpleMessage(mail);
    }
    public void mailSetup() {
    	mail = new Mail();
        mail.setFrom("noblemsb@gmail.com");
        mail.setSubject("Happy Birthday");
    }
}