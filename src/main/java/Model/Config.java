package Model;

import java.util.ArrayList;

public class Config {

    private final static String BASE_EHLO       = "smtp_res.com";
    private final static EmailAddress BASE_FROM = new EmailAddress("res@res.com");

    private ArrayList<EmailAddress> victims     = new ArrayList<EmailAddress>();
    private ArrayList<EmailAddress> senders     = new ArrayList<EmailAddress>();
    private ArrayList<EmailContent> contents    = new ArrayList<EmailContent>();

    private Integer groups;
    private String ehlo;
    private EmailAddress baseFrom;
    private boolean mock;

    public Config() {

        ehlo        = BASE_EHLO;
        baseFrom    = BASE_FROM;
        groups      = 1;
        mock        = true;
    }

    public EmailAddress getBaseFrom() {
        return baseFrom;
    }

    public void setBaseFrom(EmailAddress baseFrom) {
        this.baseFrom = baseFrom;
    }

    public String getEhlo() {
        return ehlo;
    }

    public void setEhlo(String ehlo) {
        this.ehlo = ehlo;
    }

    public Integer getGroups() {
        return groups;
    }

    public void setGroups(Integer groups) {
        this.groups = groups;
    }

    public ArrayList<EmailContent> getContents() {
        return contents;
    }

    public void setContents(ArrayList<EmailContent> contents) {
        this.contents = contents;
    }

    public ArrayList<EmailAddress> getSenders() {
        return senders;
    }

    public void setSenders(ArrayList<EmailAddress> senders) {
        this.senders = senders;
    }

    public ArrayList<EmailAddress> getVictims() {
        return victims;
    }

    public void setVictims(ArrayList<EmailAddress> victims) {
        this.victims = victims;
    }

    public boolean isMock() {
        return mock;
    }

    public void setMock(boolean mock) {
        this.mock = mock;
    }
}
