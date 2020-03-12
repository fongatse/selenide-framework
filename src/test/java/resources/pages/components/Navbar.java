package resources.pages.components;

public class Navbar {
    private String BOOKMARKS_LOCATOR = "#navbar > ul:nth-child(1) > li:nth-child(1) > a";
    private String NOVELS_LOCATOR = "#navbar > ul:nth-child(1) > li:nth-child(2) > a";
    private String RESOURCES_LOCATOR = "#navbar > ul:nth-child(1) > li:nth-child(3) > a";


    public String getBOOKMARKS_LOCATOR() {
        return BOOKMARKS_LOCATOR;
    }

    public String getNOVELS_LOCATOR() {
        return NOVELS_LOCATOR;
    }

    public String getRESOURCES_LOCATOR() {
        return RESOURCES_LOCATOR;
    }
}
