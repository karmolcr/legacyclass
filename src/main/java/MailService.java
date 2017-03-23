import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class MailService {

    private final SenderAccount senderAccount;
    private final SMTPConfiguration smtpConfiguration;
    private String RECIPIENT = "karmolcr@gmail.com";

    private String[] to; // list of recipient email addresses
    private String subject;
    private String body;

    public MailService(SenderAccount senderAccount, SMTPConfiguration smtpConfiguration) {
        this.smtpConfiguration = smtpConfiguration;
        this.senderAccount = new SenderAccount();
        this.to = new String[]{ this.RECIPIENT };
        this.subject = "Java send mail example";
        this.body = "Welcome to JavaMail!";
    }

    public void sendMail() {
        Properties props = getMailProperties();

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(senderAccount.USER_NAME));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for(int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(smtpConfiguration.host, senderAccount.USER_NAME, senderAccount.PASSWORD);
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


    private Properties getMailProperties() {
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtpConfiguration.host);
        props.put("mail.smtp.user", senderAccount.USER_NAME);
        props.put("mail.smtp.password", senderAccount.PASSWORD);
        props.put("mail.smtp.port", smtpConfiguration.smtpPort);
        props.put("mail.smtp.auth", "true");
        return props;
    }
}