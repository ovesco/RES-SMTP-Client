package IO;

import Model.EmailAddress;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

public class SMTPClient {

    public final static int SMTP_PORT       = 25;
    public final static String EHLO         = "EHLO ";
    public final static String MAIL_FROM    = "MAIL FROM: ";
    public final static String RCPT_TO      = "RCPT TO: ";
    public final static String DATA         = "DATA";

    private Socket connection;

    private BufferedReader in;

    private PrintWriter out;

    private static final Logger logger = Logger.getLogger(SMTPClient.class.getName());

    public SMTPClient(String host) {

        this(host, SMTP_PORT);
    }

    public SMTPClient(String host, int port) {

        try {

            connection  = new Socket(host, port);
            in          = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            out         = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()), true);

            logger.info("Connected to: " + in.readLine());

        } catch (IOException e) {

            logger.severe(e.getMessage());
        }
    }

    public boolean SMTPSendMail(EmailAddress from, EmailAddress to, String subject, String message) {

        return this.SMTPSendMail(from, to, subject, message, from.getServer(), from);
    }

    public boolean SMTPSendMail(EmailAddress from, EmailAddress to, String subject, String message, String ehlo, EmailAddress baseFrom) {

        try {

            //Shake hand
            logger.info("send ehlo for: " + EHLO + ehlo);
            write(EHLO + ehlo);
            StringBuilder EHLObuilder = new StringBuilder();
            int c;
            while((c = in.read()) != 13)
                EHLObuilder.append((char)c);
            logger.info("[SERVER] " + EHLObuilder.toString());

            //Send from
            logger.info("sending from");
            write(MAIL_FROM + baseFrom.getEmail());
            read();

            //Send to
            logger.info("sending to");
            write(RCPT_TO + to.getEmail());
            read();

            //Notify server that we send message
            logger.info("starting sending Model");
            write(DATA);
            read(); //He says ok yo, go ahead

            //Send headers
            logger.info("sending headers");
            write("From: " + from.getEmail());
            write("To: " + to.getEmail());
            write("Subject: " + subject);
            write("");

            //Send message
            logger.info("sending message");
            write(message);
            write("."); //End of message

            //Server says i got this
            read();

            write("QUIT");
            connection.close();
            return true;

        } catch (Exception e) {

            logger.severe(e.getMessage());
            return false;
        }
    }

    private void write(String s) throws UnsupportedEncodingException {

        out.println(s + (char)13);
        out.flush();
    }

    private void read() throws Exception {

        String response = in.readLine();

        /*
        if(!response.startsWith("2"))
            throw new Exception("Server response fail: " + response);
            */

        logger.info("[SERVER] " + response);
    }
}
