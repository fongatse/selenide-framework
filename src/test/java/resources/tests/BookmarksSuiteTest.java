package resources.tests;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import resources.pages.HomePage;

import static com.codeborne.selenide.Selenide.open;

/**
 * Class Bookmarks related scenarios
 */
public class BookmarksSuiteTest {
    /**
     * Declaring instances which will be used in the tests.
     */
    HomePage homePage;
    String novel;

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
        novel = "Martial God Asura";
    }

    /**
     * Test finds a user specified novel
     */
    @Test
    public void findNovelTest() {
        homePage.searchForNovel(novel)
                .continueCookies()
                .verifyNovel(novel);

    }

    /**
     * Test bookmarking functionality
     */
    @Test
    public  void bookmarkChapterTest(){
        /*
        TO BE SCRIPTED
         */
    }
}
