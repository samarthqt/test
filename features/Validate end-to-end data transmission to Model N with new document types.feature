Feature: Validate end-to-end data transmission to Model N with new document types  
  Ensure that end-to-end data transmission to Model N is successful and aligns with the mappings for new document types.  

  @TC-525  
  Scenario Outline: Validate the cross-reference table is updated with new mappings  
    Given the user ensures the cross-reference table "ZOTC_CROSSREFTAB" is updated  
    When the user verifies the mappings for document type "<DocumentType>"  
    Then the cross-reference table reflects the updated mapping for "<DocumentType>"  

    Examples:  
      | DocumentType |  
      | ZF2          |  
      | S1           |  
      | ZG2C         |  
      | ZL2C         |  

  @TC-525  
  Scenario: Trigger and validate data transmission for direct billing flows  
    Given the user triggers a test data transmission for direct billing flows to Model N  
    When the user monitors the logs for errors during the transmission  
    Then the logs indicate successful transmission without errors  
    And the data aligns with the expected mappings for direct billing flows  

  @TC-525  
  Scenario: Trigger and validate data transmission for indirect billing flows  
    Given the user triggers a test data transmission for indirect billing flows to Model N  
    When the user monitors the logs for errors during the transmission  
    Then the logs indicate successful transmission without errors  
    And the data aligns with the expected mappings for indirect billing flows  

  @TC-525  
  Scenario Outline: Validate the functionality of new document types in the Model N system  
    Given the user verifies the functionality of new document type "<DocumentType>" in the Model N system  
    Then the new document type "<DocumentType>" is functional without issues  

    Examples:  
      | DocumentType |  
      | ZF2          |  
      | S1           |  
      | ZG2C         |  
      | ZL2C         |  

  @TC-525  
  Scenario: Validate the accuracy and completeness of mappings for new document types  
    Given the user ensures the mappings for new document types are accurate and complete  
    Then the mappings for new document types are verified successfully  

  @TC-525  
  Scenario: Validate that the transmission does not impact existing document types  
    Given the user ensures the transmission process does not affect existing document types  
    Then the existing document types remain unaffected  

  @TC-525  
  Scenario: Document the results of the data transmission for audit purposes  
    Given the user documents the results of the data transmission  
    Then the results are successfully recorded for audit purposes  

  @TC-525  
  Scenario: Ensure the system is ready for production use with new document types  
    Given the user validates the system readiness for production use with new document types  
    Then the system is confirmed ready for production use