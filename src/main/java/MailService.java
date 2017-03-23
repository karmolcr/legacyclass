import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class MailService {

    private final SenderAccount senderAccount;
    private final SMTPConfiguration SMTPConfiguration;
    private String RECIPIENT = "karmolcr@gmail.com";

    public MailService(String host, String smtpPort, SenderAccount senderAccount, SMTPConfiguration smtpConfiguration) {
        SMTPConfiguration = new SMTPConfiguration();
        this.SMTPConfiguration.host = host;
        this.SMTPConfiguration.smtpPort = smtpPort;
        this.senderAccount = new SenderAccount();
    }

    public void sendMail() {
        String from = senderAccount.USER_NAME;
        String pass = senderAccount.PASSWORD;
        String[] to = { RECIPIENT }; // list of recipient email addresses
        String subject = "Java send mail example";
        String body = "Welcome to JavaMail!";

        sendFromGMail(from, pass, to, subject, body);
    }


    private void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTPConfiguration.host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", SMTPConfiguration.smtpPort);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(SMTPConfiguration.host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}