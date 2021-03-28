package pages;

import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientPage.class);
    private static final String URL = "/clients/manage";


    public void navigateTo(){
        navigateTo(URL);
    }

    public ClientPage(Page page) {
        super(page);
    }

    public ClientPage pressAddButton(){
        LOGGER.info("Clicking Add link");
        click("//i[@class='ace-icon fa fa-plus align-top bigger-125']");
        return this;

    }   public ClientPage pressSaveButton(){
        LOGGER.info("Clicking Add link");
        click("//i[@class='ace-icon fa fa-check bigger-110']");
        return this;
    }

    public ClientPage populateFirstName(String firstName){
        LOGGER.info("Populate first name:" + firstName);
        typeText("#firstname", firstName);
        return this;
    }

    public ClientPage populateLastName(String lastName){
        LOGGER.info("Populate last name:" + lastName);
        typeText("#lastname", lastName);
        return this;
    }
}
