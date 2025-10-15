Feature: Validate error handling for missing mandatory fields in ZRK1 correction request

  @TC-94
  Scenario Outline: Validate system behavior for missing or incorrect mandatory fields in ZRK1 correction request
    Given the user logs in to the SAP system with valid credentials
    And the user navigates to the billing correction form
    And the user selects "<Correction Request Type>" as the correction request type
    When the user enters "<Customer ID>" in the 'Customer ID' field
    And the user enters "<Billing Document Number>" in the 'Billing Document Number' field
    And the user submits the form
    Then the system "<System Response>"
    And the system displays the message "<Error Message>"

    Examples:
      | Correction Request Type | Customer ID | Billing Document Number | System Response                     | Error Message                                    |
      | ZRK1                    | 12345       |                         | prevents submission                 | 'Billing Document Number' field is missing      |
      | ZRK1                    |             | 67890                   | prevents submission                 | 'Customer ID' field is missing                  |
      | ZRK1                    |             |                         | prevents submission                 | 'Customer ID' and 'Billing Document Number' are missing |
      | ZRK1                    | 12345       | 67890                   | accepts the correction request      |                                                |

  @TC-94
  Scenario: Validate navigation away from the form with unsaved changes
    Given the user logs in to the SAP system with valid credentials
    And the user navigates to the billing correction form
    And the user selects "ZRK1" as the correction request type
    And the user enters "12345" in the 'Customer ID' field
    And the user leaves the 'Billing Document Number' field blank
    When the user attempts to navigate away from the form without correcting the error
    Then the system prompts the user to save or discard changes

  @TC-94
  Scenario: Validate successful submission of ZRK1 correction request
    Given the user logs in to the SAP system with valid credentials
    And the user navigates to the billing correction form
    And the user selects "ZRK1" as the correction request type
    And the user enters "12345" in the 'Customer ID' field
    And the user enters "67890" in the 'Billing Document Number' field
    When the user submits the form
    Then the system accepts the correction request
    And the system displays a success message
    And the correction request is saved in the system

  @TC-94
  Scenario: Validate user logout from the SAP system
    Given the user is logged in to the SAP system
    When the user logs out of the SAP system
    Then the user is successfully logged out