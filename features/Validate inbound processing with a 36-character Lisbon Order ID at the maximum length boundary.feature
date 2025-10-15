Feature: Validate inbound processing with a 36-character Lisbon Order ID at the maximum length boundary  
  To ensure the system correctly processes and maps a 36-character Lisbon Order ID without errors.

  @TC-325
  Scenario Outline: Validate inbound processing with various Lisbon Order ID inputs
    Given the user logs into the SAP system with valid credentials  
    And the user navigates to the inbound file upload interface  
    When the user uploads an inbound file with the Lisbon Order ID "<LisbonOrderID>"  
    And the user triggers the inbound interface processing manually  
    Then the system processes the file successfully  
    And the processing logs display "<LogStatus>"  
    And the system maps the Lisbon Order ID to a unique order identifier "<MappingStatus>"  
    And the sales order is created "<OrderCreationStatus>"  
    And the order details are "<OrderDetailsAccuracy>"  
    And the system handles the identifier "<IdentifierHandling>"  
    And the processed orders report "<ReportInclusion>"  
    And the system performance during processing is "<PerformanceStatus>"  
    And data integrity and business rules compliance is "<ComplianceStatus>"

    Examples:
      | LisbonOrderID                              | LogStatus     | MappingStatus          | OrderCreationStatus | OrderDetailsAccuracy | IdentifierHandling      | ReportInclusion          | PerformanceStatus         | ComplianceStatus        |
      | 123456789012345678901234567890123456       | No errors     | Correctly mapped       | Successfully created | Accurate             | Handled correctly       | Order included           | Efficient                | Maintained             |
      |                                           | Log error     | Not mapped             | Not created          | Not accurate         | Not handled             | Order not included       | Performance degraded     | Not maintained         |
      | 12345678901234567890                      | No errors     | Correctly mapped       | Successfully created | Accurate             | Handled correctly       | Order included           | Efficient                | Maintained             |
      | 1234567890123456789012345678901234567890  | Log error     | Not mapped             | Not created          | Not accurate         | Not handled             | Order not included       | Performance degraded     | Not maintained         |

  @TC-325
  Scenario: Validate successful login to SAP system
    Given the user logs into the SAP system with valid credentials  
    Then the user is logged in successfully  

  @TC-325
  Scenario: Validate navigation to the inbound file upload interface
    Given the user logs into the SAP system with valid credentials  
    When the user navigates to the inbound file upload interface  
    Then the inbound file upload interface is displayed  

  @TC-325
  Scenario: Validate system performance and compliance during processing
    Given the user logs into the SAP system with valid credentials  
    And the user navigates to the inbound file upload interface  
    When the user uploads an inbound file with a valid Lisbon Order ID  
    And the user triggers the inbound interface processing manually  
    Then the system processes the file efficiently without performance degradation  
    And data integrity is maintained, and business rules are followed