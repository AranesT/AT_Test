package Steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.Assert;
import pages.responcePage;

public class responseCheckSteps extends responcePage {

    @Step("Проверка совпадений введенных имени {name} и страны {country}")
    public static void checkMatched(String name, String country) {
        String gotResponce = responce();
        Assert.assertTrue(gotResponce.contains(name));
        Assert.assertTrue(gotResponce.contains(country));
    }

    @Step("Проверка аларма")
    public static void alarmCheck(String country) {
        String alarmText = Selenide.switchTo().alert().getText();
        Selenide.switchTo().alert().accept();
        Assert.assertTrue(alarmText.contains(country));
    }

}
