Feature: Validate error handling for unsupported billing document types in ZOTC_CROSSREFTAB

  @TC-72
  Scenario Outline: Ensure the system rejects unsupported billing document types in ZOTC_CROSSREFTAB with clear error messages
    Given the user logs in to the SAP S/4HANA system with appropriate credentials
    And the user navigates to the configuration settings for the cross-reference table ZOTC_CROSSREFTAB
    When the user attempts to add a billing document type "<billing_document_type>" to the table
    Then the system displays a message "<error_message>"
    And the unsupported billing document type is not saved in the table

    Examples:
      | billing_document_type | error_message                                          |
      | ZU1                  | Unsupported billing document type: ZU1. Please check.  |
      |                      | Billing document type cannot be blank.                |
      | Z12345678901234567890 | Billing document type exceeds the allowed length.     |

  @TC-72
  Scenario: Validate that unsupported billing document types are excluded from data transmission
    Given the user logs in to the SAP S/4HANA system with appropriate credentials
    And the user navigates to the configuration settings for the cross-reference table ZOTC_CROSSREFTAB
    When the user triggers the end-to-end data transmission to Model N
    Then the data transmission does not include unsupported billing document types

  @TC-72
  Scenario: Monitor system logs for errors related to unsupported billing document types
    Given the user logs in to the SAP S/4HANA system with appropriate credentials
    And the user navigates to the configuration settings for the cross-reference table ZOTC_CROSSREFTAB
    When the user attempts to add an unsupported billing document type "ZU1" to the table
    Then the system logs display errors or warnings about the unsupported billing document type

  @TC-72
  Scenario: Validate actionable details in error messages for unsupported billing document types
    Given the user logs in to the SAP S/4HANA system with appropriate credentials
    And the user navigates to the configuration settings for the cross-reference table ZOTC_CROSSREFTAB
    When the user attempts to add an unsupported billing document type "ZU1" to the table
    Then the error messages clearly indicate the unsupported billing document type
    And the error messages suggest corrective actions