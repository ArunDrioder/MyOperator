@tag
Feature: Error validation

  @ErrorValidation
  Scenario Outline: Verifying negative scenario
    Given I landed on Ecommerce Page
    When Logged in with username <email> and password <password>
    Then <validationMessage> message is displayed


    Examples:
      | email                   | password  | validationMessage            |
      | arunprasadh.s@gmail.com | Iamking@0 | Incorrect email or password. |
      | arunhandsomeh@gmail.com | Arun@!234 | Incorrect email or password. |
      | aruntestmeout@gmail.com | Arun@!234 | Incorrect email or password. |
      | 1234@5841               | 12346567  | Incorrect email or password  |
      | sgdsjgsj@687346386      | Iamking@0 | Incorrect email or password. |