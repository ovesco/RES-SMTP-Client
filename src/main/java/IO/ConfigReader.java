package IO;

import Data.JsonObjectMapper;
import Model.Config;

import java.io.BufferedReader;
import java.io.FileReader;
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

            if(config.getVictims().size() < 2)
                throw new Exception("Not enough victims, requires at least 2");

            if(config.getSenders().size() < 1)
                throw new Exception("Not enough senders, requires at least 1");

            if(config.getContents().size() < 1)
                throw new Exception("No mail contents declared");

        } catch (Exception e) {

            logger.severe(e.getMessage());
        }
    }

    public Config getConfig() {

        return config;
    }
}
