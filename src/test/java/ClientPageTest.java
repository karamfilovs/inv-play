import base.TestSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClientPageTest extends TestSetup {
    private static final String SUCCESS_ADD_MESSAGE = "The data has been saved";

    @Test
    @DisplayName("Can navigate to users page")
    public void canNavigateToUsersPage() {
        app.loginPage.login();
        app.clientPage.navigateTo();
        Assertions.assertTrue(app.clientPage.getBreadcrumbsText().contains("Users"));
    }

    @Test
    @DisplayName("Can create new user with mandatory fields only")
    public void canCreateUserWithMandatoryFields() {
        app.loginPage.login();
        app.clientPage.navigateTo();
        app.clientPage.pressAddButton()
                .populateFirstName("Test")
                .populateLastName("User")
                .pressSaveButton();
        Assertions.assertTrue(app.clientPage.getGenericSuccess().contains(SUCCESS_ADD_MESSAGE));
    }

}
