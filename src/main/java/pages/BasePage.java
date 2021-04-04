package pages;

import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    protected Page page;

    public String getH1Text() {
        return getText("h1");
    }

    public String getH2Text() {
        return getText("h2");
    }

    public String getH4Text() {
        return getText("h4");
    }

    public BasePage(Page page) {
        this.page = page;
    }

    protected void click(String selector) {
        waitForVisibilityOf(selector);
        page.click(selector);

    }

    protected void typeText(String selector, String text) {
        waitForVisibilityOf(selector);
        page.fill(selector, text);

    }

    protected void navigateTo(String pageUrl) {
        page.navigate(Defaults.BASE_URL + pageUrl);
    }

    protected void waitForVisibilityOf(String selector) {
        page.waitForSelector(selector);
    }

    protected String getText(String selector) {
        String text = page.textContent(selector).replace("\u00a0", "").trim();
        LOGGER.info("Text found is:" + text);
        return text;
    }

    public String getGenericError() {
        LOGGER.info("Retrieving failure message");
        return getText("#error");
    }

    public String getGenericSuccess() {
        LOGGER.info("Retrieving success message");
        return getText("#okmsg");
    }

    public String getBreadcrumbsText() {
        return getText("#breadcrumbs");
    }


}
