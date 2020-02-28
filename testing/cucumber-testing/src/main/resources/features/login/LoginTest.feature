Feature: User Login test
  I want to use this template for testing login

  Scenario Outline: when user logins in with correct details
    Given user enterd username as "<uname>"
    And and password as "<password>"
    When user clicked login button
    Then valid user "<uname>"

    Examples: 
      | uname    | password |
      | sai      | kumar    |
      | saikumar | pwd      |
      | kumar    | sai      |

  Scenario: when user logins in with wrong details
    Given user enterd username as "saikumar"
    And and password as "kumar"
    When user clicked login button
    Then valid user "saikumar"

  Scenario: when user logins in with wrong details
    Given user enterd username as "kumar"
    And and password as "kumar"
    When user clicked login button
    Then valid user "kumar"
