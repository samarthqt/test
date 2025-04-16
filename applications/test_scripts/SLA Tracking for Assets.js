describe('SLA Tracking for Assets', () => {
  before(() => {
    cy.login(); // Custom command for logging in
  });

  it('should navigate to SLA tracking page for assets', () => {
    const slaPage = new Slapage();
    slaPage.navigateTo();
    slaPage.verifyPageIsDisplayed();
  });

  it('should enter ASSET001 in asset ID field and display SLA details', () => {
    const slaPage = new Slapage();
    slaPage.enterAssetId('ASSET001');
    slaPage.verifySlaDetails('ASSET001', '2023-12-01');
  });

  it('should log a new SLA entry for ASSET001', () => {
    const slaPage = new Slapage();
    slaPage.logNewSlaEntry('ASSET001');
    slaPage.verifyNewSlaEntryLogged('ASSET001');
  });

  it('should monitor SLA status and end date', () => {
    const slaPage = new Slapage();
    slaPage.monitorSlaStatusAndEndDate('2023-12-01');
  });
});