package resources.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Class with elements and methods for Login page.
 */
public class LoginPage extends PageObject {
    /**
     * List of locators and elements on the page.
     */
    private String EMAIL_FIELD_LOCATOR = "#email";
    private String PASSWORD_FIELD_LOCATOR = "#password";
    private String LOGIN_BUTTON_LOCATOR = ".button--primary.w--100p";

    private SelenideElement emailField = $(EMAIL_FIELD_LOCATOR),
            passwordField = $(PASSWORD_FIELD_LOCATOR),
            loginButton = $(LOGIN_BUTTON_LOCATOR);

    /**
     * Logging in with email and password.
     * @param email is user email.
     * @param password is user password.
     * @return DashboardPage
     */
    public DashboardPage loginWithAccount(String email, String password) {
        return setEmail(email).setPassword(password).clickLogin();
    }

    /**
     * Set user email to the field.
     * @param email is user email.
     * @return LoginPage
     */
    public LoginPage setEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    /**
     * Set user password
     * @param password is user password.
     * @return LoginPage
     */
    public LoginPage setPassword (String password) {
        passwordField.setValue(password);
        return this;
    }

    /**
     * Click Login button action.
     * @return DashboardPage
     */
    public DashboardPage clickLogin () {
        loginButton.click();
        return Selenide.page(DashboardPage.class);
    }
}
