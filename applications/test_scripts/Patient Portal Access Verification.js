describe('Patient Portal Access Verification', () => {
  const patientEmail = 'patient@example.com';
  const patientPassword = 'SecurePass123';

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should allow the patient to log in and access their dashboard', () => {
    cy.get(LoginPage.emailInput).type(patientEmail);
    cy.get(LoginPage.passwordInput).type(patientPassword);
    cy.get(LoginPage.loginButton).click();

    cy.url().should('include', '/dashboard');
    cy.get(DashboardPage.upcomingAppointments).should('be.visible');
  });

  it('should allow the patient to view prescriptions', () => {
    cy.get(DashboardPage.prescriptionsLink).click();
    cy.url().should('include', '/prescriptions');
    cy.get(PrescriptionsPage.activePrescriptions).should('be.visible');

    cy.get(PrescriptionsPage.prescriptionItem).first().click();
    cy.get(PrescriptionsPage.prescriptionDetails).should('be.visible');
  });

  it('should allow the patient to access health data', () => {
    cy.get(DashboardPage.healthDataLink).click();
    cy.url().should('include', '/health-data');
    cy.get(HealthDataPage.healthRecords).should('be.visible');
  });

  it('should allow the patient to log out', () => {
    cy.get(DashboardPage.logoutButton).click();
    cy.url().should('include', '/login');
  });
});