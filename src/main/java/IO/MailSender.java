package IO;

import DNS.Helper;
import Model.Config;
import Model.EmailAddress;

import java.util.logging.Logger;

public class MailSender {

    private static final String LOCALHOST   = "localhost";
    private static final int MOCK_PORT      = 8675;

    private Helper helper   = new Helper();
    private Logger logger   = Logger.getLogger(MailSender.class.getName());

    private Config config;

    public MailSender(Config config) {

        this.config = config;
    }

    public SMTPClient connect(String server) {

        String MXRecord     = helper.getMXRecord(server);
        String SMTPServer   = helper.cleanMXRecord(MXRecord);

        return new SMTPClient(SMTPServer);
    }

    public void sendMail(EmailAddress from, EmailAddress to, String subject, String content) {

        content             = content.replace("%s", to.getAdressPrefix());
        SMTPClient client   = config.isMock() ? new SMTPClient(LOCALHOST, MOCK_PORT) : connect(to.getServer());

        if(!client.SMTPSendMail(from, to, subject, content, config.getEhlo(), config.getBaseFrom()))
            logger.severe("Couldn't send mail from " + from.getEmail() + " to " + to.getEmail() +
            " with subject " + subject);
    }
}
