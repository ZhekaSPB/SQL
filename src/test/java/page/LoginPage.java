package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.google.common.base.Verify;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginField = $("[data-test-id=login] input");
    private final SelenideElement passwordField = $("[data-test-id=password] input");
    private final SelenideElement loginButton = $("[data-test-id=action-login]");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public void verifyErrorNotificationVisibility() {
        errorNotification.shouldBe(visible);
        errorNotification.$$(" .notification_content").findBy(exactText("Ошибка! Неверно указан логин или пароль"));
    }

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();

    }
}