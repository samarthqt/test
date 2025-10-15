Feature: Verify split logic for valid KATR1/KATR2 combinations during Sales Order to Billing Document copy process

  @TC-448
  Scenario Outline: Validate the Sales Order and Billing Document creation process with different valid KATR1/KATR2 combinations
    Given the user logs in to the SAP S/4HANA system with appropriate credentials
    And the user navigates to the Sales Order module and selects the option to create a new Sales Order
    When the user enters the required details for the Sales Order including valid KATR1 "<KATR1>" and KATR2 "<KATR2>" attribute values
    And the user saves the Sales Order and notes the Sales Order number
    Then the Sales Order is successfully saved, and a unique Sales Order number is generated
    When the user navigates to the Billing module and selects the option to create a Billing Document
    And the user enters the Sales Order number created in the previous step
    Then the system retrieves the Sales Order details for processing
    When the user executes the process to copy the Sales Order to a Billing Document
    Then the system processes the Sales Order and creates a Billing Document
    And the split logic is correctly applied to the Billing Document based on the KATR1 and KATR2 attributes
    And no error messages or warnings are displayed during the process
    And the generated Billing Document is validated for data integrity and accuracy
    Then the Billing Document data is accurate and consistent with the Sales Order

    Examples:
      | KATR1 | KATR2 |
      | ZI    | 10    |
      | ZC    | 20    |
      | ZS    | 10    |

  @TC-448
  Scenario: Verify the system processes all valid combinations of KATR1 and KATR2 correctly without issues
    Given the user repeats the process for other valid combinations of KATR1 and KATR2
    Then the system processes all valid combinations correctly without issues

  @TC-448
  Scenario: Log out of the SAP system
    Given the user logs out of the SAP system
    Then the user is successfully logged out of the system