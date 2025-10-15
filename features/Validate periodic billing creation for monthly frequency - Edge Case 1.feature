Feature: Validate periodic billing creation for monthly frequency - Edge Case 1

  Verify the system's behavior when there are no orders with Attribute 3 = 'ZM' during the billing process. Attribute 3 must be set to 'ZM' for the Ship-to BP.

  @TC-574
  Scenario: User logs into SAP S/4HANA Cloud and navigates to the billing due program
    Given the user has valid credentials for the SAP S/4HANA Cloud system
    When the user logs into the system
    Then the user is successfully logged in and navigates to the home screen

  @TC-574
  Scenario Outline: Validate Attribute 3 setting for Ship-to BP and execute billing due program with no eligible sales orders
    Given the user navigates to the billing due program
    And the billing due program screen is displayed
    When the user ensures Attribute 3 is set to "<attribute_value>" for the Ship-to BP
    And the user executes the billing due program in foreground mode
    Then the program starts execution without errors
    And no billing documents are generated as there are no eligible orders
    And no error logs or warnings are observed during the execution
    And the test results and observations are documented accurately

    Examples:
      | attribute_value |
      | ZM             |