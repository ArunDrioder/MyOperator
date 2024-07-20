package tests;

import TestComponents.BaseTest;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class ErrorValidations extends BaseTest {
    @Test(groups = {"ErrorHandling"}, dataProvider = "getLoginData")
    public void loginValidation(HashMap<String, String> input) throws IOException, InterruptedException {
        landingPage.loginToApp(input.get("email"), input.get("password"));
        String expectedMessage = input.get("expectedMessage");
        String actualMessage;
        if (input.get("email").isEmpty() && input.get("password").isEmpty()) {
            actualMessage = landingPage.getFrontendValidationMessage("email") + " " + landingPage.getFrontendValidationMessage("password");
            System.out.println(actualMessage);
        } else if (input.get("email").isEmpty() || !input.get("email").contains("@")) {
            actualMessage = landingPage.getFrontendValidationMessage("email");
            System.out.println(actualMessage);

        } else if (input.get("password").isEmpty() || input.get("password").length() < 6) {
            actualMessage = landingPage.getFrontendValidationMessage("password");
            System.out.println(actualMessage);
        } else {
            actualMessage = landingPage.getErrorMessage();
            System.out.println(actualMessage);
        }

        Assert.assertEquals(actualMessage.trim(), expectedMessage.trim());

    }


    @DataProvider
    public Object[][] getLoginData() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//data//Data.json");
        return new Object[][]{{data.get(5)}, {data.get(6)}, {data.get(7)}, {data.get(8)}, {data.get(9)}};


    }


}
