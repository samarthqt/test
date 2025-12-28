Feature: Validate creation of Credit Memo Request with missing header-level partner data in SAP S/4HANA Cloud

  @TC-186
  Scenario: Ensure the user can log in to the SAP S/4HANA Cloud system
    Given the user has necessary authorizations to create Credit Memo Requests
    When the user logs in to the SAP S/4HANA Cloud system
    Then the user logs in successfully

  @TC-186
  Scenario: Ensure the user can navigate to the Credit Memo Request creation screen
    Given the user is logged in to the SAP S/4HANA Cloud system
    When the user navigates to transaction VA01 for creating Credit Memo Requests
    Then the VA01 transaction screen is displayed

  @TC-186
  Scenario Outline: Validate entering the original Billing document number as the reference
    Given the user is on the VA01 transaction screen
    When the user enters the original Billing document number "<billing_document_number>" as the reference
    Then the billing document details are retrieved successfully
    And the system confirms missing header-level partner data

    Examples:
      | billing_document_number |
      | 12345678                |

  @TC-186
  Scenario: Ensure the system processes the Credit Memo Request creation
    Given the user has entered the original Billing document number as the reference
    When the user executes the Credit Memo Request creation process
    Then the system begins processing the request

  @TC-186
  Scenario: Validate system behavior for missing header-level partner data
    Given the system is processing the Credit Memo Request creation
    When the user observes system behavior as it searches for partner data in reference items
    Then the system identifies unique partner data from reference items

  @TC-186
  Scenario: Validate copying unique partner data to the target document header
    Given the system has identified unique partner data from reference items
    When the user validates the system copies unique partner data to the target document header
    Then the target document header contains unique partner data copied from reference items

  @TC-186
  Scenario: Ensure the user can save the Credit Memo Request
    Given the target document header contains unique partner data
    When the user saves the Credit Memo Request
    Then the Credit Memo Request is saved successfully

  @TC-186
  Scenario: Ensure the user can navigate to the 'display billing detail' report
    Given the Credit Memo Request is saved successfully
    When the user navigates to the 'display billing detail' report
    Then the 'display billing detail' report screen is displayed

  @TC-186
  Scenario: Validate referenced sales orders are displayed in the report
    Given the user is on the 'display billing detail' report screen
    When the user verifies the referenced sales orders in the report
    Then the referenced sales orders are displayed correctly in the report

  @TC-186
  Scenario: Validate linkage between the Credit Memo Request and the original Billing document
    Given the referenced sales orders are displayed correctly in the report
    When the user checks the linkage between the Credit Memo Request and the original Billing document
    Then the linkage is established correctly, ensuring traceability

  @TC-186
  Scenario: Ensure the user can log out of the SAP system
    Given the user has completed all necessary actions
    When the user logs out of the SAP system
    Then the user logs out successfully