package lt.vu.mif.labanorodraugai.Beans;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Sarunas
 */
@Named
@Stateless
public class EmailSender {

    private List<String> emailTo;
    private final String subject = "Bandymas";
    private final String body = "Jums siuncia Labanoro draugai";

    private final int port = 587;
    private final String host = "smtp.mail.yahoo.com";
    private final String auth = "true";
    private final String tls = "true";
    private final String username = "saruneliss@yahoo.com";
    private final String password = "Lyra3365";
    private final boolean debug = true;

    public void setEmailTo(List<String> emailTo) {
        this.emailTo = emailTo;
    }

    public void sendEmail() {

        Session session = Session.getInstance(setProperties(), setAuthenticator());
        session.setDebug(debug);

        if (!emailTo.isEmpty()) {
            MimeMessage message = new MimeMessage(session);
            try {
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO, setRecipients());
                message.setSubject(subject);
                message.setSentDate(new Date());
                message.setText(body);
                Transport.send(message);
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
            emailTo.clear();
        }
    }

    public Properties setProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.starttls.enable", tls);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        return props;
    }

    public Authenticator setAuthenticator() {
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
        return authenticator;
    }

    public InternetAddress[] setRecipients() throws AddressException {
        InternetAddress[] cc = new InternetAddress[emailTo.size()];
        int counter = 0;
        for (String email : emailTo) {
            cc[counter] = new InternetAddress(email);
            counter++;
        }
        return cc;
    }
}
