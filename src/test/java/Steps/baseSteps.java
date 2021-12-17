package Steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.basePage;

import static com.codeborne.selenide.Selenide.$x;
import static pages.registerPage.sessionIdGenerator;

public class baseSteps extends basePage {

    @Step("Нажатие кнопки входа")
    public static void enterEnteringButton() {
        getLoginButton().should(Condition.visible).click();
    }

    @Step("Нажатие кнопки {buttonName}")
    public static void clickYourButton(String buttonName) {
        getButton(buttonName).should(Condition.visible).click();
    }

    @Step("Нажатие href кнопки {hrefButtonName}")
    public static void clickYourHrefButton(String hrefButtonName) {
        getHrefButton(hrefButtonName).should(Condition.visible).click();
    }

    @Step("Ввод идентификатора {userID}")
    public static void userIDEnter(String userID) {
        $x(userIDFieldId).should(Condition.visible).click();
        $x(userIDFieldId).sendKeys(userID);
    }

    @Step("Ввод пароля {password}")
    public static void userPasswordEnter(String password) {
        $x(userPasswordFieldId).should(Condition.visible).click();
        $x(userPasswordFieldId).sendKeys(password);
    }

    @Step("Переключение положения чек-бокса {value} на {condition}")
    public static void changingCheckBoxStatus(String value, String condition) {
        checkBox(value, condition);
    }

    @Step("Генерация SessionID")
    public static void sessionIdGenerating() {
        sessionIdGenerator();
    }

    @Step("Заполнение идентификатора сессии {sessionID}")
    public static void userIdentEner(String sessionID) {
        $x(userSessionIDFieldId).should(Condition.visible).click();
        $x(userSessionIDFieldId).sendKeys(sessionID);
    }
}
