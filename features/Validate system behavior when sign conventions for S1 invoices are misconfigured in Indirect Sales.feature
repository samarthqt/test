Feature: Validate system behavior when sign conventions for S1 invoices are misconfigured in Indirect Sales

  @TC-35
  Scenario: User navigates to the Indirect Sales processing program
    Given the user navigates to the Indirect Sales processing program "ZOTC_INDSALES_MDLNE"
    Then the Indirect Sales processing program "ZOTC_INDSALES_MDLNE" is displayed successfully

  @TC-35
  Scenario Outline: Process indirect sales transaction with billing document type S1
    Given the ZOTC_CROSSREFTAB table contains mappings for billing document type "<BillingDocumentType>" with "<SignConventionStatus>" sign conventions
    When the user processes an indirect sales transaction using billing document type "<BillingDocumentType>"
    Then the system processes the indirect sales transaction and generates the required data
    And the system detects the "<SignConventionStatus>" sign conventions and logs an error or warning message

    Examples:
      | BillingDocumentType | SignConventionStatus  |
      | S1                 | incorrect             |

  @TC-35
  Scenario Outline: Verify error logs for misconfigured sign conventions
    Given the user processes an indirect sales transaction with billing document type "<BillingDocumentType>" and "<SignConventionStatus>" sign conventions
    When the user checks the error logs for details about the misconfiguration
    Then the error logs contain detailed information about the misconfigured sign conventions for "<BillingDocumentType>" invoices

    Examples:
      | BillingDocumentType | SignConventionStatus  |
      | S1                 | incorrect             |

  @TC-35
  Scenario Outline: Prevent data transmission to downstream systems due to misconfiguration
    Given the user processes an indirect sales transaction with billing document type "<BillingDocumentType>" and "<SignConventionStatus>" sign conventions
    When the user attempts to transmit the data to downstream systems
    Then the system prevents data transmission due to the detected misconfiguration
    And no incorrect data is transmitted, ensuring data integrity

    Examples:
      | BillingDocumentType | SignConventionStatus  |
      | S1                 | incorrect             |

  @TC-35
  Scenario Outline: Review system notifications or alerts for misconfigured sign conventions
    Given the user processes an indirect sales transaction with billing document type "<BillingDocumentType>" and "<SignConventionStatus>" sign conventions
    When the user reviews the system notifications or alerts generated for the misconfiguration
    Then the system generates appropriate notifications or alerts to inform relevant stakeholders about the issue

    Examples:
      | BillingDocumentType | SignConventionStatus  |
      | S1                 | incorrect             |