import api.ClientAPI;
import base.TestSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ClientPageTest extends TestSetup {
    private static final String SUCCESS_ADD_MESSAGE = "Клиентът е добавен успешно.";

    @Test
    @DisplayName("Can navigate to users page")
    public void canNavigateToUsersPage() {
        app.loginPage.login();
        app.clientPage.navigateTo();
        Assertions.assertEquals("Клиенти - QA Ground", app.clientPage.getTitle());
    }

    @Test
    @DisplayName("Can create new user with mandatory fields only")
    public void canCreateUserWithMandatoryFields() {
        ClientAPI.deleteAllClients();
        app.loginPage.login();
        app.clientPage.navigateTo();
        app.clientPage.pressAddButton()
                .populateFirmName("Test Company " + LocalDateTime.now() )
                .populateFirmAddress("Student District")
                .populateFirCity("Sofia")
                .pressSaveButton();
        Assertions.assertEquals(SUCCESS_ADD_MESSAGE, app.clientPage.getGenericSuccess());
    }

}
