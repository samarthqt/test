Feature: Validate error handling for invalid Unique Order ID in inbound file  
  Ensure the system rejects inbound files with invalid Unique Order IDs and logs appropriate errors.  

  @TC-354  
  Scenario: User logs into the SAP S/4HANA system  
    Given the user has valid SAP credentials  
    When the user logs into the SAP S/4HANA system  
    Then the user is successfully logged in and navigates to the SAP home screen  

  @TC-354  
  Scenario Outline: Validate error handling for invalid Unique Order IDs in inbound file  
    Given a pipe-delimited file with Unique Order IDs <Order ID> is prepared and placed in the EC2 path  
    When the user navigates to the job scheduling module and configures a background job to poll the EC2 path for the file  
    And the user places the prepared pipe-delimited file in the EC2 path  
    And the user executes the background job to process the file  
    Then the system retrieves the file and begins processing the data  
    And the system identifies the invalid Unique Order IDs in the file  
    And the system stops processing the file  
    And the system logs capture detailed error messages for each invalid Unique Order ID  
    And no updates are made to the sales orders in the system  
    And the system sends notifications to stakeholders about the error  
    And the file is moved to an error directory for further analysis  
    And the system does not create any duplicate or erroneous sales orders  
    And the corrected file can be reprocessed without issues  
    And the error handling process complies with organizational policies  

    Examples:  
      | Order ID      |  
      | INVALID123    |  
      | INVALID456    |  
      | INVALID789    |  

  @TC-354  
  Scenario: Validate reprocessing of corrected file  
    Given the user has a corrected file with valid Unique Order IDs  
    When the user places the corrected file in the EC2 path  
    And the user executes the background job to process the corrected file  
    Then the system successfully processes the corrected file without issues  

  @TC-354  
  Scenario: Confirm compliance with organizational policies for error handling  
    Given the error handling process is implemented in the system  
    When the user reviews the error handling process  
    Then the process adheres to organizational policies and standards