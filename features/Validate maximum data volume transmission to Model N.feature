Feature: Validate maximum data volume transmission to Model N  
  Ensure the system can handle and successfully transmit maximum data volume to Model N without performance degradation.  

  @TC-18  
  Scenario: User logs in to SAP S/4HANA Cloud with appropriate credentials  
    Given the user has valid credentials  
    When the user logs in to SAP S/4HANA Cloud  
    Then the user is successfully logged in  

  @TC-18  
  Scenario: User navigates to transaction ZOTC_SALES_ORDER  
    Given the user is logged in to SAP S/4HANA Cloud  
    When the user navigates to transaction ZOTC_SALES_ORDER  
    Then the transaction ZOTC_SALES_ORDER screen is displayed  

  @TC-18  
  Scenario: User navigates to transaction ZOTC_INDSALES_MDLNE  
    Given the user is logged in to SAP S/4HANA Cloud  
    When the user navigates to transaction ZOTC_INDSALES_MDLNE  
    Then the transaction ZOTC_INDSALES_MDLNE screen is displayed  

  @TC-18  
  Scenario Outline: Generate billing documents and validate generation  
    Given the user is on the "<transaction>" screen  
    When the user generates a large number of "<billing_document_type>" billing documents  
    Then the "<billing_document_type>" billing documents are successfully generated  

    Examples:  
      | transaction             | billing_document_type |  
      | ZOTC_SALES_ORDER        | direct sales          |  
      | ZOTC_INDSALES_MDLNE     | indirect sales        |  

  @TC-18  
  Scenario: Trigger outbound interface to send billing documents to Model N  
    Given the user has generated both direct and indirect sales billing documents  
    When the user triggers the outbound interface to send all billing documents to Model N  
    Then the outbound interface is triggered successfully  

  @TC-18  
  Scenario: Monitor system performance during data transmission  
    Given the user has triggered the outbound interface  
    When the user monitors the system performance during the transmission process  
    Then the system performance remains stable without degradation  

  @TC-18  
  Scenario: Verify successful transmission of all transactions to Model N  
    Given the user has triggered the outbound interface  
    When the user verifies the transmission status for all transactions  
    Then all transactions are successfully transmitted to Model N  

  @TC-18  
  Scenario: Verify received data in Model N  
    Given all transactions have been successfully transmitted to Model N  
    When the user logs in to Model N and reviews the received data  
    Then Model N displays all received data correctly  

  @TC-18  
  Scenario: Check logs in SAP S/4HANA for errors during transmission  
    Given the outbound interface has been triggered  
    When the user checks the logs in SAP S/4HANA for errors during transmission  
    Then no errors are found in the logs  

  @TC-18  
  Scenario: Validate data integrity in Model N  
    Given all transactions have been successfully transmitted to Model N  
    When the user validates the integrity of the transmitted data in Model N  
    Then data integrity is maintained, and no discrepancies are found  

  @TC-18  
  Scenario: Validate system scalability under maximum load conditions  
    Given the system is configured for maximum allowable daily transactions  
    When the user monitors system behavior under maximum load conditions  
    Then the system scalability is validated successfully