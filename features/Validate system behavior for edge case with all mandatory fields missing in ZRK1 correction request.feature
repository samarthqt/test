Feature: Validate system behavior for edge case with all mandatory fields missing in ZRK1 correction request

  @TC-99
  Scenario Outline: Validate submission of ZRK1 correction request with varying mandatory field inputs
    Given the user logs into the SAP system with valid credentials
    And the user navigates to the billing correction form
    And the user selects "ZRK1" as the correction request type
    When the user enters "<Customer ID>" for Customer ID and "<Billing Document Number>" for Billing Document Number
    And the user submits the correction request
    Then the system responds with "<System Response>"
    And no correction request is created if mandatory fields are incomplete
    And a correction request is created if all mandatory fields are populated

    Examples:
      | Customer ID | Billing Document Number | System Response                                            |
      |             |                         | Error: Customer ID and Billing Document Number are missing |
      | ValidID     |                         | Error: Billing Document Number is missing                 |
      |             | ValidNumber             | Error: Customer ID is missing                             |
      | ValidID     | ValidNumber             | Success: Correction request created                       |

  @TC-99
  Scenario: Verify successful login and logout of the SAP system
    Given the user logs into the SAP system with valid credentials
    Then the user is successfully logged in
    When the user logs out of the SAP system
    Then the user is successfully logged out

  @TC-99
  Scenario: Verify saved correction request in the system
    Given the user logs into the SAP system with valid credentials
    And the user navigates to the billing correction form
    And the user selects "ZRK1" as the correction request type
    And the user enters valid Customer ID and valid Billing Document Number
    And the user submits the correction request
    Then the system accepts the correction request and displays a success message
    When the user logs out of the SAP system
    And the user logs back into the SAP system
    Then the correction request is found in the system with accurate details