Feature: Validate system handling of maximum entries in ZOTC_CROSSREFTAB  
  Ensure the system processes maximum allowable entries in ZOTC_CROSSREFTAB without performance degradation.

  @TC-71
  Scenario: User logs into SAP S/4HANA system  
    Given the user has appropriate credentials  
    When the user logs into the SAP S/4HANA system  
    Then the user is successfully logged in and has access to the configuration settings  

  @TC-71
  Scenario: User navigates to the configuration settings for ZOTC_CROSSREFTAB  
    Given the user is logged into the SAP S/4HANA system  
    When the user navigates to the configuration settings for the cross-reference table ZOTC_CROSSREFTAB  
    Then the cross-reference table ZOTC_CROSSREFTAB is displayed  

  @TC-71
  Scenario Outline: Validate system behavior with maximum allowable entries in ZOTC_CROSSREFTAB  
    Given the user is on the configuration settings for ZOTC_CROSSREFTAB  
    When the user populates the table with "<entry_count>" entries, including "<document_types>"  
    Then all entries are saved successfully without errors  

    Examples:  
      | entry_count | document_types         |  
      | 10000       | ZF2, S1, ZG2C, ZL2C   |  

  @TC-71
  Scenario: Trigger end-to-end data transmission to Model N  
    Given the ZOTC_CROSSREFTAB table is populated with maximum entries  
    When the user triggers the end-to-end data transmission to Model N  
    Then the data transmission process is initiated  

  @TC-71
  Scenario: Verify system logs for issues during data processing  
    Given the data transmission to Model N is initiated  
    When the user monitors system logs and error reports  
    Then no errors or warnings are logged related to the maximum entries  

  @TC-71
  Scenario: Validate error-free data transmission to Model N  
    Given the data transmission to Model N is initiated  
    When the user verifies the transmitted data  
    Then all billing document types are successfully transmitted without issues  

  @TC-71
  Scenario: Check system performance during processing of maximum entries  
    Given the ZOTC_CROSSREFTAB table is populated with maximum entries  
    When the user monitors the system during processing  
    Then the system performance remains stable with no slowdowns or crashes  

  @TC-71
  Scenario: Validate integrity of data transmitted to Model N  
    Given the data transmission to Model N is completed  
    When the user verifies the integrity of transmitted data  
    Then the data transmitted to Model N matches the entries in ZOTC_CROSSREFTAB  

  @TC-71
  Scenario: Verify concurrent user access during processing  
    Given the ZOTC_CROSSREFTAB table is populated with maximum entries  
    When multiple users access the cross-reference table concurrently  
    Then all users can access the table without performance issues  

  @TC-71
  Scenario: Validate persistence of maximum entries after system restart  
    Given the ZOTC_CROSSREFTAB table is populated with maximum entries  
    When the user simulates a system restart  
    Then all entries remain intact after the system restart  

  @TC-71
  Scenario Outline: Test addition of new entries beyond maximum limit  
    Given the ZOTC_CROSSREFTAB table is populated with maximum entries  
    When the user attempts to add "<additional_entries>" beyond the maximum limit  
    Then the system prevents the addition of entries with a clear error message  

    Examples:  
      | additional_entries |  
      | 1                 |  

  @TC-71
  Scenario: Confirm system stability after removing entries and re-triggering data transmission  
    Given the ZOTC_CROSSREFTAB table is populated with maximum entries  
    When the user removes some entries and re-triggers data transmission to Model N  
    Then the data transmission remains stable with no errors observed