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
        SMTPConfiguration smtpConfiguration = new SMTPConfiguration();
        MailService mailService = new MailService("localhost","3025",senderAccount , smtpConfiguration);
        mailService.sendMail();

        assertEquals("Welcome to JavaMail!", GreenMailUtil.getBody(greenMail.getReceivedMessages()[0]));

        greenMail.stop();
    }
}
