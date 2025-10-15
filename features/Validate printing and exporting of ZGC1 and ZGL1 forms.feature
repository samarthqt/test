Feature: Validate printing and exporting of ZGC1 and ZGL1 forms  
  Ensure that ZGC1 and ZGL1 forms can be printed and exported successfully for customer delivery.  
  ZGC1 and ZGL1 forms are generated and linked to their respective Invoice Correction Requests.  

  @TC-398  
  Scenario: User logs into the SAP S/4HANA system  
    Given the user has appropriate credentials  
    When the user logs into the SAP S/4HANA system  
    Then the user is successfully logged into the system  

  @TC-398  
  Scenario: User navigates to the output management module  
    Given the user is logged into the SAP S/4HANA system  
    When the user navigates to the output management module  
    Then the output management module is displayed  

  @TC-398  
  Scenario Outline: Validate retrieval, printing, and exporting of forms  
    Given the user is in the output management module  
    When the user searches for the form using its ID "<Form ID>"  
    Then the form "<Form ID>" is retrieved successfully  
    When the user opens the form "<Form ID>" and reviews its content  
    Then the form content is displayed accurately  
    When the user selects the print option and chooses the printer "<Printer>"  
    Then the print options are displayed, and the printer "<Printer>" is selected  
    When the user prints the form "<Form ID>"  
    Then the form "<Form ID>" is successfully printed  
    When the user selects the export option and chooses the format "<Export Format>"  
    Then the export options are displayed, and the format "<Export Format>" is selected  
    When the user exports the form "<Form ID>"  
    Then the form "<Form ID>" is successfully exported as a "<Export Format>"  

    Examples:  
      | Form ID   | Printer    | Export Format |  
      | FORM123   | PRINTER01  | PDF           |  
      | FORM456   | PRINTER01  | PDF           |