import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

class SMTP {
    private final static int SMTP_PORT = 25;

    InetAddress mailHost;

    InetAddress localhost;

    BufferedReader in;

    PrintWriter out;

    public SMTP(String host) throws UnknownHostException {

        mailHost = InetAddress.getByName(host);
        localhost = InetAddress.getLocalHost();
        System.out.println("mailhost = " + mailHost);
        System.out.println("localhost= " + localhost);
        System.out.println("SMTP constructor done\n");
    }

    public boolean send(String from, String to)
            throws IOException {
        Socket smtpPipe;
        InputStream inn;
        OutputStream outt;
        BufferedReader msg;
        smtpPipe = new Socket(mailHost, SMTP_PORT);
        if (smtpPipe == null) {
            return false;
        }
        inn = smtpPipe.getInputStream();
        outt = smtpPipe.getOutputStream();
        in = new BufferedReader(new InputStreamReader(inn));
        out = new PrintWriter(new OutputStreamWriter(outt), true);
        if (inn == null || outt == null) {
            System.out.println("Failed to open streams to socket.");
            return false;
        }
        String initialID = in.readLine();
        System.out.println(initialID);
        System.out.println("HELO " + localhost.getHostName());
        out.println("HELO " + localhost.getHostName());
        String welcome = in.readLine();
        System.out.println(welcome);
        System.out.println("MAIL From:<" + from + ">");
        out.println("MAIL From:<" + from + ">");
        String senderOK = in.readLine();
        System.out.println(senderOK);
        System.out.println("RCPT TO:<" + to + ">");
        out.println("RCPT TO:<" + to + ">");
        String recipientOK = in.readLine();
        System.out.println(recipientOK);
        System.out.println("DATA");
        out.println("DATA");
        String line;
        out.println("YOLOYOLO");
        out.println("YO");
        System.out.println(".");
        out.println(".");
        String acceptedOK = in.readLine();
        System.out.println(acceptedOK);
        System.out.println("QUIT");
        out.println("QUIT");
        return true;
    }
}