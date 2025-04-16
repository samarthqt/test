describe('TC-833 463 Data Entry Form Edge Case - Large Data', () => { before(() => { cy.loginAsClinician(); }); it('Access the Data Entry Forms section', () => { cy.visit('/data-entry-forms'); cy.contains('Data Entry Forms').should('be.visible'); }); it('Fill out the form with maximum allowable data', () => { const dataEntryPage = new DataEntryPage(); dataEntryPage.enterStudyId('12345'); dataEntryPage.enterPatientId('P001'); dataEntryPage.enterLargeData('Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'); }); it('Submit the form', () => { const dataEntryPage = new DataEntryPage(); dataEntryPage.submitForm(); cy.contains('Data is successfully submitted').should('be.visible'); }); });