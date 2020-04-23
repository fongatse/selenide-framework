package tests;

import com.codeborne.selenide.Configuration;
import components.User;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import pages.ChapterPage;
import pages.HomePage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

/**
 * Class Bookmarks related scenarios
 */
public class BookmarksSuiteTest {
    /**
     * Declaring instances which will be used in the tests.
     */
    HomePage homePage;
    ChapterPage chapterPage;
    User user;
    String novel;
    String chapter;

    /**
     * Inicialization of browser and all instances which are necessary for this tests.
     */
    @Before
    public void init() throws IOException, ParseException {
        Configuration.browserSize = "1366x768";
        System.setProperty("webdriver.chrome.driver", "/Users/fongatse/IdeaProjects/selenide-framework/chromedriver/chromedriver");
        System.setProperty("selenide.browser", "Chrome");
        open("https://www.wuxiaworld.com/");
        user = new User("src/test/resources/data/user.json");
        homePage = new HomePage();
        chapterPage = new ChapterPage();
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
    public void bookmarkChapterTest() {
        homePage.login()
                .loginWithAccount(user)
                .clickLogin()
                .searchForNovel(novel)
                .randomChapter();
        this.chapter = chapterPage.getChapterName();
        chapterPage.bookmarkChapter()
                .bookmarks()
                .assertManualBookmarkExists(chapter)
                .deleteBookmark(chapter)
                .logOut();
    }
}
