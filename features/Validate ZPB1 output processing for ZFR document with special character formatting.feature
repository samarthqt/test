Feature: Validate ZPB1 output processing for ZFR document with special character formatting  
  Ensure the system processes ZFR documents with special character formatting and generates ZPB1 output accurately.

  @TC-416
  Scenario: User logs in to the SAP S/4 HANA system with authorized credentials  
    Given the user has authorized credentials  
    When the user logs in to the SAP S/4 HANA system  
    Then the user is successfully logged into the system  

  @TC-416
  Scenario: User navigates to the periodic billing document processing transaction  
    Given the user has the necessary authorization to process periodic billing documents  
    When the user navigates to the periodic billing document processing transaction  
    Then the periodic billing document processing screen is displayed  

  @TC-416
  Scenario: User searches for the ZFR document using the document ID  
    Given the ZFR document ID is "ZFR54321"  
    When the user searches for the ZFR document with this document ID  
    Then the ZFR document with ID "ZFR54321" is displayed in the search results  

  @TC-416
  Scenario: User selects the ZFR document for processing  
    Given the ZFR document with ID "ZFR54321" is displayed in the search results  
    When the user selects the ZFR document for processing  
    Then the ZFR document is selected successfully  

  @TC-416
  Scenario: User triggers the output processing for the ZFR document  
    Given the ZFR document is selected for processing  
    When the user triggers the output processing for the ZFR document  
    Then the system initiates the output processing for the ZFR document  

  @TC-416
  Scenario: System determines ZPB1 as the output type  
    Given the output determination for ZPB1 is configured and active  
    When the user verifies the output type for the ZFR document  
    Then the system successfully determines ZPB1 as the output type  

  @TC-416
  Scenario Outline: Validate the generated ZPB1 output for special character formatting accuracy  
    Given the ZPB1 output is generated  
    When the user checks the output for special character formatting accuracy  
    Then the generated ZPB1 output "<result>"

    Examples:  
      | result                                  |  
      | accurately reflects the special character formatting |  

  @TC-416
  Scenario: Validate that all fields in the ZPB1 output are populated correctly  
    Given the ZPB1 output is generated  
    When the user validates the fields in the ZPB1 output  
    Then all fields in the ZPB1 output are populated correctly without formatting errors  

  @TC-416
  Scenario: Verify that there are no truncations or errors in the generated output  
    Given the ZPB1 output is generated  
    When the user verifies the ZPB1 output for truncations or errors  
    Then the ZPB1 output is complete without any truncations or errors  

  @TC-416
  Scenario: Confirm that the ZPB1 output is available for further actions  
    Given the ZPB1 output is generated  
    When the user confirms the availability of the ZPB1 output  
    Then the ZPB1 output is successfully available for further actions  

  @TC-416
  Scenario: Review the output logs for any processing errors or warnings  
    Given the ZPB1 output logs are available  
    When the user reviews the output logs  
    Then the output logs do not contain any errors or warnings related to the processing  

  @TC-416
  Scenario: Ensure the ZPB1 output is saved in the designated directory or location  
    Given the ZPB1 output is generated  
    When the user ensures the output is saved in the designated directory or location  
    Then the ZPB1 output is successfully saved in the designated directory or location