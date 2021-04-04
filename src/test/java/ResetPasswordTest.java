import base.TestSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Defaults;

public class ResetPasswordTest extends TestSetup {

    private final String SUCCESS_RESET_MESSAGE = "На e-mail адреса Ви беше изпратен линк, чрез който можете да смените паролата си.";
    private final String FAILED_RESET_MESSAGE = "Грешно потребителско име или e-mail адрес. Моля, опитайте отново.";

    @Test
    @DisplayName("Can reset password with valid email")
    public void canResetPasswordWithValidEmail() {
        app.loginPage.pressResetPasswordLink();
        Assertions.assertEquals("Възстановяване на парола", app.resetPasswordPage.getH4Text());
        app.resetPasswordPage.populateEmail(Defaults.EMAIL)
                .pressSendButton();
        Assertions.assertEquals(SUCCESS_RESET_MESSAGE, app.resetPasswordPage.getResetSuccessMessage());
    }

    @Test
    @DisplayName("Cant reset password with invalid email")
    public void cantResetPasswordWithInvalidEmail() {
        app.loginPage.pressResetPasswordLink();
        Assertions.assertEquals("Възстановяване на парола", app.resetPasswordPage.getH4Text());
        app.resetPasswordPage.populateEmail("alex@pragma.bg")
                .pressSendButton();
        Assertions.assertEquals(FAILED_RESET_MESSAGE, app.resetPasswordPage.getResetFailMessage());
    }
}
