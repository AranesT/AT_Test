package pages;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

public class registerPage extends basePage {

    public static final String userNameField = "//input[@id='name']";
    public static final String countryNameField = "//input[@id='country']";
    public static String generatedID;

    public static void sessionIdGenerator() {
        generatedID = UUID.randomUUID().toString();
    }

    public static String randomGenerator(int arrayLength) {
        String generatedString = RandomStringUtils.randomAlphabetic(arrayLength);
        return generatedString;
    }
}


