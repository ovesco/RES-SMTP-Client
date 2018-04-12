import IO.SMTPClient;
import data.EmailAddress;

public class RES_SMTP {

    public static void main(String ...args) {
        /*
        Helper helper = new Helper();
        String record = helper.getMXRecord("localhost");
        System.out.println(record);
        System.out.println(helper.cleanMXRecord(record));
        */


        SMTPClient client = new SMTPClient("localhost", 8183);
        client.SMTPSendMail(new EmailAddress("guillaume.hochet@gmail.com"), new EmailAddress("yolo@swag.com"), "Eh salut!", "Que de swag");
        //*/
        /*
                EmailAddress address = new EmailAddress("guillaume.hochet@gmail.com");
        System.out.println(address);
        System.out.println(address.getServer());

         */
    }
}
