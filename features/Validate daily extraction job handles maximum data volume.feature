Feature: Validate daily extraction job handles maximum data volume  
  Ensure the system successfully handles the maximum allowable daily transactions for direct sales during the daily extraction job.  

  @TC-373  
  Scenario Outline: Validate the daily extraction job with maximum data volume  
    Given the user logs in to the SAP S/4 HANA Cloud system with appropriate credentials  
    And the user navigates to the job scheduling module and verifies the daily extraction job schedule  
    When the user generates a large volume of direct sales data that approaches the system's maximum capacity  
    And the user triggers the daily extraction job to transmit the generated data to Model N  
    Then the system should perform the following validations:  
      | Validation Step                                             | Expected Outcome                                                      |  
      | Monitor system performance during data transmission        | System performance remains stable with no degradation                |  
      | Verify data transmission to Model N                        | All data is transmitted successfully without errors                  |  
      | Verify received data in Model N                            | Model N displays all received data accurately and completely         |  
      | Review system logs                                          | System logs show no warnings or errors related to extraction/transmission |  
      | Validate timestamps of transmitted data                    | Timestamps align with the extraction job schedule, ensuring data consistency |  
      | Verify system capacity handling                            | System successfully handles the maximum transaction capacity without exceeding limits |  
      | Confirm extraction job completion time                     | Extraction job completes within the defined time frame without delays |  
    And the user documents the results of the test ensuring all validations are met  

    Examples:  
      | Credentials       | Job Schedule Details    | Generated Data Volume | Model N Access |  
      | Valid credentials | Active schedule details | Maximum allowable     | Granted        |