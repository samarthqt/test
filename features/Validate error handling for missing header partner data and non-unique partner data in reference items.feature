Feature: Validate error handling for missing header partner data and non-unique partner data in reference items  
Ensure the system prevents the creation of a Sales document when header partner data is missing and reference items contain non-unique partner data. Ensure the original Billing document exists.

Scenario Outline: Validate system behavior for Sales document creation with missing header partner data and non-unique partner data in reference items  
  @TC-190  
  Given the user is logged into the SAP S/4HANA Cloud system  
  And the user navigates to the transaction for creating Sales documents  
  And the user inputs the original Billing document number "<BillingDocumentNumber>" as the reference  
  And the reference items contain non-unique partner data "<ReferenceItems>"  
  And the header partner data is missing in the Billing document  
  When the user executes the creation process for the Sales document  
  Then the system identifies non-unique partner data in the reference items  
  And the system aborts the creation process with the error message "<ErrorMessage>"  
  And the system prevents saving of the document and retains data integrity  
  And the Billing document remains unaltered  
  And the user notifies the relevant team about the error for resolution  
  And the user logs out of the system  

Examples:  
  | BillingDocumentNumber | ReferenceItems                          | ErrorMessage                             |  
  | 123456                | Item1 - Partner A, Item2 - Partner A    | No unique partners found in reference items |  
  | 789012                | Item1 - Partner B, Item2 - Partner B    | No unique partners found in reference items |  
  | 345678                | Item1 - Partner C, Item2 - Partner C    | No unique partners found in reference items |