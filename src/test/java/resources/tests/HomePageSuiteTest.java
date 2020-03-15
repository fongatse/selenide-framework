package resources.tests;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import resources.pages.HomePage;

import static com.codeborne.selenide.Selenide.open;

/**
 * Class containing General navigation scenarios
 */
public class HomePageSuiteTest {
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
       System.setProperty("webdriver.chrome.driver", "/Users/fongatse/IdeaProjects/selenide-framework/chromedriver/chromedriver");
       System.setProperty("selenide.browser", "Chrome");
        open("https://www.wuxiaworld.com/");
        homePage = new HomePage();
    }

    /**
     * Happy path tests
     */
    @Test
    public void navigationBarTest(){
    homePage.bookmarks();
    homePage.novels();
    homePage.resources();
    homePage.login();
    }
}
