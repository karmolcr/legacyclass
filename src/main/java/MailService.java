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
        Properties props = getMailProperties();

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(senderAccount.USER_NAME));
            InternetAddress[] toAddress = new InternetAddress[mailContent.to.length];

            // To get the array of addresses
            for(int i = 0; i < mailContent.to.length; i++ ) {
                toAddress[i] = new InternetAddress(mailContent.to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(mailContent.subject);
            message.setText(mailContent.body);
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