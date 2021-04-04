import base.TestSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Defaults;


public class LoginPageTest extends TestSetup {
    private final String INVALID_CREDENTIALS_ERROR = "Грешно потребителско име или парола. Моля, опитайте отново.";
    private final String BLANK_USER_CREDENTIALS_ERROR = "Моля, попълнете вашия email";
    private final String LOGOUT_SUCCESS = "Вие излязохте от акаунта си.";

    @Test
    @DisplayName("Can login with valid credentials")
    public void canLoginWithValidCredentials() {
        app.loginPage.populateEmail(Defaults.EMAIL)
                .populatePassword(Defaults.PASSWORD)
                .pressLoginButton();
        Assertions.assertEquals(Defaults.EMAIL, app.homePage.getUserInfo());
    }

    @Test
    @DisplayName("Cant login with blank credentials")
    public void cantLoginWithBlankCredentials() {
        app.loginPage.pressLoginButton();
        Assertions.assertEquals(BLANK_USER_CREDENTIALS_ERROR, app.loginPage.getGenericError());
    }

    @Test
    @DisplayName("Cant login with invalid credentials")
    public void cantLoginWithInvalidCredentials() {
        app.loginPage.populateEmail(Defaults.EMAIL)
                .populatePassword("1234")
                .pressLoginButton();
        Assertions.assertEquals(INVALID_CREDENTIALS_ERROR, app.loginPage.getGenericError());
    }


    @Test
    @DisplayName("Can login with valid credentials and logout")
    public void canLoginWithValidCredentialsAndLogout() {
        app.loginPage.login();
        app.homePage.pressUserMenu().pressLogoutLink();
        Assertions.assertEquals(LOGOUT_SUCCESS, app.loginPage.getGenericSuccess());
    }

}
