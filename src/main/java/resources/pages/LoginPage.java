package resources.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.json.simple.parser.ParseException;
import resources.data.User;
import resources.components.login_page.LoginForm;
import resources.components.global.Navbar;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;


/**
 * Class with elements and methods for Login page.
 */
public class LoginPage extends Navbar {

    LoginForm loginForm = new LoginForm();

    private SelenideElement emailField = $(loginForm.getEMAIL_FIELD_LOCATOR()),
            passwordField = $(loginForm.getPASSWORD_FIELD_LOCATOR()),
            loginButton = $(loginForm.getLOGIN_BUTTON_LOCATOR()),
    invalidLoginMessage = $(loginForm.getINVALID_LOGIN_MESSAGE_LOCATOR());

    public LoginPage() throws IOException, ParseException {
    }

    /**
     * Logging in with email and password.
     * @return DashboardPage
     */
    public LoginPage loginWithAccount(User user) {
        return setEmail(user).setPassword(user);
    }

    /**
     * Set user email to the field.
     * @return LoginPage
     */
    private LoginPage setEmail(User user) {
        emailField.setValue(user.getEmail());
        return this;
    }

    /**
     * Set user password
     * @return LoginPage
     */
    private LoginPage setPassword (User user) {
        passwordField.setValue(user.getPassword());
        return this;
    }

    /**
     * Click Login button action.
     * @return DashboardPage
     */
    public HomePage clickLogin () {
        loginButton.click();
        return Selenide.page(HomePage.class);
    }

    /**
     * Click Login and verify error message
     * @return LoginPage
     */
    public LoginPage verifyInvalidLogin(){
        loginButton.click();
        invalidLoginMessage.should(Condition.exist);
        invalidLoginMessage.shouldBe(Condition.visible);
        return this;
    }
}
