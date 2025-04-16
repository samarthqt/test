describe('Data Export Functionality', () => {
  const trialID = '67890';
  const downloadFolder = 'cypress/downloads';

  before(() => {
    cy.login('validUsername', 'validPassword');
  });

  beforeEach(() => {
    cy.visit('/dashboard');
    cy.get('nav').contains('Data Management').click();
    cy.get('nav').contains('Data Export').click();
  });

  it('should export trial data as CSV', () => {
    cy.get('input[name="trialId"]').type(trialID);
    cy.get('button').contains('Search').click();
    cy.get('button').contains('Export Data').click();
    cy.get('select').select('CSV');
    cy.get('button').contains('Confirm').click();
    cy.verifyDownload('trial_data.csv', downloadFolder);
    cy.readFile(`${downloadFolder}/trial_data.csv`).then((csvData) => {
      expect(csvData).to.include('Expected CSV Content');
    });
  });

  it('should export trial data as Excel', () => {
    cy.get('input[name="trialId"]').type(trialID);
    cy.get('button').contains('Search').click();
    cy.get('button').contains('Export Data').click();
    cy.get('select').select('Excel');
    cy.get('button').contains('Confirm').click();
    cy.verifyDownload('trial_data.xlsx', downloadFolder);
    cy.task('readExcel', `${downloadFolder}/trial_data.xlsx`).then((excelData) => {
      expect(excelData).to.include('Expected Excel Content');
    });
  });

  it('should handle large dataset export', () => {
    cy.get('input[name="trialId"]').type('largeDatasetTrialID');
    cy.get('button').contains('Search').click();
    cy.get('button').contains('Export Data').click();
    cy.get('select').select('CSV');
    cy.get('button').contains('Confirm').click();
    cy.verifyDownload('large_trial_data.csv', downloadFolder);
  });

  it('should log export activity', () => {
    cy.get('input[name="trialId"]').type(trialID);
    cy.get('button').contains('Search').click();
    cy.get('button').contains('Export Data').click();
    cy.get('select').select('CSV');
    cy.get('button').contains('Confirm').click();
    cy.checkSystemLogs('Export activity for trial ID 67890');
  });
});