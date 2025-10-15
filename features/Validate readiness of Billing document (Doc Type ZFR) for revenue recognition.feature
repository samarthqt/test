Feature: Validate readiness of Billing document (Doc Type ZFR) for revenue recognition
  Ensure the created Billing document is prepared for revenue recognition with the billing plan set as 'Due'.

  @TC-114
  Scenario: User logs into the SAP S/4HANA Cloud system
    Given the user is on the SAP S/4HANA Cloud login page
    When the user logs into the system
    Then the user is successfully logged in and navigates to the main dashboard

  @TC-114
  Scenario: User navigates to the Billing document module
    Given the user is on the main dashboard
    When the user navigates to the Billing document module
    Then the Billing document module is displayed

  @TC-114
  Scenario Outline: Validate Billing document details
    Given the user is in the Billing document module
    When the user searches for the Billing document ID "<BillingDocumentID>"
    Then the Billing document "<BillingDocumentID>" is displayed with details
    And the document type for "<BillingDocumentID>" is correctly set to "<DocumentType>"
    And the revenue recognition status for "<BillingDocumentID>" is "<RevenueStatus>"

    Examples:
      | BillingDocumentID | DocumentType | RevenueStatus |
      | BD001             | ZFR          | Ready         |

  @TC-114
  Scenario: Validate financial postings linked to the Billing document
    Given the user is in the Billing document module
    When the user validates the financial postings linked to the Billing document ID "BD001"
    Then the financial postings are accurate and linked to the Billing document ID "BD001"

  @TC-114
  Scenario: User navigates to the revenue recognition module
    Given the user is on the main dashboard
    When the user navigates to the revenue recognition module
    Then the revenue recognition module is displayed

  @TC-114
  Scenario Outline: Validate revenue recognition details for the Billing document
    Given the user is in the revenue recognition module
    When the user searches for the Billing document ID "<BillingDocumentID>"
    Then the Billing document "<BillingDocumentID>" is displayed with revenue recognition details
    And the linkage between "<BillingDocumentID>" and revenue recognition entries is accurate and complete
    And the revenue recognition calculations for "<BillingDocumentID>" are accurate and match the Billing document details

    Examples:
      | BillingDocumentID |
      | BD001             |

  @TC-114
  Scenario: Check system logs for errors during revenue recognition preparation
    Given the user is in the revenue recognition module
    When the user checks the system logs for the Billing document ID "BD001"
    Then no errors are logged during the revenue recognition preparation process

  @TC-114
  Scenario: Validate the overall workflow for revenue recognition readiness
    Given the user has completed all steps for revenue recognition readiness
    When the user validates the overall workflow
    Then the workflow functions correctly without errors or delays