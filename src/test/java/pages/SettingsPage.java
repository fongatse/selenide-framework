package pages;

import components.User;
import components.global.Navbar;
import components.settings_page.ChangePasswordFields;

public class SettingsPage extends Navbar {
private ChangePasswordFields changePasswordFields;

public SettingsPage (User user){
    changePasswordFields = new ChangePasswordFields();
}


/** 
 * changes user's login password to a randomly generated password
 * @param user
 * @return SettingsPage
 */
public SettingsPage changeToRandomPassword(User user){
    changePasswordFields.setNewRandomPassword(user);
    return this;
}


/** 
 * reverts the user's password back to the old password 
 * @param user
 * @return SettingsPage
 */
public SettingsPage revertToOldPassword (User user){
    changePasswordFields.revertToOldPassword(user);
    return this;
}

}