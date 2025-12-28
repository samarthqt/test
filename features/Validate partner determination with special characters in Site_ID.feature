Feature: Validate partner determination with special characters in Site_ID  
  Ensure the system resolves Ship To and Sold To partners correctly when Site_ID contains special characters.

  @TC-331  
  Scenario Outline: Validate inbound file processing with Site_ID containing special characters  
    Given the user prepares an inbound file with Site_ID "<Site_ID>"  
    When the user uploads the inbound file to the SAP system  
    And the user triggers the inbound interface processing manually  
    Then the system resolves the Ship To partner correctly using the Site_ID "<Site_ID>"  
    And the system resolves the Sold To partner correctly using the Site_ID "<Site_ID>"  
    And the system determines the Plant correctly based on the provided CMO_ID "<CMO_ID>"  
    And no errors or warnings are logged during processing for Site_ID "<Site_ID>"  
    And the document flow shows correct linkage between the inbound file and processed data  
    And the partner master records for Ship To and Sold To partners are updated correctly  
    And the output logs confirm successful processing of the inbound file  
    And the processed data is displayed correctly in the relevant reporting screens  
    And the system sends a confirmation message indicating successful processing  

    Examples:  
      | Site_ID     | CMO_ID  |  
      | SITE@123#   | CMO003  |  
      | SITE$456%   | CMO004  |  

  @TC-331  
  Scenario: Validate system logs for no errors or warnings during processing  
    Given the user prepares an inbound file with Site_ID "SITE@123#"  
    When the user uploads the inbound file to the SAP system  
    And the user triggers the inbound interface processing manually  
    Then no errors or warnings are logged during processing for Site_ID "SITE@123#"  

  @TC-331  
  Scenario: Validate document flow for proper linkage  
    Given the user prepares an inbound file with Site_ID "SITE@123#"  
    When the user uploads the inbound file to the SAP system  
    And the user triggers the inbound interface processing manually  
    Then the document flow shows correct linkage between the inbound file and processed data  

  @TC-331  
  Scenario: Validate partner master records for Ship To and Sold To partners  
    Given the user prepares an inbound file with Site_ID "SITE@123#"  
    When the user uploads the inbound file to the SAP system  
    And the user triggers the inbound interface processing manually  
    Then the partner master records for Ship To and Sold To partners are updated correctly  

  @TC-331  
  Scenario: Validate output logs for processing details  
    Given the user prepares an inbound file with Site_ID "SITE@123#"  
    When the user uploads the inbound file to the SAP system  
    And the user triggers the inbound interface processing manually  
    Then the output logs confirm successful processing of the inbound file  

  @TC-331  
  Scenario: Verify processed data visibility in reporting screens  
    Given the user prepares an inbound file with Site_ID "SITE@123#"  
    When the user uploads the inbound file to the SAP system  
    And the user triggers the inbound interface processing manually  
    Then the processed data is displayed correctly in the relevant reporting screens  

  @TC-331  
  Scenario: Ensure confirmation message for successful processing  
    Given the user prepares an inbound file with Site_ID "SITE@123#"  
    When the user uploads the inbound file to the SAP system  
    And the user triggers the inbound interface processing manually  
    Then the system sends a confirmation message indicating successful processing of the inbound file