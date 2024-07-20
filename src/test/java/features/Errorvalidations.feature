

@tag
Feature: Error validation
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page
    When Logged in with username <email> and password <password>
    Then "Incorrect email or password." message is displayed


    Examples:
      | email                   | password  |
      | arunprasadh.s@gmail.com | Iamking@0 |
      | arunhandsomeh@gmail.com | Arun@!234 |
      | aruntestmeout@gmail.com | Arun@!234 |
      | 1234@5841               | 12346567  |
      | sgdsjgsj@687346386      | Iamking@0 |
