Feature: Validate ZPB1 output processing for ZFR document with maximum field lengths  
  Ensure the system successfully processes ZFR documents with maximum field lengths and generates ZPB1 output with accurate formatting.

  @TC-415  
  Scenario: User logs into the SAP S/4 HANA system with authorized credentials  
    Given the user has authorized credentials  
    When the user logs into the SAP S/4 HANA system  
    Then the user is successfully logged into the system  

  @TC-415  
  Scenario: User navigates to the periodic billing document processing transaction  
    Given the user has the necessary authorization to process periodic billing documents  
    When the user navigates to the periodic billing document processing transaction  
    Then the periodic billing document processing screen is displayed  

  @TC-415  
  Scenario Outline: User searches for a ZFR document with a specific document ID  
    Given the user is on the periodic billing document processing screen  
    When the user searches for the ZFR document with document ID "<DocumentID>"  
    Then the ZFR document with ID "<DocumentID>" is displayed in the search results  

    Examples:  
      | DocumentID |  
      | ZFR12345   |  

  @TC-415  
  Scenario: User selects the ZFR document for processing  
    Given the ZFR document is displayed in the search results  
    When the user selects the ZFR document for processing  
    Then the ZFR document is selected successfully  

  @TC-415  
  Scenario: User triggers the output processing for the ZFR document  
    Given the ZFR document is selected for processing  
    When the user triggers the output processing for the ZFR document  
    Then the system initiates the output processing for the ZFR document  

  @TC-415  
  Scenario: System determines ZPB1 as the output type  
    Given the system has initiated the output processing for the ZFR document  
    When the system determines the output type  
    Then the system successfully determines ZPB1 as the output type  

  @TC-415  
  Scenario: Verify formatting accuracy in the generated ZPB1 output  
    Given the ZPB1 output is generated  
    When the user checks the formatting of the ZPB1 output  
    Then the generated ZPB1 output adheres to the specified complex formatting rules  

  @TC-415  
  Scenario: Validate all fields in the ZPB1 output are populated with maximum lengths  
    Given the ZPB1 output is generated  
    When the user verifies the field lengths in the ZPB1 output  
    Then all fields in the ZPB1 output are populated correctly with maximum field lengths  

  @TC-415  
  Scenario: Verify no truncations or errors in the ZPB1 output  
    Given the ZPB1 output is generated  
    When the user verifies the ZPB1 output for truncations or errors  
    Then the ZPB1 output is complete without any truncations or errors  

  @TC-415  
  Scenario: Confirm ZPB1 output availability for further actions  
    Given the ZPB1 output is generated  
    When the user checks the availability of the ZPB1 output  
    Then the ZPB1 output is successfully available for further actions  

  @TC-415  
  Scenario: Review output logs for processing errors or warnings  
    Given the ZPB1 output is generated  
    When the user reviews the output logs  
    Then the output logs do not contain any errors or warnings related to the processing  

  @TC-415  
  Scenario: Ensure ZPB1 output is saved in the designated directory  
    Given the ZPB1 output is generated  
    When the user ensures the ZPB1 output is saved  
    Then the ZPB1 output is successfully saved in the designated directory or location