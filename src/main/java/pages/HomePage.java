package pages;

import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);


    public HomePage(Page page) {
        super(page);
    }

    public String getUserInfo(){
        LOGGER.info("Getting logged user info");
        return getText("div.userpanel-header").trim();
    }

    public HomePage pressUserMenu(){
        LOGGER.info("Clicking on user profile menu");
        click("div.userpanel-header");
        return this;
    }

    public HomePage pressLogoutLink(){
        LOGGER.info("Clicking Sign Out button");
        click("//a[@class='selenium-button-logout button-logout']");
        return this;
    }



}
