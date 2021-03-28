package pages;

import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResetPasswordPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResetPasswordPage.class);

    public ResetPasswordPage(Page page) {
        super(page);
    }

    public ResetPasswordPage populateEmail(String email) {
        LOGGER.info("Entering email:" + email);
        typeText("#email", email);
        return this;
    }


    public ResetPasswordPage pressSendButton(){
        LOGGER.info("Pressing Send button");
        click("#submit");
        return this;
    }

}
