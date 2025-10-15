Feature: Validate periodic billing creation for monthly frequency

  @TC-571
  Scenario: Validate successful login to SAP S/4HANA Cloud system
    Given user has valid credentials
    When user logs into the SAP S/4HANA Cloud system
    Then user is successfully logged in and navigates to the home screen

  @TC-571
  Scenario: Navigate to the billing due program
    Given user is logged into the SAP S/4HANA Cloud system
    When user navigates to the billing due program
    Then the billing due program screen is displayed

  @TC-571
  Scenario Outline: Validate Attribute 3 setting for Ship-to BP
    Given user is on the billing due program screen
    When user ensures that Attribute 3 is set to "<attributeValue>" for the Ship-to BP
    Then Attribute 3 is confirmed as "<attributeValue>"

    Examples:
      | attributeValue |
      | ZM            |

  @TC-571
  Scenario: Execute billing due program in foreground mode
    Given user has confirmed Attribute 3 for Ship-to BP
    When user executes the billing due program in foreground mode
    Then the program starts execution without errors

  @TC-571
  Scenario Outline: Verify inclusion of orders in billing batch
    Given the billing due program is running
    When user verifies that the program includes all orders with Attribute 3 = "<attributeValue>" in the billing batch
    Then all orders with Attribute 3 = "<attributeValue>" are included in the billing batch

    Examples:
      | attributeValue |
      | ZM            |

  @TC-571
  Scenario: Check sequence of generated billing documents
    Given the billing due program has included all orders in the billing batch
    When user checks the sequence in which billing documents are generated
    Then billing documents are generated in the correct sequence

  @TC-571
  Scenario: Validate billing document data against original sales orders
    Given billing documents are generated
    When user validates the billing document data against the original sales orders
    Then billing document data matches the corresponding sales orders

  @TC-571
  Scenario: Confirm periodic marking for monthly frequency
    Given billing documents are generated
    When user confirms that the billing documents are marked as periodic for monthly frequency
    Then billing documents are correctly marked as periodic with monthly frequency

  @TC-571
  Scenario: Check for error logs or warnings
    Given the billing due program execution is complete
    When user checks for any error logs or warnings during the execution
    Then no error logs or warnings are observed

  @TC-571
  Scenario: Save execution results and billing documents
    Given the billing due program execution is complete
    When user saves the execution results and billing documents for audit purposes
    Then execution results and billing documents are saved successfully

  @TC-571
  Scenario: Log out of the SAP S/4HANA Cloud system
    Given user has completed all tasks
    When user logs out of the SAP S/4HANA Cloud system
    Then user is successfully logged out

  @TC-571
  Scenario: Document test results and observations
    Given the billing due program execution is complete
    When user documents the test results and observations
    Then test results and observations are documented accurately