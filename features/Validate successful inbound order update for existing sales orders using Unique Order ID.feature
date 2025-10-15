Feature: Validate successful inbound order update for existing sales orders using Unique Order ID  
  Ensure the system updates existing sales orders accurately using the Unique Order ID from the inbound file. The inbound interface for customer sales data is active and operational.  

  @TC-352  
  Scenario: User logs in to the SAP S/4HANA system  
    Given the user has valid SAP credentials  
    When the user logs in to the SAP S/4HANA system  
    Then the user is successfully logged in and navigates to the SAP home screen  

  @TC-352  
  Scenario: User navigates to job scheduling module and configures a background job  
    Given the user is logged into the SAP S/4HANA system  
    When the user navigates to the job scheduling module  
    And the user configures a background job to poll the EC2 path for the file  
    Then the background job is configured successfully with the correct path and parameters  

  @TC-352  
  Scenario: User places the prepared pipe-delimited file in the EC2 path  
    Given a pipe-delimited file with updated sales order data is prepared  
    When the user places the prepared file in the specified EC2 path  
    Then the file is successfully placed in the EC2 path  

  @TC-352  
  Scenario: User executes the background job to process the file  
    Given the background job is configured with the correct path and parameters  
    When the user executes the background job  
    Then the system retrieves the file and begins processing the data  

  @TC-352  
  Scenario Outline: System validates and updates sales orders using Unique Order ID  
    Given the system retrieves the file from the EC2 path  
    When the system matches the Unique Order ID in the file with existing sales orders  
    And the system updates the sales order data with the new values from the file  
    Then the sales orders are updated with the correct quantity, price, and other details  
    And the system logs indicate successful processing with no errors or warnings  
    And the updated sales orders are visible in the sales module  
    And the changes are reflected in the database tables <DatabaseTable>  
    And the report confirms the accuracy of the updated sales order data  
    Examples:  
      | DatabaseTable |  
      | VBAK          |  
      | VBAP          |  

  @TC-352  
  Scenario: Validate no duplicate or erroneous updates are made to sales orders  
    Given the system has processed the file  
    When the user verifies the updated sales orders  
    Then no duplicate or erroneous updates are found in the system  

  @TC-352  
  Scenario: Validate notifications are sent to relevant stakeholders  
    Given the sales orders are successfully updated  
    When the user checks the notification system  
    Then notifications are sent successfully to relevant stakeholders confirming the update process