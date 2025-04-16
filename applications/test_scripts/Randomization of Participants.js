describe('TC-829 460 Randomization of Participants', () => {
    const loginPage = new LoginPage();
    const dashboardPage = new DashboardPage();
    const randomizationPage = new RandomizationPage();

    before(() => {
        cy.visit('/');
    });

    it('should log in to the trial management portal', () => {
        loginPage.login('validUser', 'validPassword');
        dashboardPage.verifyDashboard();
    });

    it('should navigate to the Randomization section', () => {
        dashboardPage.gotoRandomizationSection();
        randomizationPage.verifyRandomizationSection();
    });

    it('should select the study ID for randomization', () => {
        randomizationPage.selectStudyID('S001');
        randomizationPage.verifyStudyDetails(['P001', 'P002', 'P003']);
    });

    it('should define the randomization criteria', () => {
        randomizationPage.defineCriteria({ age: '18-65', priorTreatment: false });
        randomizationPage.verifyCriteriaAccepted();
    });

    it('should execute the randomization process', () => {
        randomizationPage.executeRandomization();
        randomizationPage.verifyRandomizationSuccess();
    });

    it('should verify the group assignments for each participant', () => {
        randomizationPage.verifyGroupAssignments(['P001', 'P002', 'P003']);
    });

    it('should ensure the randomization results can be exported', () => {
        randomizationPage.exportResults();
        randomizationPage.verifyExportSuccess();
    });
});