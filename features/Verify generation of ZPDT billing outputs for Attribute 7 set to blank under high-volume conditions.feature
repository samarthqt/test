Feature: Verify generation of ZPDT billing outputs for Attribute 7 set to blank under high-volume conditions  
Ensure that ZPDT billing outputs are generated for payers with Attribute 7 set to blank, even under high-volume billing conditions.

@TC-264  
Scenario: User logs into the SAP S/4HANA system with appropriate credentials  
  Given the user has valid credentials  
  When the user logs into the SAP S/4HANA system  
  Then the user gains access to the Finance module  

@TC-264  
Scenario: User navigates to the Payer Business Partner master data maintenance screen  
  Given the user is logged into the SAP S/4HANA system  
  When the user navigates to the Payer Business Partner master data maintenance screen  
  Then the Payer Business Partner master data screen is displayed  

@TC-264  
Scenario Outline: User assigns Attribute 7 a blank value to multiple Payer Business Partners  
  Given the user is on the Payer Business Partner master data maintenance screen  
  When the user assigns Attribute 7 a blank value to "<payer_id>"  
  Then Attribute 7 is successfully updated to blank for "<payer_id>"  

Examples:  
  | payer_id  |  
  | PBP004    |  
  | PBP005    |  
  | PBP006    |  

@TC-264  
Scenario: User creates a high volume of billing documents for specified payers  
  Given the user has updated Attribute 7 to blank for multiple Payer Business Partners  
  When the user creates 10,000 billing documents for the specified payers  
  Then high-volume billing documents are created successfully  

@TC-264  
Scenario: User triggers the output determination process for the created billing documents  
  Given the user has created 10,000 billing documents  
  When the user triggers the output determination process for all billing documents  
  Then the output determination process is initiated  

@TC-264  
Scenario: User inspects the output logs for generated billing documents  
  Given the output determination process is completed  
  When the user inspects the output logs for the generated billing documents  
  Then ZPDT billing outputs are generated for payers with Attribute 7 set to blank  

@TC-264  
Scenario: User verifies system performance metrics during high-volume processing  
  Given the user is processing high-volume billing documents  
  When the user monitors system performance metrics  
  Then the system performance remains stable with no degradation  

@TC-264  
Scenario: User checks for error messages or warnings related to Attribute 7 configuration  
  Given the user has triggered the output determination process  
  When the user checks for error messages or warnings related to Attribute 7 configuration  
  Then no errors or warnings are displayed for Attribute 7 configuration  

@TC-264  
Scenario: User validates ZPDT outputs formatting and completeness  
  Given the ZPDT billing outputs are generated  
  When the user validates the formatting and completeness of the outputs  
  Then the ZPDT outputs are correctly formatted and complete  

@TC-264  
Scenario: User compares output determination behavior with expected generation logic  
  Given the ZPDT billing outputs are generated  
  When the user compares the output determination behavior with the expected generation logic  
  Then the output determination behavior aligns with the expected generation logic for Attribute 7 set to blank  

@TC-264  
Scenario: User generates a report summarizing output determination results  
  Given the output determination process is completed  
  When the user generates a report summarizing the results for processed billing documents  
  Then the report is generated successfully, showing ZPDT outputs for Attribute 7 set to blank  

@TC-264  
Scenario: User saves test results and documents observations or deviations  
  Given the user has completed the output determination process  
  When the user saves the test results and documents any observations or deviations  
  Then the test results are saved, and observations are documented