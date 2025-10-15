Feature: Validate system behavior with edge case data for outbound transmission  
The system should handle edge case data, such as maximum field lengths, during outbound transmission. The system is configured with new document types (ZF2, S1, ZG2C, ZL2C) in ZOTC_CROSSREFTAB.

@TC-17  
Scenario Outline: Validate edge case data during outbound transmission  
  Given the user is logged into SAP S/4HANA with authorized credentials  
  And the Medium Model N interface is active and ready to receive data  
  When the user navigates to transaction ZOTC_SALES_ORDER  
  And the user enters the following edge case data:  
    | Product Number | Ship-to | Sold-to    | Quantity  | Amount           | Invoice Number |  
    | <ProductNumber> | <ShipTo> | <SoldTo> | <Quantity> | <Amount> | <InvoiceNumber> |  
  And the user saves the direct sales billing document  
  And the user triggers the outbound interface to send the billing document to Model N  
  Then the outbound transmission logs indicate successful transmission of the billing document  
  And Model N receives the billing document with all required fields  
  And the entries in ZOTC_CROSSREFTAB confirm that new document types are updated correctly  
  And the linkage between the billing document and Model N is established successfully  
  And no errors are logged in the error logs  
  And the report of transmitted billing documents shows all transmitted documents including the tested one  
  And the financial calculations in Model N based on the transmitted data are accurate  

Examples:  
  | ProductNumber                              | ShipTo       | SoldTo       | Quantity  | Amount           | InvoiceNumber                              |  
  | P1234567890123456789012345678901234567890 | Customer A   | Customer B   | 999999999 | 999999999999999  | INV1234567890123456789012345678901234567890 |  
  | P1234567890123456789012345678901234567890 | Customer C   | Customer D   | 1         | 0                | INV0000000000000000000000000000000000000    |  
  | P1234567890123456789012345678901234567890 | Customer E   | Customer F   | 999999999 | 1000000000000000 | INV9999999999999999999999999999999999999    |