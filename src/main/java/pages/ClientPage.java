package pages;

import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientPage.class);
    private static final String URL = "/clients/manage";


    public void navigateTo(){
        LOGGER.info("Navigating to:" + Defaults.BASE_URL + URL);
        navigateTo(URL);
    }

    public ClientPage(Page page) {
        super(page);
    }

    public ClientPage pressAddButton(){
        LOGGER.info("Clicking Add link");
        click("//a[@class='newbtn selenium-add-client-button']");
        return this;

    }   public ClientPage pressSaveButton(){
        LOGGER.info("Clicking Add link");
        click("input[name=do_submit]");
        return this;
    }

    public ClientPage populateFirmName(String firmName){
        LOGGER.info("Populate firm name:" + firmName);
        typeText("input[name=firm_name]", firmName);
        return this;
    }

    public ClientPage populateFirmAddress(String address){
        LOGGER.info("Populate firm address:" + address);
        typeText("textarea[name=firm_addr]", address);
        return this;
    }

    public ClientPage populateFirCity(String city){
        LOGGER.info("Populate firm city:" + city);
        typeText("input[name=firm_town]", city);
        return this;
    }
}
