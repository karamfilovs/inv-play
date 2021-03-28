package pages;

import com.microsoft.playwright.Page;

public class App {
    private Page page;
    public LoginPage loginPage;
    public HomePage homePage;
    public ResetPasswordPage resetPasswordPage;
    public ClientPage clientPage;

    public App(Page page) {
        this.page = page;
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
        resetPasswordPage = new ResetPasswordPage(page);
        clientPage = new ClientPage(page);
    }


}
