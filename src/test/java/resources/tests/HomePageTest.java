package resources.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Before;
import org.junit.Test;
import resources.pages.DashboardPage;
import resources.pages.HomePage;
import resources.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Class with the happy path tests.
 */
public class HomePageTest {
    /**
     * Declaring instances which will be used in the tests.
     */
    HomePage homePage;

    /**
     * Inicialization of browser and all instances which are necessary for this tests.
     */
    @Before
    public void init() {
        Configuration.browserSize = "1366x768";
       System.setProperty("webdriver.chrome.driver", "/Users/fongatse/Desktop/selenide-framework/chromedriver/chromedriver");
       System.setProperty("selenide.browser", "Chrome");
        open("https://www.wuxiaworld.com/");
        homePage = new HomePage();
    }

    /**
     * Happy path tests
     */
    @Test
    public void happyPathTest(){
    homePage.bookmarks();
    sleep(15000);
    }
}
