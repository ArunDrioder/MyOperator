package stepDefinition;

import TestComponents.BaseTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class stepDefinitionImplementation extends BaseTest
{
    public LandingPage landingPage;
    public ProductsPage productsPage;
    public ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException
    {
      landingPage =  launchApp();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_with_username_and_password(String username,String password)
    {
       productsPage  = landingPage.loginToApp(username, password);

    }

    @When("^I add product (.+) to Cart$")
    public void i_add_product_to_cart(String productName) throws InterruptedException
    {
        List<WebElement> products = productsPage.getProductsList();
        productsPage.addProductToCart(productName);
    }

    @And("^Checkout (.+) and submit the order$")
    public void checkOut_and_submit_the_order(String productName)
    {
        CartPage cartPage = productsPage.goToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Boolean match = cartPage.verifyProductName(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.checkOut();
        checkoutPage.selectCountry("india");
        confirmationPage = checkoutPage.submitOrder();

    }

    @Then("{string} message is displayed on ConfirmationPage")
    public void message_is_displayed_on_confirmation_page(String string)
    {
        String confirmationMsg = confirmationPage.getConfirmationMsg();
        System.out.println(confirmationMsg);
        Assert.assertTrue(confirmationMsg.equalsIgnoreCase(string));
        driver.close();
    }

    @Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {

        Assert.assertEquals(strArg1, landingPage.getErrorMessage());
        driver.close();
    }

}
