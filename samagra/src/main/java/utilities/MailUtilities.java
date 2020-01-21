package utilities;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtilities {
	private Properties props;
	Session session;
	MimeMessage message;
	final String username = "noblemsb@gmail.com";
    final String pass = "Imm@1522";
public void setMailUtilities() {
	props = System.getProperties();
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.user",username);
    props.put("mail.smtp.password", pass);
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");
    session = Session.getDefaultInstance(props, null);
}
public void setMessage(String to,String cC,String bCC,String subject,String body) throws AddressException, MessagingException {
	message = new MimeMessage(session);
	message.setFrom(new InternetAddress(username));
     message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
     message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cC));
     message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bCC));
     message.setSubject(subject);
     message.setContent(body,"text/html; charset=utf-8");
     Transport transport = session.getTransport("smtp");
     transport.connect("smtp.gmail.com", username, pass);
     transport.sendMessage(message, message.getAllRecipients());
     transport.close();
     System.out.println("mail has been send");
}
/*public String getAddressAppended(String[] addresses) {
	String address = null;
	for(int i=0;i<addresses.length;i++) {
		address=addresses[i]+",";
	}
	return address;
}*/
public static void main(String[] args) {
	String mailBODY = "<h3>Hi this is my test Mail</h3><br>this is a test mail</br><img src=\"index.jpg\"></img>";
	 MailUtilities mu= new  MailUtilities();
	 mu.setMailUtilities();
	 try {
		mu.setMessage("noblemsn@gmail.com", "noblemsa@gmail.com","msnoblems@gmail.com", "Hi", mailBODY);
	} catch (AddressException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
