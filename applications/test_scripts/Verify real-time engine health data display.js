describe('TC-267 205 Verify real-time engine health data display', () => {
  const vehicleId = 'V123456';
  const engineTemperatureNormal = '90°C';
  const oilLevelNormal = '70%';
  const engineTemperatureOverheat = '120°C';
  const oilLevelLow = '20%';

  before(() => {
    cy.login('validUsername', 'validPassword');
  });

  it('should navigate to Diagnostics module', () => {
    cy.get('.diagnostics-module').click();
    cy.url().should('include', '/diagnostics');
  });

  it('should select vehicle and verify engine health metrics', () => {
    cy.selectVehicle(vehicleId);
    cy.get('.engine-temperature').should('contain', engineTemperatureNormal);
    cy.get('.oil-level').should('contain', oilLevelNormal);
    cy.get('.component-status').should('contain', 'OK');
  });

  it('should trigger and verify engine overheating alert', () => {
    cy.setEngineTemperature(engineTemperatureOverheat);
    cy.get('.alert-dashboard').should('contain', 'Engine Overheating');
    cy.get('.alert-details').should('contain', 'Recommendations for overheating');
  });

  it('should simulate and verify low oil level alert', () => {
    cy.setOilLevel(oilLevelLow);
    cy.get('.alert-dashboard').should('contain', 'Low Oil Level');
    cy.get('.alert-details').should('contain', 'Recommendations for low oil level');
  });

  it('should simulate and verify malfunctioning component alert', () => {
    cy.setComponentStatus('Faulty');
    cy.get('.alert-dashboard').should('contain', 'Malfunctioning Component');
    cy.get('.alert-details').should('contain', 'Recommendations for malfunctioning component');
  });
});