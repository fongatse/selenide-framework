package resources.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import resources.pages.BookmarksPage;
import resources.pages.HomePage;
import resources.pages.LoginPage;
import resources.pages.PageObject;

import static com.codeborne.selenide.Selenide.$;

/**
 * Clas containg all the Navigation bar element locators and methods
 */
public class Navbar extends PageObject {
    HamburgerMenu hamburger = new HamburgerMenu();

    private String BOOKMARKS_LOCATOR = "#navbar > ul:nth-child(1) > li:nth-child(1) > a";
    private String NOVELS_LOCATOR = "#navbar > ul:nth-child(1) > li:nth-child(2) > a";
    private String RESOURCES_LOCATOR = "#navbar > ul:nth-child(1) > li:nth-child(3) > a";
    private String LOGIN_LOCATOR = "#navbar > ul.nav.navbar-nav.nav-public.navbar-right > li:nth-child(2) > a";
    private String HAMBURGER_MENU_LOCATOR = "#navbar > ul.nav.navbar-nav.nav-private.navbar-right > li:nth-child(5) > a > svg > rect";

    private SelenideElement bookmarksTab = $(getBOOKMARKS_LOCATOR());
    private SelenideElement novelsTab = $(getNOVELS_LOCATOR());
    private  SelenideElement resourcesTab = $(getRESOURCES_LOCATOR());
    private SelenideElement loginTab = $(getLOGIN_LOCATOR());
    private SelenideElement hamburgerMenu = $(getHAMBURGER_MENU_LOCATOR());
    /*Hamburger menu elements*/
    private SelenideElement logout = $(getLOGOUT());

    public String getBOOKMARKS_LOCATOR() {

        return BOOKMARKS_LOCATOR;
    }

    public String getNOVELS_LOCATOR() {

        return NOVELS_LOCATOR;
    }

    public String getRESOURCES_LOCATOR() {

        return RESOURCES_LOCATOR;
    }

    public String getLOGIN_LOCATOR() {
        return LOGIN_LOCATOR;
    }

    public String getHAMBURGER_MENU_LOCATOR() {
        return HAMBURGER_MENU_LOCATOR;
    }

    public String getLOGOUT() {
        return hamburger.getLOGOUT_LOCATOR();
    }



    public BookmarksPage bookmarks(){
        bookmarksTab.should(Condition.exist);
        bookmarksTab.shouldBe(Condition.visible);
        bookmarksTab.click();
        return Selenide.page(BookmarksPage.class);
    }

    public void novels(){
        novelsTab.should(Condition.exist);
        novelsTab.shouldBe(Condition.visible);
        novelsTab.click();
    }

    public void resources(){
        resourcesTab.should(Condition.exist);
        resourcesTab.shouldBe(Condition.visible);
        resourcesTab.click();
    }

    public LoginPage login(){
        loginTab.should(Condition.exist);
        loginTab.shouldBe(Condition.visible);
        loginTab.click();
        return Selenide.page(LoginPage.class);
    }

    public Navbar isLoggedIn(){
        hamburgerMenu.should(Condition.exist);
        hamburgerMenu.shouldBe(Condition.visible);
        return this;
    }

    public HomePage logOut(){
        isLoggedIn();
        hamburgerMenu.click();
        logout.shouldBe(Condition.visible);
        logout.click();
        hamburgerMenu.shouldBe(Condition.not(Condition.visible));
        return Selenide.page(HomePage.class);

    }
}
