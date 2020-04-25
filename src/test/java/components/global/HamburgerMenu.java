package components.global;

/**
 * class containing the hamburger menu item locators
 */
public class HamburgerMenu {
    private String LOGOUT_LOCATOR = "#logout-btn";
    private String SETTINGS_LOCATOR = "//a[contains(text(),\"My Settings\")]";

    public String getLOGOUT_LOCATOR() {
        return LOGOUT_LOCATOR;
    }

    public String getSETTINGS_LOCATOR() {
        return SETTINGS_LOCATOR;
    }
}
