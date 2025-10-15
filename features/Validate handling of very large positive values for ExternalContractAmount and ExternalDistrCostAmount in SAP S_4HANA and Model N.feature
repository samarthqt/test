Feature: Validate handling of very large positive values for ExternalContractAmount and ExternalDistrCostAmount in SAP S/4HANA and Model N

  @TC-69
  Scenario Outline: Validate creation and transmission of billing documents with large positive values
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the billing document creation screen for indirect sales
    And the user creates a new billing document of type "<DocumentType>" with ExternalContractAmount "<ExternalContractAmount>" and ExternalDistrCostAmount "<ExternalDistrCostAmount>"
    Then the billing document "<BillingDocument>" is created successfully with the specified values
    When the user transmits the "<DocumentType>" billing document to Model N
    Then the document is successfully transmitted to Model N
    And the data received in Model N for "<DocumentType>" is accurate and complete
    And the SAP S/4HANA logs show successful transmission with no errors for large value fields
    And the Model N interface shows no processing errors related to large positive values
    And the system handles large numerical values without truncation or data loss

    Examples:
      | DocumentType | ExternalContractAmount | ExternalDistrCostAmount | BillingDocument  |
      | ZG2C         | 1000000000             | 1000000000              | ZG2C1234567      |
      | ZL2C         | 9999999999             | 9999999999              | ZL2C7654321      |

  @TC-69
  Scenario: Document findings and ensure expected outcomes
    Given the user has completed validation of large numerical values handling
    When the user documents the findings
    Then the findings align with the expected outcomes