
import Data.CampaignMaker;
import IO.ConfigReader;
import IO.MailSender;
import Model.Campaign;
import Model.Config;
import Model.EmailAddress;

import java.util.Scanner;

public class RES_SMTP {

    public static void main(String ...args) {

        System.out.println("Indiquez le fichier de configuration");
        Scanner reader              = new Scanner(System.in);
        String filename             = reader.nextLine();
        reader.close();

        Config config               = new ConfigReader(filename).getConfig();
        CampaignMaker maker         = new CampaignMaker(config);
        MailSender sender           = new MailSender(config);

        for(Campaign campaign : maker.getCampaigns())
            for (EmailAddress to : campaign.getTo())
                sender.sendMail(campaign.getFrom(), to, campaign.getSubject(), campaign.getContent());
    }
}