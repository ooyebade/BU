import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;
public class SendingEmail {
    private String host = "";
    private int port = 0;
    private String username = "";
    private String password = "";
    private void sendMail(String host, int port, String username, String password) {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.ssl.trust", host);
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("testsender@noemail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("rezar@bu.edu"));
            message.setSubject("Mail Subject");
            String msg = "This is a test email using JavaMailer";
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace(); }
    }

    public static void main(String ... args) {
        SendingEmail semail = new SendingEmail();
        System.out.println("start initiating the connection");
        semail.sendMail("localhost", 25, "someusername", "somepass");
        System.out.println("email send process is finished");
    }
}