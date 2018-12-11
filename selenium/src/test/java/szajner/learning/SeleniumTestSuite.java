package szajner.learning;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import szajner.learning.test.auth.AuthTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({AuthTest.class})
public class SeleniumTestSuite {

}
