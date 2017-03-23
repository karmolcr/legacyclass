import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class MailService {

    private final SenderAccount senderAccount;
    private final SMTPConfiguration smtpConfiguration;
    private final MailContent mailContent;

    public MailService(SenderAccount senderAccount, SMTPConfiguration smtpConfiguration, MailContent mailContent) {
        this.smtpConfiguration = smtpConfiguration;
        this.senderAccount = new SenderAccount();
        this.mailContent = mailContent;
    }

    public void sendMail() {

        try {
            Session session = getSession();

            MimeMessage message = getMimeMessage(session);

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

    private Session getSession() {
        Properties props = getMailProperties();
        return Session.getDefaultInstance(props);
    }

    private MimeMessage getMimeMessage(Session session) throws MessagingException {
        InternetAddress[] toAddress = new InternetAddress[mailContent.to.length];
        // To get the array of addresses
        for(int i = 0; i < mailContent.to.length; i++ ) {
            toAddress[i] = new InternetAddress(mailContent.to[i]);
        }

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(senderAccount.USER_NAME));
        for( int i = 0; i < toAddress.length; i++) {
            message.addRecipient(Message.RecipientType.TO, toAddress[i]);
        }

        message.setSubject(mailContent.subject);
        message.setText(mailContent.body);
        return message;
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