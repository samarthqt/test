Feature: Validate system behavior for boundary correction amount at minimum allowable value

  @TC-402
  Scenario: User logs into the SAP S/4HANA system
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the system

  @TC-402
  Scenario: User navigates to the Invoice Correction Request creation screen
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the Invoice Correction Request creation screen
    Then the Invoice Correction Request creation screen is displayed

  @TC-402
  Scenario: User selects the Invoice Correction Request type
    Given the user is on the Invoice Correction Request creation screen
    When the user selects the Invoice Correction Request type as "ZRK"
    Then the Invoice Correction Request type is selected as "ZRK"

  @TC-402
  Scenario: User enters the original billing document number and customer details
    Given the user is on the Invoice Correction Request creation screen
    When the user enters the original billing document number "123456789" and customer details "ABC Corp"
    Then the billing document number and customer details are populated correctly

  @TC-402
  Scenario Outline: User specifies the correction amount
    Given the user has entered the billing document number and customer details
    When the user specifies the correction amount as "<correctionAmount>"
    Then the correction amount is entered successfully

    Examples:
      | correctionAmount |
      | -0.01           |

  @TC-402
  Scenario: User saves the Invoice Correction Request
    Given the user has specified the correction amount
    When the user saves the Invoice Correction Request
    Then the Invoice Correction Request is saved
    And a request ID is generated

  @TC-402
  Scenario: System generates and links a ZGC1 form to the correction request
    Given the Invoice Correction Request is saved
    When the system generates a ZGC1 form linked to the correction request
    Then the ZGC1 form is generated and linked to the Invoice Correction Request

  @TC-402
  Scenario: System links the ZGC1 form to the original billing document
    Given the ZGC1 form is generated
    When the system links the ZGC1 form to the original billing document
    Then the ZGC1 form is correctly linked to the original billing document

  @TC-402
  Scenario: User reviews the content of the ZGC1 form
    Given the ZGC1 form is generated
    When the user opens the ZGC1 form
    Then the ZGC1 form content is accurate and matches the correction details

  @TC-402
  Scenario: User prints the ZGC1 form
    Given the ZGC1 form is generated
    When the user attempts to print the ZGC1 form
    Then the ZGC1 form is successfully printed

  @TC-402
  Scenario: User exports the ZGC1 form
    Given the ZGC1 form is generated
    When the user attempts to export the ZGC1 form
    Then the ZGC1 form is successfully exported

  @TC-402
  Scenario: Verify the ZGC1 form is accessible in the system for future reference
    Given the ZGC1 form is generated
    When the user verifies the accessibility of the ZGC1 form in the system
    Then the ZGC1 form is stored and accessible in the system