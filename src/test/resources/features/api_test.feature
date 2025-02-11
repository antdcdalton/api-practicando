Feature: API Authentication with Token

  Scenario: Get user list with token authentication
  Given I request a token with valid credentials
  Then I should receive a valid token
    Then I get all register about two "https://reqres.in/api//api/users?page=2"
    And the response body should contain user data


