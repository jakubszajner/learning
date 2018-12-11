package szajner.learning.test.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import szajner.learning.util.AppProperties;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PropertiesTest {

    private AppProperties properties;

    @BeforeAll
    void loadFile() {
        properties = new AppProperties();
    }

    @Test
    @DisplayName("Read property from file")
    void readProperty() {
        String value = properties.get("test");

        assertEquals("openqa", value);
    }

}
