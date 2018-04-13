package Model;

import java.util.List;
import java.util.logging.Logger;

public class Campaign {

    Logger logger   = Logger.getLogger(Campaign.class.getName());

    private EmailAddress from;
    private List<EmailAddress> to;
    private String subject;
    private String content;

    public Campaign(EmailAddress from, List<EmailAddress> to, String subject, String content) {

        this.from       = from;
        this.to         = to;
        this.subject    = subject;
        this.content    = content;
    }


    public EmailAddress getFrom() {
        return from;
    }

    public List<EmailAddress> getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }
}
