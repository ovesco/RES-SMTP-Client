package IO;

import DNS.Helper;
import Model.Config;
import Model.EmailAddress;

public class MailSender {


    private Helper helper = new Helper();

    private Config config;

    public MailSender(Config config) {

        this.config = config;
    }

    public void connect(String server) {

        String MXRecord     = helper.getMXRecord(server);
        String SMTPServer   = helper.cleanMXRecord(MXRecord);
        SMTPClient client   = new SMTPClient(SMTPServer);
    }
}
