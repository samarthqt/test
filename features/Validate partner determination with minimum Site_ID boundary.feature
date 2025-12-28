Feature: Validate partner determination with minimum Site_ID boundary  
  Ensure the system resolves Ship To and Sold To partners correctly when Site_ID is at its minimum allowable length.  

  @TC-329  
  Scenario Outline: Validate inbound file processing and partner determination  
    Given the user prepares an inbound file with Site_ID set to "<Site_ID>"  
    When the user uploads the prepared inbound file to the SAP system  
    And the user triggers the inbound interface processing manually  
    Then the system resolves the Ship To partner correctly and matches the data in the inbound file  
    And the system resolves the Sold To partner correctly and matches the data in the inbound file  
    And the Plant is determined correctly based on the provided "<CMO_ID>"  
    And the system logs show no errors or warnings during processing  
    And the document flow shows correct linkage with no data inconsistencies  
    And the partner master records for Ship To and Sold To partners are updated correctly with the processed data  
    And the output logs confirm successful processing of the inbound file  
    And the processed data is displayed correctly in the relevant reporting screens  
    And the system sends a confirmation message indicating successful processing of the inbound file  

    Examples:  
      | Site_ID | CMO_ID  |  
      | A       | CMO001  |