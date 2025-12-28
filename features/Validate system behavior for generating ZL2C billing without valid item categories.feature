Feature: Validate system behavior for generating ZL2C billing without valid item categories

  @TC-44
  Scenario: User logs into the SAP S/4HANA system
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the system

  @TC-44
  Scenario: User navigates to the billing correction request creation screen
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the billing correction request creation screen
    Then the billing correction request creation screen is displayed

  @TC-44
  Scenario Outline: User creates a billing correction request
    Given the user is on the billing correction request creation screen
    When the user enters the original billing document number "<originalBillingDocumentNumber>" and selects billing correction request type "<billingCorrectionRequestType>"
    Then the billing correction request is linked to the original document
    And the user saves the billing correction request
    Then the billing correction request is successfully created

    Examples:
      | originalBillingDocumentNumber | billingCorrectionRequestType |
      | 12345678                      | ZRK1                         |

  @TC-44
  Scenario Outline: Attempt to generate ZL2C billing without valid item categories
    Given the user has created a billing correction request
    When the user attempts to generate a ZL2C billing document linked to the billing correction request
    Then the system displays an error message indicating that the required item categories "<itemCategories>" are not configured

    Examples:
      | itemCategories       |
      | L2N and G2N          |

  @TC-44
  Scenario: Verify system logs for missing item category configuration
    Given the user attempted to generate a ZL2C billing document without valid item categories
    When the user checks the system logs for error messages
    Then the system logs contain detailed error messages regarding the missing item category configuration

  @TC-44
  Scenario: User logs out of the SAP S/4HANA system
    Given the user is logged into the SAP S/4HANA system
    When the user logs out of the SAP S/4HANA system
    Then the user is successfully logged out