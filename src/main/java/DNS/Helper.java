package DNS;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.logging.Logger;

/**
 * Inspired from https://satreth.blogspot.ch/2015/01/java-dns-query.html
 */
public class Helper {

    Logger logger = Logger.getLogger(Helper.class.getName());

    /**
     * Returns the
     * @param server
     * @return
     */
    public String getMXRecord(String server) {

        try {

            DirContext ctx          = new InitialDirContext();
            Attributes attributes   = ctx.getAttributes("dns:/" + server, new String[]{"MX"});

            return attributes.get("MX").get().toString();

        } catch (NamingException e) {

            logger.severe(e.getMessage());
            return null;
        }
    }

    public String cleanMXRecord(String line) {

        StringBuilder builder   = new StringBuilder();

        for(int i = line.length()-2; i > 0 && line.charAt(i) != ' '; i--)
            builder.append(line.charAt(i));

        return builder.reverse().toString();
    }
}
