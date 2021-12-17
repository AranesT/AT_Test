import Hooks.WebDriverInicialization;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static Steps.baseSteps.*;
import static Steps.loginSteps.rememberedSessionId;
import static Steps.loginSteps.rememberingSessionId;
import static Steps.registrationSteps.*;
import static Steps.responseCheckSteps.alarmCheck;
import static Steps.responseCheckSteps.checkMatched;
import static pages.registerPage.generatedID;

public class RunnerTest extends WebDriverInicialization {

    @Epic("AT_Test")
    @Feature("Testing")
    @DisplayName("Авторизация тестового клиента")
    @Tag("Test1")
    @Test

    public void Test1() {
        userIDEnter(utils.Configuration.getConfigurationValue("enteringLog"));
        userPasswordEnter(utils.Configuration.getConfigurationValue("enteringPass"));
        enterEnteringButton();
        checkMatched("Тест", "Страна#");
    }

    @Epic("AT_Test")
    @Feature("Testing")
    @DisplayName("Регистрация и авторизация клиента")
    @Tag("Test2")
    @Test

    public void Test2() {
        clickYourHrefButton("Зарегистрироваться");
        userIDGenerating(6);
        userIDEnter(generatedUserID);
        userNameGenerating(7);
        userNameEnter(generatedUserName);
        userCountryEnter("Уругвай");
        alarmCheck("Уругвай");
        userPasswordGenerating(8);
        userPasswordEnter(generatedUserPassword);
        clickYourButton("Зарегестрироваться");
        userIDEnter(generatedUserID);
        userPasswordEnter(generatedUserPassword);
        enterEnteringButton();
        checkMatched(generatedUserName, "Уругвай");
    }

    @Epic("AT_Test")
    @Feature("Testing")
    @DisplayName("Регистрация клиента и авторизация по sessionId (в версиях V2 и V3)")
    @Tag("Test3")
    @Test

    public void Test3() {
        clickYourHrefButton("Зарегистрироваться");
        userIDGenerating(8);
        userIDEnter(generatedUserID);
        userNameGenerating(5);
        userNameEnter(generatedUserName);
        userCountryEnter("Уругвай");
        alarmCheck("Уругвай");
        userPasswordGenerating(12);
        userPasswordEnter(generatedUserPassword);
        changingCheckBoxStatus("createSessionId", "true");
        changingCheckBoxStatus("createSessionId", "false");
        sessionIdGenerating();
        userIdentEner(generatedID);
        clickYourButton("Зарегестрироваться");
        changingCheckBoxStatus("haveSessionId", "true");
        userIdentEner(generatedID);
        enterEnteringButton();
        checkMatched(generatedUserName, "Уругвай");
    }


    @Epic("AT_Test")
    @Feature("Testing")
    @DisplayName("Авторизация тестового клиента и повторный вход по созданному sessionId (в версиях V2 и V3)")
    @Tag("Test4")
    @Test

    public void Test4() {
        userIDEnter(utils.Configuration.getConfigurationValue("enteringLog"));
        userPasswordEnter(utils.Configuration.getConfigurationValue("enteringPass"));
        rememberingSessionId();
        enterEnteringButton();
        checkMatched("Тест", "Страна#");
        clickYourButton("Выйти из системы");
        changingCheckBoxStatus("haveSessionId", "true");
        userIdentEner(rememberedSessionId);
        enterEnteringButton();
        checkMatched("Тест", "Страна#");
    }
}