Feature: Verify output determination logic using Attribute 7 for billing output processing
  Ensure that the output determination logic successfully uses Attribute 7 for billing output processing. Attribute 7 must be configured in the payer master data.

  @TC-274
  Scenario: User logs into the SAP S/4 HANA system
    Given the user has appropriate credentials
    When the user logs into the SAP S/4 HANA system
    Then the user is successfully logged into the system

  @TC-274
  Scenario: User navigates to the billing document creation screen
    Given the user is logged into the SAP S/4 HANA system
    When the user navigates to the billing document creation screen
    Then the billing document creation screen is displayed

  @TC-274
  Scenario Outline: User enters billing document details including Attribute 7
    Given the user is on the billing document creation screen
    When the user enters the details for a new billing document with Attribute 7 value "<Attribute7Value>"
    Then the billing document details are entered successfully

    Examples:
      | Attribute7Value |
      | 10              |

  @TC-274
  Scenario: User saves the billing document
    Given the user has entered billing document details
    When the user saves the billing document
    Then the billing document is saved successfully

  @TC-274
  Scenario: User accesses output determination settings
    Given the billing document is saved
    When the user accesses the output determination settings for the created billing document
    Then the output determination settings are accessible

  @TC-274
  Scenario Outline: User configures output determination rule using Attribute 7
    Given the user is in the output determination settings
    When the user configures an output determination rule using Attribute 7 with value "<Attribute7Value>"
    Then the output determination rule is configured successfully

    Examples:
      | Attribute7Value |
      | 10              |

  @TC-274
  Scenario: User saves the output determination rule
    Given the output determination rule is configured
    When the user saves the output determination rule
    Then the output determination rule is saved successfully

  @TC-274
  Scenario: User triggers the output determination process
    Given the output determination rule is saved
    When the user triggers the output determination process
    Then the output determination process is triggered without errors

  @TC-274
  Scenario: User validates the output determination logic
    Given the output determination process is triggered
    When the user validates the output determination logic to ensure that Attribute 7 is used
    Then the output determination logic successfully uses Attribute 7

  @TC-274
  Scenario: User generates the billing output document
    Given the output determination logic is validated
    When the user generates the billing output document
    Then the billing output document is generated successfully

  @TC-274
  Scenario: User reviews the billing output document for Attribute 7 application
    Given the billing output document is generated
    When the user reviews the billing output document
    Then the billing output document confirms the application of Attribute 7

  @TC-274
  Scenario: User saves the billing output document for audit purposes
    Given the billing output document is reviewed
    When the user saves the billing output document
    Then the billing output document is saved successfully