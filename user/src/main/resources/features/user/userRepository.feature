Feature: Using for testing User Repository Code

  Scenario: test get user
    Given user id as "2L"
    When get user from db
    Then user with name "kumar"
