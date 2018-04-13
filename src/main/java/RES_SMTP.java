
import IO.ConfigReader;
import Model.Config;
import Model.EmailAddress;
import Model.EmailContent;

import java.util.Scanner;

public class RES_SMTP {

    public static void main(String ...args) {

        System.out.println("Indiquez le fichier de configuration");
        Scanner reader              = new Scanner(System.in);
        String filename             = reader.nextLine();
        reader.close();

        Config config               = new ConfigReader(filename).getConfig();

        for(EmailAddress address : config.getVictims())
            System.out.println("[victim] " + address.getEmail());

        for(EmailAddress address : config.getSenders())
            System.out.println("[sender] " + address.getEmail());

        for(EmailContent content : config.getContents())
            System.out.println("[content] subject:" + content.getSubject() + ", content: " + content.getContent());

        System.out.println("EHLO: " + config.getEhlo());
        System.out.println("Groups: " + config.getGroups());
        System.out.println("BaseFrom: " + config.getBaseFrom());
    }
}