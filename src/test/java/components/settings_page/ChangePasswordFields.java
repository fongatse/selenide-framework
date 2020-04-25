package components.settings_page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

import java.util.Random;

import components.User;

/**
 * Contains elements and methods for the for ChangePassword field
 */
public class ChangePasswordFields {
    private String newPassword;

    final private String OLD_PASSWORD_LOCATOR = "#OldPassword";
    final private String NEW_PASSWORD_LOCATOR = "#NewPassword";
    final private String CONFIRM_PASSWORD_LOCATOR = "#ConfirmPassword";
    final private String CHANGE_PASSWORD_BTN_LOCATOR = "//button[contains(text(), \"Change Password\")]";
    final private String SUCCESS_MSG_LOCATOR = "//div[@class=\"text-success\"]";

    private SelenideElement oldPasswordElement = $(OLD_PASSWORD_LOCATOR);
    private SelenideElement newPasswordElement = $(NEW_PASSWORD_LOCATOR);
    private SelenideElement confirmPasswordElement = $(CONFIRM_PASSWORD_LOCATOR);
    private SelenideElement changePasswordBtn = $(By.xpath(CHANGE_PASSWORD_BTN_LOCATOR));
    private SelenideElement successMessage = $(By.xpath(SUCCESS_MSG_LOCATOR));

    Random random = new Random();

    public String getNewPassword() {
        return this.newPassword;
    }

    private void setNewPassword(String s) {
        this.newPassword = s;
    }

    public void setNewRandomPassword(User user) {
        String newPwd = "Test1" + String.valueOf(random.nextInt(100));
        setNewPassword(newPwd);
        oldPasswordElement.clear();
        oldPasswordElement.sendKeys(user.getPassword());
        newPasswordElement.clear();
        newPasswordElement.sendKeys(this.newPassword);
        confirmPasswordElement.clear();
        confirmPasswordElement.sendKeys(this.newPassword);
        changePasswordBtn.click();
        successMessage.shouldBe(Condition.visible);
        user.softChangePassword(this.newPassword);
    }

    public void revertToOldPassword(User user){
        oldPasswordElement.clear();
        oldPasswordElement.sendKeys(this.newPassword);
        newPasswordElement.clear();
        newPasswordElement.sendKeys(user.getOldPassword());
        confirmPasswordElement.clear();
        confirmPasswordElement.sendKeys(user.getOldPassword());
        changePasswordBtn.click();
        successMessage.shouldBe(Condition.visible);
        user.softChangePassword(user.getOldPassword());      
    }

}