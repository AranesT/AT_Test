package Steps;

import io.qameta.allure.Step;
import pages.loginPage;

import static com.codeborne.selenide.Selenide.$x;

public class loginSteps extends loginPage {
    public static String rememberedSessionId;

    @Step("Запоминание sessionID")
    public static void rememberingSessionId() {
        rememberedSessionId = $x(userSessionIDFieldId).getValue();
    }


}
