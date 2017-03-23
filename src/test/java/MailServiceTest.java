import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MailServiceTest {
    @Test
    public void sendMailViaGoogleSMTP(){
        GreenMail greenMail = new GreenMail(new ServerSetup(3025, null, "smtp"));
        greenMail.start();

        SenderAccount senderAccount = new SenderAccount();
        SMTPConfiguration smtpConfiguration = new SMTPConfiguration("localhost","3025");
        MailContent mailContent = new MailContent(new String[]{"karmolcr@gmail.com"},"Java send mail example","Welcome to JavaMail!");
        MailService mailService = new MailService(senderAccount , smtpConfiguration, mailContent);
        mailService.sendMail();

        assertEquals("Welcome to JavaMail!", GreenMailUtil.getBody(greenMail.getReceivedMessages()[0]));

        greenMail.stop();
    }
}
