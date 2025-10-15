Feature: Validate error handling for negative values in ExternalContractAmount and ExternalDistrCostAmount

  @TC-67
  Scenario Outline: Validate the creation of billing documents with various ExternalContractAmount and ExternalDistrCostAmount values
    Given the user creates a "<DocumentType>" billing document for indirect sales
    When the user populates ExternalContractAmount with "<ExternalContractAmount>" and ExternalDistrCostAmount with "<ExternalDistrCostAmount>"
    Then the system "<ExpectedOutcome>"

    Examples:
      | DocumentType | ExternalContractAmount | ExternalDistrCostAmount | ExpectedOutcome                                |
      | ZG2C         | -100                   | -50                     | logs an error indicating invalid negative values and prevents data transmission |
      | ZL2C         | -200                   | -150                    | logs an error indicating invalid negative values and prevents data transmission |
      | ZG2C         | 100                    | 50                      | creates the billing document successfully     |
      | ZL2C         | 200                    | 150                     | creates the billing document successfully     |

  @TC-67
  Scenario: Validate that the system logs errors for ZG2C billing document with negative values
    Given the user checks the system logs for the ZG2C billing document
    Then the logs contain error messages indicating invalid negative values for ExternalContractAmount and ExternalDistrCostAmount

  @TC-67
  Scenario: Validate that the system logs errors for ZL2C billing document with negative values
    Given the user checks the system logs for the ZL2C billing document
    Then the logs contain error messages indicating invalid negative values for ExternalContractAmount and ExternalDistrCostAmount

  @TC-67
  Scenario: Validate repeated transmission attempts with negative values
    Given the user attempts to transmit the ZG2C and ZL2C billing documents again without correcting the values
    Then the system prevents transmission and logs the same error messages

  @TC-67
  Scenario: Validate successful transmission after correcting values
    Given the user corrects the values to positive in both ZG2C and ZL2C billing documents
    When the user retransmits the documents
    Then the system successfully transmits the corrected documents to Model N

  @TC-67
  Scenario: Validate no data is received in Model N for documents with negative values
    Given the user transmits the ZG2C and ZL2C billing documents with negative values
    Then Model N does not receive or process any data for the documents with negative values

  @TC-67
  Scenario: Validate clarity and actionability of error messages
    Given the user reviews the error messages logged for ZG2C and ZL2C billing documents
    Then the error messages provide clear guidance on correcting the negative values

  @TC-67
  Scenario: Ensure system integrity for other documents
    Given the user verifies other documents in the system
    Then no unintended changes are observed in other documents