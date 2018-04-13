
import Data.CampaignMaker;
import IO.ConfigReader;
import IO.MailSender;
import Model.Config;

import java.util.Scanner;

public class RES_SMTP {

    public static void main(String ...args) {

        System.out.println("Indiquez le fichier de configuration");
        Scanner reader              = new Scanner(System.in);
        String filename             = reader.nextLine();
        reader.close();

        Config config       = new ConfigReader(filename).getConfig();
        CampaignMaker maker = new CampaignMaker(config);
        MailSender sender   = new MailSender(config.getEhlo(), config.getBaseFrom());
    }
}