Feature: Validate system behavior for maximum length values in Attribute 1 and Attribute 2 in the billing due program module

  @TC-434
  Scenario Outline: Validate system behavior with varying lengths of Attribute 1 and Attribute 2
    Given the user is logged in to the SAP S/4HANA Cloud system
    When the user navigates to the billing due program module
    And the user enters Attribute 1 with "<Attribute1_Length>" characters
    And the user enters Attribute 2 with "<Attribute2_Length>" characters
    And the user executes the billing due program
    Then the system begins processing the input data
    And the system processes the input values "<Processing_Result>"
    And "<Billing_Result>" billing documents are created in the system
    And the system logs contain "<Log_Details>" about the input values

    Examples:
      | Attribute1_Length | Attribute2_Length | Processing_Result               | Billing_Result | Log_Details                     |
      | 255               | 255               | without errors or degradation  | No             | entries about maximum length    |
      | 10                | 10                | successfully                   | Yes            | entries about valid input       |
      | 0                 | 0                 | with errors                    | No             | entries about blank input       |
      | 300               | 300               | with errors                    | No             | entries about exceeding length  |

  @TC-434
  Scenario: Validate shortening of Attribute 1 and Attribute 2 to valid lengths
    Given the user is logged in to the SAP S/4HANA Cloud system
    When the user navigates to the billing due program module
    And the user enters Attribute 1 with valid length
    And the user enters Attribute 2 with valid length
    And the user executes the billing due program
    Then the system processes the program successfully with valid input values

  @TC-434
  Scenario: Document test results and logout
    Given the user has completed testing the billing due program module
    When the user documents the test results and screenshots of any error messages
    Then the test results and screenshots are documented for reference
    And the user logs out of the SAP S/4HANA Cloud system
    Then the user is logged out successfully