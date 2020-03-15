package resources.tests;

import com.codeborne.selenide.Configuration;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import resources.data.User;
import resources.pages.HomePage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

/**
 * Class containing Login test scenarios
 */
public class LoginSuiteTest {
    /**
     * Declaring instances which will be used in the tests.
     */
    HomePage homePage;
    User validUser;
    User invalidUser;

    /**
     * Inicialization of the browser and all instances which are necessary for this tests.
     */
    @Before
    public void init() throws IOException, ParseException {
        Configuration.browserSize = "1366x768";
        System.setProperty("webdriver.chrome.driver", "/Users/fongatse/IdeaProjects/selenide-framework/chromedriver/chromedriver");
        System.setProperty("selenide.browser", "Chrome");
        open("https://www.wuxiaworld.com/");
        homePage = new HomePage();
        validUser = new User("src/test/java/resources/data/user.json");
        invalidUser = new User("src/test/java/resources/data/invalid_user.json");
    }

    /**
     * Happy path test
     */
    @Test
    public void loginTest() {
        homePage.login()
                .loginWithAccount(validUser)
                .clickLogin()
                .isLoggedIn()
                .logOut();
    }

    /**
     * Negative path test
     */
    @Test
    public void loginNEGTest() {
        homePage.login()
                .loginWithAccount(invalidUser)
                .verifyInvalidLogin();


    }
}
