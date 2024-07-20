package tests;

import TestComponents.BaseTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {
    @Test(dataProvider = "getData", groups = "Purchase")
    public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {


        ProductsPage productsPage = landingPage.loginToApp(input.get("email"), input.get("password"));

        productsPage.addProductToCart(input.get("product"));
        CartPage cartPage = productsPage.goToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Boolean match = cartPage.verifyProductName(input.get("product"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.checkOut();
        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String confirmationMsg = confirmationPage.getConfirmationMsg();
        System.out.println(confirmationMsg);

    }

    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//data//Data.json");
        return new Object[][]{{data.get(0)}, {data.get(1)}, {data.get(2)}, {data.get(3)}, {data.get(4)}};


    }
}
