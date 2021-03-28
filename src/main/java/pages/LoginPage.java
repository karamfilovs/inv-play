package pages;

import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    public LoginPage(Page page) {
        super(page);
    }


    public LoginPage populateEmail(String username) {
        LOGGER.info("Entering username:" + username);
        typeText("#loginusername", username);
        return this;
    }

    public LoginPage populatePassword(String password) {
        LOGGER.info("Entering password:" + password);
        typeText("#loginpassword", password);
        return this;
    }

    public LoginPage pressLoginButton() {
        LOGGER.info("Clicking Login button");
        click("#loginsubmit");
        return this;
    }


    public LoginPage pressResetPasswordLink() {
        LOGGER.info("Clicking Reset Password link");
        click("#newpass2");
        return this;
    }


    public LoginPage login() {
        populateEmail(Defaults.EMAIL);
        populatePassword(Defaults.PASSWORD);
        pressLoginButton();
        return this;
    }




}
