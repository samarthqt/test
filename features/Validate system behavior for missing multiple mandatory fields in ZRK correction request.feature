Feature: Validate system behavior for missing multiple mandatory fields in ZRK correction request

  @TC-95
  Scenario Outline: Validate mandatory fields for ZRK correction request submission
    Given user logs in to the SAP system with valid credentials
    And user navigates to the billing correction form
    And user selects "<correction_request_type>" as the correction request type
    And user leaves the "<mandatory_field_1>" and "<mandatory_field_2>" fields blank
    And user fills in other optional fields with valid data
    When user submits the correction request form
    Then the system prevents submission and displays error messages indicating the "<mandatory_field_1>" and "<mandatory_field_2>" fields are missing

    Examples:
      | correction_request_type | mandatory_field_1 | mandatory_field_2      |
      | ZRK                    | Customer ID       | Billing Document Number |

  @TC-95
  Scenario: Verify error messages clearly specify missing fields
    Given user logs in to the SAP system with valid credentials
    And user navigates to the billing correction form
    And user selects "ZRK" as the correction request type
    And user leaves the "Customer ID" and "Billing Document Number" fields blank
    And user fills in other optional fields with valid data
    When user submits the correction request form
    Then the system displays error messages clearly specifying that "Customer ID" and "Billing Document Number" are missing

  @TC-95
  Scenario: Validate navigation away from form with errors
    Given user logs in to the SAP system with valid credentials
    And user navigates to the billing correction form
    And user selects "ZRK" as the correction request type
    And user leaves the "Customer ID" and "Billing Document Number" fields blank
    And user fills in other optional fields with valid data
    When user attempts to navigate away from the form without correcting the errors
    Then the system prompts the user to save or discard changes

  @TC-95
  Scenario: Validate successful submission after correcting missing fields
    Given user logs in to the SAP system with valid credentials
    And user navigates to the billing correction form
    And user selects "ZRK" as the correction request type
    And user leaves the "Customer ID" and "Billing Document Number" fields blank
    And user fills in other optional fields with valid data
    When user corrects the "Customer ID" and "Billing Document Number" fields and resubmits the form
    Then the system accepts the correction request and displays a success message

  @TC-95
  Scenario: Verify correction request is saved in the system
    Given user logs in to the SAP system with valid credentials
    And user navigates to the billing correction form
    And user selects "ZRK" as the correction request type
    And user fills in all mandatory fields including "Customer ID" and "Billing Document Number"
    And user fills in other optional fields with valid data
    When user submits the correction request form
    Then the correction request is successfully saved in the system with all mandatory fields populated

  @TC-95
  Scenario: Validate user logout
    Given user is logged into the SAP system
    When user logs out of the SAP system
    Then the user is successfully logged out