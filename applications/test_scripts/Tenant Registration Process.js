describe('Tenant Registration Process', () => {
    const tenantPage = new TenantPage();

    beforeEach(() => {
        cy.visit('/tenant-registration');
    });

    it('should display registration form', () => {
        tenantPage.getForm().should('be.visible');
        tenantPage.getNameField().should('exist');
        tenantPage.getContactField().should('exist');
        tenantPage.getLeaseTermField().should('exist');
    });

    it('should allow valid tenant registration', () => {
        tenantPage.enterName('John Doe');
        tenantPage.enterContact('john.doe@example.com', '123-456-7890');
        tenantPage.selectLeaseTerm('12 months');
        tenantPage.submitForm();
        cy.checkDatabaseForTenant('John Doe').should('exist');
        cy.verifyEmailSent('john.doe@example.com').should('contain', 'Registration Confirmation');
    });

    it('should alert on duplicate registration', () => {
        tenantPage.enterName('John Doe');
        tenantPage.enterContact('john.doe@example.com', '123-456-7890');
        tenantPage.submitForm();
        tenantPage.submitForm();
        tenantPage.getAlert().should('contain', 'Duplicate entry');
    });

    it('should prompt for incomplete submissions', () => {
        tenantPage.enterName('');
        tenantPage.submitForm();
        tenantPage.getAlert().should('contain', 'Complete all required fields');
    });

    it('should reject invalid data formats', () => {
        tenantPage.enterContact('invalid-email', 'invalid-phone');
        tenantPage.submitForm();
        tenantPage.getAlert().should('contain', 'Invalid format');
    });

    it('should allow tenants to update registration details', () => {
        tenantPage.enterName('John Doe');
        tenantPage.enterContact('john.doe@example.com', '123-456-7890');
        tenantPage.submitForm();
        tenantPage.updateDetails('John Smith', 'john.smith@example.com', '987-654-3210');
        cy.checkDatabaseForTenant('John Smith').should('exist');
    });

    it('should handle high volume of registration requests', () => {
        for(let i=0; i<100; i++) {
            tenantPage.enterName(`Tenant ${i}`);
            tenantPage.enterContact(`tenant${i}@example.com`, `123-456-78${i}`);
            tenantPage.submitForm();
        }
        cy.checkDatabaseForTenant('Tenant 99').should('exist');
    });

    it('should manage registration data securely', () => {
        cy.checkDataEncryption().should('be.true');
    });

    it('should generate reports on tenant registrations', () => {
        cy.generateRegistrationReport().should('contain', 'Tenant Registration Report');
    });

    it('should alert administrators of registration issues', () => {
        cy.triggerRegistrationError();
        cy.checkAdminAlerts().should('contain', 'Registration Error');
    });

    it('should integrate registration data with lease management', () => {
        cy.checkLeaseIntegration().should('be.true');
    });
});