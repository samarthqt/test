Feature: Validate partner determination with maximum Site_ID boundary  
  Ensure the system resolves Ship To and Sold To partners correctly when Site_ID is at its maximum allowable length.

  @TC-330
  Scenario Outline: Validate inbound file processing with maximum Site_ID  
    Given the user prepares an inbound file with Site_ID set to "<Site_ID>"  
    When the user uploads the prepared inbound file to the SAP system  
    And the user triggers the inbound interface processing manually  
    Then the system resolves the Ship To partner correctly as per the inbound file  
    And the system resolves the Sold To partner correctly as per the inbound file  
    And the Plant is determined correctly based on the provided "<CMO_ID>"  
    And no errors or warnings are logged during processing  
    And the document flow shows correct linkage between the inbound file and the processed data  
    And the partner master records for Ship To and Sold To partners are updated correctly  
    And the output logs confirm successful processing of the inbound file  
    And the processed data is displayed correctly in the relevant reporting screens  
    And the system sends a confirmation message indicating successful processing  

    Examples:  
      | Site_ID                      | CMO_ID  |  
      | ABCDEFGHIJKLMNOPQRSTUVWX     | CMO002  |