Feature: Validate periodic billing creation for monthly frequency handling large volume of orders with Attribute 3 set to 'ZM'

  @TC-575
  Scenario: User logs into the SAP S/4HANA Cloud system with valid credentials
    Given the user has valid credentials for the SAP S/4HANA Cloud system
    When the user logs into the system
    Then the user is successfully logged in and navigates to the home screen

  @TC-575
  Scenario: User navigates to the billing due program
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the billing due program
    Then the billing due program screen is displayed

  @TC-575
  Scenario Outline: Validate orders with Attribute 3 set to 'ZM' during billing process
    Given the user ensures that Attribute 3 is set to "<attribute_value>" for the Ship-to BP
    And a large volume of sales orders eligible for billing is available
    When the user executes the billing due program in foreground mode
    Then the program starts execution without errors
    And the program processes all orders with Attribute 3 = "<attribute_value>" without errors
    And the generated billing documents are accurate with no missing or incorrect data
    And the program executes within acceptable time limits
    And no error logs or warnings are observed during the execution

    Examples:
      | attribute_value |
      | ZM             |

  @TC-575
  Scenario: User documents the test results and observations
    Given the billing process has been successfully executed
    When the user reviews the test results and observations
    Then the test results and observations are documented accurately