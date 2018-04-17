package Data;

import Model.Campaign;
import Model.Config;
import Model.EmailAddress;
import Model.EmailContent;

import java.util.ArrayList;

public class CampaignMaker {

    private Config config;

    private ArrayList<Campaign> campaigns = new ArrayList<Campaign>();

    public CampaignMaker(Config config) {

        this.config = config;

        for(int i = 0; i < config.getGroups(); i++)
            createCampaign();
    }

    public ArrayList<Campaign> getCampaigns() {

        return campaigns;
    }

    private void createCampaign() {

        int amountOfVictims             = random(2, config.getVictims().size());
        if(amountOfVictims == config.getVictims().size())
            amountOfVictims--;

        ArrayList<EmailAddress> victims = getVictims(amountOfVictims);
        EmailAddress sender             = getRandomSender(victims);
        EmailContent content            = getRandomEmailContent();

        Campaign campaign = new Campaign(sender, victims, content.getSubject(), content.getContent());
        campaigns.add(campaign);
        System.out.println("Created new " + campaign);
        System.out.println("-------------------");


    }

    private ArrayList<EmailAddress> getVictims(int amount) {

        if(amount == config.getVictims().size())
            return config.getVictims();

        ArrayList<EmailAddress> victims = new ArrayList<EmailAddress>();

        while(victims.size() != amount) {

            EmailAddress address = config.getVictims().get(random(0, config.getVictims().size() - 1));
            if(!victims.contains(address))
                victims.add(address);
        }

        return victims;
    }

    private EmailContent getRandomEmailContent() {

        return config.getContents().get(random(0, config.getContents().size()-1));
    }

    private EmailAddress getRandomSender(ArrayList<EmailAddress> victims) {

        ArrayList<EmailAddress> possibleSenders = new ArrayList<EmailAddress>();

        for(EmailAddress address : config.getVictims())
            if(!victims.contains(address))
                possibleSenders.add(address);

        return possibleSenders.get(random(0, possibleSenders.size()-1));
    }

    private int random(int min, int max) {

        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
