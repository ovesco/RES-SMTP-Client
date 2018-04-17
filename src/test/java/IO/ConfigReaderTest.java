package IO;

import Data.ConfigReader;
import Model.Config;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConfigReaderTest {

    static final String path = "/home/hochet/HEIG/RES/RES_SMTP/src/test/java/IO/example.json";

    @Test
    public void configReaderShouldParseJson() {

        ConfigReader reader = new ConfigReader(path);
        Config config       = reader.getConfig();

        assertTrue(config.isMock());
        assertTrue(config.getEhlo().equals("swag.com"));
        assertTrue(config.getGroups().equals(3));

        assertEquals(config.getVictims().size(), 10);
        assertEquals(config.getContents().size(), 3);
    }
}
