package IO;

import Data.JsonObjectMapper;
import Model.Config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class ConfigReader {

    private Logger logger = Logger.getLogger(ConfigReader.class.getName());

    private Config config;

    public ConfigReader(String filename) {

        try {

            StringBuilder builder   = new StringBuilder();
            BufferedReader reader   = new BufferedReader(new FileReader(filename));
            String line;

            while((line = reader.readLine()) != null)
                builder.append(line);

            config = JsonObjectMapper.parseJson(builder.toString(), Config.class);

        } catch (IOException e) {

            logger.severe(e.getMessage());
        }
    }

    public Config getConfig() {

        return config;
    }
}
