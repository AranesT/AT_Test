package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class responcePage extends basePage {

    public static String responce() {
        SelenideElement responce = $x("//*[@class='MuiTypography-root MuiTypography-h6']");
        String bodyResponce = responce.getText();
        return bodyResponce;
    }
}
