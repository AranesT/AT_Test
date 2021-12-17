package Steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.registerPage;

import static com.codeborne.selenide.Selenide.$x;

public class registrationSteps extends registerPage {

    public static String generatedUserPassword;
    public static String generatedUserName;
    public static String generatedUserID;


    @Step("Задание имени {name}")
    public static void userNameEnter(String name) {
        $x(userNameField).should(Condition.visible).click();
        $x(userNameField).sendKeys(name);
    }

    @Step("Задание страны {country}")
    public static void userCountryEnter(String country) {
        $x(countryNameField).should(Condition.visible).click();
        $x(countryNameField).sendKeys(country);
        $x(userNameField).should(Condition.visible).click();
    }

    @Step("Генерация пароля")
    public static void userPasswordGenerating(int length) {
        generatedUserPassword = randomGenerator(length);
    }

    @Step("Генерация имени пользователя")
    public static void userNameGenerating(int length) {
        generatedUserName = randomGenerator(length);
    }

    @Step("Генерация идентификатора пользователя")
    public static void userIDGenerating(int length) {
        generatedUserID = randomGenerator(length);
    }
}
