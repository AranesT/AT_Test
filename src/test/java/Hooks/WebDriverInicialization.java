package Hooks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static pages.basePage.getButton;

public class WebDriverInicialization {

    @BeforeAll
    static void setDriverProps() {
        String webDriverLocation = utils.Configuration.getConfigurationValue("webdriverlocationLOCAL");
        if (webDriverLocation != null) {
            System.setProperty("webdrriver.chrome.driver", webDriverLocation);
            System.setProperty("selenide.browser", "Chrome");
            Configuration.startMaximized = true;
            Configuration.timeout = 15000;
        }
    }

    @BeforeAll
    static void allureSubThreadParallel() {
        String listenerName = "AllureSelenide";

        if (!(SelenideLogger.hasListener(listenerName)))
            SelenideLogger.addListener(listenerName,
                    new AllureSelenide().
                            screenshots(true).
                            savePageSource(false));
    }


    @BeforeEach
    void startingUrl() {
        open(utils.Configuration.getConfigurationValue("urlMain"));
        getButton(utils.Configuration.getConfigurationValue("version")).should(Condition.visible).click();
    }

    @AfterEach
    void end() {
        WebDriverRunner.closeWindow();
        WebDriverRunner.closeWebDriver();
    }

}

