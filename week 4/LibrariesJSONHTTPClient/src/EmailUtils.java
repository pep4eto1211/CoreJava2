import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtils {
    public static void sendEmail(String subject, String message, String receiver, String username, String password,
                                 String userEmail) throws EmailException{
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(username, password));
        email.setSSLOnConnect(true);
        email.setFrom(userEmail);
        email.setSubject(subject);
        email.setMsg(message);
        email.addTo(receiver);
        email.send();
    }
}
