package resources.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import resources.pages.components.Navbar;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends PageObject {

private Navbar navbar = new Navbar();

private SelenideElement bookmarksTab = $(navbar.getBOOKMARKS_LOCATOR());
private SelenideElement novelsTab = $(navbar.getNOVELS_LOCATOR());
private  SelenideElement resourcesTab = $(navbar.getRESOURCES_LOCATOR());


public void bookmarks(){
    bookmarksTab.should(Condition.exist);
    bookmarksTab.shouldBe(Condition.visible);
    bookmarksTab.click();
}
}
