import base.TestSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Defaults;

public class ResetPasswordTest extends TestSetup {

    private final String SUCCESS_RESET_MESSAGE = "If you filled in the correct details an e-mail was sent to you. Please read it carefully and follow the instructions!";

    @Test
    @DisplayName("Can reset password with valid email")
    public void canResetPasswordWithValidEmail() {
        app.loginPage.pressResetPasswordLink();
        Assertions.assertEquals("Възстановяване на парола", app.resetPasswordPage.getH4Text());
        app.resetPasswordPage
                .populateEmail(Defaults.EMAIL)
                .pressSendButton();
    }

    @Test
    @DisplayName("Cant reset password with invalid email")
    public void cantResetPasswordWithInvalidEmail() {
        app.loginPage.pressResetPasswordLink();
        Assertions.assertEquals("Възстановяване на парола", app.resetPasswordPage.getH4Text());
        app.resetPasswordPage.populateEmail("alex@pragma.bg")
                .pressSendButton();
        Assertions.assertTrue(app.resetPasswordPage.getGenericSuccess().contains(SUCCESS_RESET_MESSAGE));
    }
}
