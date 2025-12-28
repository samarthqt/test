Feature: Validate system behavior when sign conventions for S1 invoices are misconfigured in Direct Sales

  @TC-34
  Scenario: User navigates to the Direct Sales processing program
    Given the Direct Sales processing program "ZOTC_SALES_ORDER" is configured
    When the user navigates to the Direct Sales processing program
    Then the Direct Sales processing program is displayed successfully

  @TC-34
  Scenario Outline: User creates a sales order with billing document type S1
    Given the ZOTC_CROSSREFTAB table contains mappings for billing document type "<billingDocumentType>" with "<signConvention>"
    When the user creates a sales order using billing document type "<billingDocumentType>"
    Then the sales order is created successfully with the specified billing document type

    Examples:
      | billingDocumentType | signConvention        |
      | S1                  | correct configuration |
      | S1                  | incorrect configuration |

  @TC-34
  Scenario: User processes the sales order
    Given the user has created a sales order with billing document type S1
    When the user processes the sales order
    Then the system processes the sales order and generates a billing document

  @TC-34
  Scenario Outline: User verifies displayed amount and quantity in the billing document
    Given the billing document is generated
    When the user verifies the displayed amount and quantity in the billing document
    Then the system detects "<misconfigurationStatus>" and logs "<messageType>"

    Examples:
      | misconfigurationStatus | messageType       |
      | misconfigured          | error message     |
      | misconfigured          | warning message   |
      | correctly configured   | no issues logged  |

  @TC-34
  Scenario: User checks the error logs for details about misconfiguration
    Given the system has logged errors or warnings for misconfigured sign conventions
    When the user checks the error logs
    Then the error logs contain detailed information about the misconfigured sign conventions for S1 invoices

  @TC-34
  Scenario: User attempts to transmit billing document data to downstream systems
    Given the system has detected misconfigured sign conventions
    When the user attempts to transmit the billing document data to downstream systems
    Then the system prevents data transmission due to the detected misconfiguration

  @TC-34
  Scenario: User validates that no incorrect data is transmitted to downstream systems
    Given the system has prevented data transmission due to the detected misconfiguration
    When the user validates the transmitted data
    Then no incorrect data is transmitted, ensuring data integrity