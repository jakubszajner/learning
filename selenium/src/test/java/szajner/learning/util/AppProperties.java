package szajner.learning.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import szajner.learning.test.auth.AuthTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {

    private static final String FILE_NAME_PATH = "src/test/resources/application.properties";
    private static Logger logger = LoggerFactory.getLogger(AuthTest.class);
    private Properties properties;

    public AppProperties() {
        properties = new Properties();

        try (InputStream in = new FileInputStream(FILE_NAME_PATH)) {
            properties.load(in);
        } catch (IOException e) {
            logger.error("File does not exist", e);
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

}
