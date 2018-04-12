package IO;

import DNS.Helper;
import data.EmailAddress;

import java.io.IOException;

public class MailSender {


    private Helper helper = new Helper();

    private String ehlo;

    private EmailAddress baseFrom;

    public MailSender(String ehlo, EmailAddress baseFrom) {

        this.ehlo       = ehlo;
        this.baseFrom   = baseFrom;
    }

    public void connect(String server) {

        String MXRecord     = helper.getMXRecord(server);
        String SMTPServer   = helper.cleanMXRecord(MXRecord);
        SMTPClient client   = new SMTPClient(SMTPServer);
    }
}
