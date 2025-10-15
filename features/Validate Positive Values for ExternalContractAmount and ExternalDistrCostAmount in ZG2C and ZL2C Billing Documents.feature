Feature: Validate Positive Values for ExternalContractAmount and ExternalDistrCostAmount in ZG2C and ZL2C Billing Documents

  @TC-66
  Scenario Outline: Validate creation and processing of billing documents with positive values for ExternalContractAmount and ExternalDistrCostAmount
    Given the user creates a "<DocumentType>" billing document for indirect sales
    When the user populates the fields with ExternalContractAmount = <ExternalContractAmount> and ExternalDistrCostAmount = <ExternalDistrCostAmount>
    And the user transmits the "<DocumentType>" billing document to Model N
    Then Model N processes the billing document successfully without errors
    And Model N displays the positive values for ExternalContractAmount and ExternalDistrCostAmount fields
    And the data in Model N matches the transmitted data accurately

    Examples:
      | DocumentType | ExternalContractAmount | ExternalDistrCostAmount |
      | ZG2C         | 1000                   | 500                     |
      | ZL2C         | 1500                   | 800                     |
      | ZG2C         | 2000                   | 1000                    |
      | ZL2C         | 2500                   | 1200                    |

  @TC-66
  Scenario Outline: Test with different sets of positive values for billing documents
    Given the user creates a "<DocumentType>" billing document for indirect sales
    When the user populates the fields with ExternalContractAmount = <ExternalContractAmount> and ExternalDistrCostAmount = <ExternalDistrCostAmount>
    And the user transmits the "<DocumentType>" billing document to Model N
    Then Model N processes the billing document successfully without errors

    Examples:
      | DocumentType | ExternalContractAmount | ExternalDistrCostAmount |
      | ZG2C         | 3000                   | 1500                    |
      | ZL2C         | 3500                   | 1800                    |

  @TC-66
  Scenario: Ensure Model N processes both ZG2C and ZL2C billing documents without errors
    Given the user creates ZG2C and ZL2C billing documents for indirect sales
    When the user populates the fields with positive values for ExternalContractAmount and ExternalDistrCostAmount
    And the user transmits both ZG2C and ZL2C billing documents to Model N
    Then Model N processes both documents successfully without errors logged