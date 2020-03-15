package resources.components.global;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import resources.pages.*;

import static com.codeborne.selenide.Selenide.$;

/**
 * Clas containg all the Navigation bar and Global element locators and methods
 */
public class Navbar extends PageObject {
    HamburgerMenu hamburger = new HamburgerMenu();

    private String BOOKMARKS_LOCATOR = "#navbar > ul:nth-child(1) > li:nth-child(1) > a";
    private String NOVELS_LOCATOR = "#navbar > ul:nth-child(1) > li:nth-child(2) > a";
    private String RESOURCES_LOCATOR = "#navbar > ul:nth-child(1) > li:nth-child(3) > a";
    private String LOGIN_LOCATOR = "#navbar > ul.nav.navbar-nav.nav-public.navbar-right > li:nth-child(2) > a";
    private String HAMBURGER_MENU_LOCATOR = "#navbar > ul.nav.navbar-nav.nav-private.navbar-right > li:nth-child(5) > a > svg > rect";
    private String SEARCH_BAR_LOCATOR = "#searchbox > div > div > input";
    private String SEARCH_ITEM_LOCATOR = "#searchbox > div > div > div > div";
    private String CONTINUE_WITH_COOKIES_LOCATOR = "#pgdg-continue";


    private SelenideElement bookmarksTab = $(BOOKMARKS_LOCATOR);
    private SelenideElement novelsTab = $(NOVELS_LOCATOR);
    private SelenideElement resourcesTab = $(RESOURCES_LOCATOR);
    private SelenideElement loginTab = $(LOGIN_LOCATOR);
    private SelenideElement hamburgerMenu = $(HAMBURGER_MENU_LOCATOR);
    private SelenideElement searchBar = $(SEARCH_BAR_LOCATOR);
    private SelenideElement continueWithCookiesBtn = $(CONTINUE_WITH_COOKIES_LOCATOR);
    /*Hamburger menu elements*/
    private SelenideElement logout = $(getLOGOUT());
    /*Search tab elements*/
    private SelenideElement searchItem = $(SEARCH_ITEM_LOCATOR);


    public String getLOGOUT() {
        return hamburger.getLOGOUT_LOCATOR();
    }

    /**
     * search and find specified novel, clicks on first entry only
     *
     * @param novel novel searched for
     * @return
     */
    public NovelPage searchForNovel(String novel) {
        searchBar.clear();
        searchBar.setValue(novel);
        searchItem.shouldBe(Condition.visible);
        searchItem.click();
        return Selenide.page(NovelPage.class);
    }

    public Navbar continueWithCookies() {
        if (continueWithCookiesBtn.isDisplayed()) {
            continueWithCookiesBtn.click();
        }
        return this;
    }

    public BookmarksPage bookmarks() {
        bookmarksTab.should(Condition.exist);
        bookmarksTab.shouldBe(Condition.visible);
        bookmarksTab.click();
        return Selenide.page(BookmarksPage.class);
    }

    public void novels() {
        novelsTab.should(Condition.exist);
        novelsTab.shouldBe(Condition.visible);
        novelsTab.click();
    }

    public void resources() {
        resourcesTab.should(Condition.exist);
        resourcesTab.shouldBe(Condition.visible);
        resourcesTab.click();
    }

    public LoginPage login() {
        loginTab.should(Condition.exist);
        loginTab.shouldBe(Condition.visible);
        loginTab.click();
        return Selenide.page(LoginPage.class);
    }

    public Navbar isLoggedIn() {
        hamburgerMenu.should(Condition.exist);
        hamburgerMenu.shouldBe(Condition.visible);
        return this;
    }

    public HomePage logOut() {
        isLoggedIn();
        hamburgerMenu.click();
        logout.shouldBe(Condition.visible);
        logout.click();
        hamburgerMenu.shouldBe(Condition.not(Condition.visible));
        return Selenide.page(HomePage.class);

    }
}
