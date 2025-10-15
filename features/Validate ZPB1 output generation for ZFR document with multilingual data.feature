Feature: Validate ZPB1 output generation for ZFR document with multilingual data  
  Ensure the ZPB1 output is generated correctly for ZFR documents containing multilingual data.  

  @TC-534  
  Scenario: User logs in to the SAP S/4HANA system  
    Given the user has authorized credentials  
    When the user logs in to the SAP S/4HANA system  
    Then the user is successfully logged in and navigates to the SAP Easy Access screen  

  @TC-534  
  Scenario: User navigates to the periodic billing document processing transaction  
    Given the user is logged into the SAP S/4HANA system  
    When the user navigates to the periodic billing document processing transaction  
    Then the periodic billing document processing screen is displayed  

  @TC-534  
  Scenario Outline: User searches for the ZFR document with multilingual data  
    Given the user is on the periodic billing document processing screen  
    When the user searches for the ZFR document with ID "<document_id>"  
    Then the ZFR document with multilingual data "<multilingual_data>" is displayed in the results  

    Examples:  
      | document_id | multilingual_data               |  
      | ZFR67890    | English, German, and Chinese   |  

  @TC-534  
  Scenario: User triggers the output processing for ZPB1  
    Given the ZFR document with multilingual data is displayed  
    When the user selects the ZFR document and triggers the output processing for ZPB1  
    Then the system initiates the output processing for ZPB1  

  @TC-534  
  Scenario: Verify ZPB1 output generation and periodic billing form attachment  
    Given the output processing for ZPB1 is initiated  
    When the user verifies the ZPB1 output generation  
    Then the ZPB1 output is successfully generated and the periodic billing form is attached  

  @TC-534  
  Scenario: Verify multilingual data in the ZPB1 form  
    Given the ZPB1 output is successfully generated  
    When the user downloads the ZPB1 form  
    Then the ZPB1 form displays multilingual data correctly without truncation or formatting issues  

  @TC-534  
  Scenario: Check for errors or warnings in the output processing logs  
    Given the ZPB1 output processing is completed  
    When the user checks the logs for any errors or warnings  
    Then no errors or warnings are found in the output processing logs  

  @TC-534  
  Scenario: Verify the email dispatch logs for ZPB1 output  
    Given the ZPB1 output is successfully generated  
    When the user verifies the email dispatch logs for the ZPB1 output  
    Then the email with the ZPB1 output is successfully dispatched  

  @TC-534  
  Scenario Outline: Verify email recipient and subject line  
    Given the email with the ZPB1 output is successfully dispatched  
    When the user verifies the email recipient and subject line  
    Then the email is sent to the correct recipient "<recipient>" with the appropriate subject line "<subject_line>"  

    Examples:  
      | recipient          | subject_line                  |  
      | recipient@example.com | ZPB1 Output for ZFR67890   |  

  @TC-534  
  Scenario: User logs out of the SAP S/4HANA system  
    Given the user has completed their tasks  
    When the user logs out of the SAP S/4HANA system  
    Then the user is successfully logged out of the SAP S/4HANA system