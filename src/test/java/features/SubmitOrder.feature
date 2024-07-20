@tag
Feature: Purchase the order from Ecommerce Website


  Background:
    Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive Test of Submitting the order

    Given Logged in with username <email> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples:
      | email                         | password    | productName |
      | arunprasadh.s@gmail.com       | Arun@!234   | ADIDAS ORIGINAL |
      | arunhandsomebybirth@gmail.com | Arun@!234 | IPHONE 13 PRO |
      | aruntestme@gmail.com          | Arun@!234 | ZARA COAT 3 |
      | aruntestingtask@gmail.com     | Arun@!234 | IPHONE 13 PRO |
      | arunfromkarur@gmail.com       | Arun@!234 | ADIDAS ORIGINAL |