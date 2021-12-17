package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class basePage {

    public static final String userIDFieldId = "//input[@id='uid']";
    public static final String userPasswordFieldId = "//input[@id='password']";
    public static final String userSessionIDFieldId = "//*[@name='sessionId']";
    static final SelenideElement enterButton = $x("//button[@type='submit']");

    public static SelenideElement getLoginButton() {
        return enterButton;
    }

    public static SelenideElement getButton(String buttonName) {
        SelenideElement button = $x("//*[@class='MuiButton-label' and text() = '" + buttonName + "']");
        return button;
    }

    public static SelenideElement getHrefButton(String buttonName) {
        SelenideElement hreButton = $x("//*[contains(@class, 'MuiTypography-root MuiLink-root MuiLink-underlineHover') and text() = '" + buttonName + "']");
        return hreButton;
    }

    public static void checkBox(String value, String condition) {
        SelenideElement checkBox = $x("//*[contains(@class, 'PrivateSwitchBase-input-4') and contains(@value, '" + value + "')]");
        if (condition == "true") {
            if (!checkBox.isSelected()) {
                checkBox.click();
            }
        }
        if (condition == "false") {
            if (checkBox.isSelected()) {
                checkBox.click();
            }
        }
    }
}


