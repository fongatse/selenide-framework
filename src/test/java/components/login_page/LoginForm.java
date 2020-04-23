package components.login_page;

/**
 * List of locators and elements in the Login Form
 */
public class LoginForm {

    private String EMAIL_FIELD_LOCATOR = "#Email";
    private String PASSWORD_FIELD_LOCATOR = "#Password";
    private String LOGIN_BUTTON_LOCATOR = "#content-container > div > div > div > div > div.panel.panel-default > div > form.form-wrap > button";
    private String INVALID_LOGIN_MESSAGE_LOCATOR = "#content-container > div > div > div > div > div.panel.panel-default > div > div > ul";

    public String getEMAIL_FIELD_LOCATOR() {
        return EMAIL_FIELD_LOCATOR;
    }

    public String getPASSWORD_FIELD_LOCATOR() {
        return PASSWORD_FIELD_LOCATOR;
    }

    public String getLOGIN_BUTTON_LOCATOR() {
        return LOGIN_BUTTON_LOCATOR;
    }

    public String getINVALID_LOGIN_MESSAGE_LOCATOR() {
        return INVALID_LOGIN_MESSAGE_LOCATOR;
    }
}
