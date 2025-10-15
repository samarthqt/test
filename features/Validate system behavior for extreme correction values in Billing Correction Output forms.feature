Feature: Validate system behavior for extreme correction values in Billing Correction Output forms

  @TC-564
  Scenario: User logs in to the SAP S/4 HANA Cloud system
    Given the user has appropriate credentials
    When the user logs in to the SAP S/4 HANA Cloud system
    Then the user successfully logs in to the system

  @TC-564
  Scenario: User navigates to the Invoice Correction Request creation module
    Given the system is configured to handle large data volumes and extreme correction values
    When the user navigates to the Invoice Correction Request creation module
    Then the Invoice Correction Request creation module is displayed

  @TC-564
  Scenario Outline: Create Invoice Correction Request with maximum allowable amounts
    Given the user is in the Invoice Correction Request creation module
    When the user creates an Invoice Correction Request of type <requestType> with the <amountType> amount of <amount>
    Then the Invoice Correction Request is created successfully with the specified <amountType> amount
    And the system generates a <formType> form and links it correctly to the correction request and original billing document

    Examples:
      | requestType | amountType | amount   | formType |
      | ZRK         | credit     | 1000000  | ZGC1     |
      | ZRK1        | debit      | 1000000  | ZGL1     |

  @TC-564
  Scenario Outline: User attempts to print and export Billing Correction Output forms
    Given the user has access to the generated forms <formType>
    When the user attempts to <action> the <formType> form for customer delivery
    Then the <formType> form is <result> successfully without errors

    Examples:
      | formType | action  | result  |
      | ZGC1     | print   | printed |
      | ZGC1     | export  | exported |
      | ZGL1     | print   | printed |
      | ZGL1     | export  | exported |

  @TC-564
  Scenario: Verify formatting and content of Billing Correction Output forms
    Given the user has access to the generated forms ZGC1 and ZGL1
    When the user verifies the formatting and content of the forms
    Then the forms are formatted correctly and content is accurate

  @TC-564
  Scenario: Check system logs for entries regarding form generation and linking
    Given the forms ZGC1 and ZGL1 were generated and linked successfully
    When the user checks the system logs for relevant entries
    Then the system logs include entries describing the form generation and linking process

  @TC-564
  Scenario: Verify no system errors occur during processing of extreme correction values
    Given the system processes extreme correction values
    When the user verifies the system behavior during processing
    Then no system errors occur during the processing

  @TC-564
  Scenario: Document system behavior and outcomes for reporting purposes
    Given the system has processed extreme correction values successfully
    When the user documents the system behavior and outcomes
    Then the system behavior and outcomes are documented successfully