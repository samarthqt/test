Feature: Validate ZPB1 output processing for ZFR document with multi-section formatting  
  Ensure the system processes ZFR documents with multi-section formatting and generates ZPB1 output accurately.

  @TC-417
  Scenario: User logs into the SAP S/4 HANA system with authorized credentials  
    Given the user has authorized credentials  
    When the user logs into the SAP S/4 HANA system  
    Then the user is successfully logged into the system  

  @TC-417
  Scenario: User navigates to the periodic billing document processing transaction  
    Given the user is logged into the SAP S/4 HANA system  
    When the user navigates to the periodic billing document processing transaction  
    Then the periodic billing document processing screen is displayed  

  @TC-417
  Scenario Outline: User searches for a ZFR document with a specific document ID  
    Given the user is on the periodic billing document processing screen  
    When the user searches for the ZFR document with document ID "<Document ID>"  
    Then the ZFR document with ID "<Document ID>" is displayed in the search results  

    Examples:  
      | Document ID  |  
      | ZFR67890     |  

  @TC-417
  Scenario: User selects the ZFR document for processing  
    Given the ZFR document is displayed in the search results  
    When the user selects the ZFR document for processing  
    Then the ZFR document is selected successfully  

  @TC-417
  Scenario: User triggers the output processing for the ZFR document  
    Given the ZFR document is selected for processing  
    When the user triggers the output processing for the ZFR document  
    Then the system initiates the output processing for the ZFR document  

  @TC-417
  Scenario: System determines ZPB1 as the output type  
    Given the system has initiated the output processing for the ZFR document  
    When the user verifies the output type determination  
    Then the system successfully determines ZPB1 as the output type  

  @TC-417
  Scenario: User checks the generated ZPB1 output for multi-section formatting accuracy  
    Given the system has generated the ZPB1 output  
    When the user reviews the output for multi-section formatting accuracy  
    Then the generated ZPB1 output accurately reflects the multi-section formatting  

  @TC-417
  Scenario: User validates all sections in the ZPB1 output are formatted correctly  
    Given the ZPB1 output is generated  
    When the user validates the formatting of all sections (Header, Body, Footer)  
    Then all sections in the ZPB1 output are formatted correctly without errors  

  @TC-417
  Scenario: User verifies the ZPB1 output for truncations or errors  
    Given the ZPB1 output is generated  
    When the user verifies the output for truncations or errors  
    Then the ZPB1 output is complete without any truncations or errors  

  @TC-417
  Scenario: User confirms the ZPB1 output is available for further actions  
    Given the ZPB1 output is generated  
    When the user checks the availability of the ZPB1 output for further actions  
    Then the ZPB1 output is successfully available for further actions  

  @TC-417
  Scenario: User reviews the output logs for processing errors or warnings  
    Given the ZPB1 output processing is complete  
    When the user reviews the output logs  
    Then the output logs do not contain any errors or warnings related to the processing  

  @TC-417
  Scenario: User ensures the ZPB1 output is saved in the designated location  
    Given the ZPB1 output is generated  
    When the user ensures the output is saved in the designated directory or location  
    Then the ZPB1 output is successfully saved in the designated directory or location