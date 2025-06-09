@E2ETOpenMRSTest
Feature: OpenMRS

  @DemoCreateUser
  Scenario Outline: Create a new user with valid information
    Given I am on the OpenMRS login page using "<tc_id>"
    When I enter valid credentials
    And I click on LogIn button
    Then I should be redirected to the dashboard
    When I navigate to the user administration section
    Then User able to see the User form
    When User enters valid details for creating the user account
    And I click on Submit button
    Then Confirmation message should displayed in the User Section
    Examples:
      | tc_id          |
      | DemoWebUseCase |

  @DemoVerifyUser
  Scenario Outline: Fetch user information by username
    Given Access "<url>" with "<headers>" for "<tc_id>"
    When Send "<method>"
    Then verify request is success with status "<code>"
    Then verify "<key1>" in response body is "<value1>"

    Examples:
      | tc_id          | url              | headers | method | code | key1                      | value1                  |
      | DemoWebUseCase | creatingUserName | NA      | GET    | 200  | results[0].person.display | RANDOM_NUMBER_FROM_FILE |
