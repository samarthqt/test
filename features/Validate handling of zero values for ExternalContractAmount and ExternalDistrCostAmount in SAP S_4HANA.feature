Feature: Validate handling of zero values for ExternalContractAmount and ExternalDistrCostAmount in SAP S/4HANA

  @TC-68
  Scenario Outline: Validate zero values for ExternalContractAmount and ExternalDistrCostAmount during billing document creation and transmission
    Given the user is logged into the SAP S/4HANA system with valid credentials
    When the user navigates to the billing document creation screen for indirect sales
    And the user creates a new billing document of type "<DocumentType>" with ExternalContractAmount "<ExternalContractAmount>" and ExternalDistrCostAmount "<ExternalDistrCostAmount>"
    Then the billing document is created successfully with the specified values
    When the user transmits the "<DocumentType>" billing document to Model N
    Then the system logs appropriate error messages for zero values in ExternalContractAmount and ExternalDistrCostAmount
    And the Model N interface shows the document is rejected and logged
    And the error messages are clear and aligned with business rules
    And the SAP S/4HANA logs show the transmission attempts and corresponding errors for zero-value fields

    Examples:
      | DocumentType | ExternalContractAmount | ExternalDistrCostAmount |
      | ZG2C         | 0                      | 0                       |
      | ZL2C         | 0                      | 0                       |

  @TC-68
  Scenario: Validate documentation of findings for zero-value handling
    Given the user has reviewed the error logs and Model N interface for rejected documents
    When the user documents the findings
    Then the findings align with the expected outcomes