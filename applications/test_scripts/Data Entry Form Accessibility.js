describe('Data Entry Form Accessibility', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const dataManagementPage = new DataManagementPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should log in with clinician credentials and access data entry forms', () => {
    loginPage.login('user1', 'pass123');
    homePage.verifyHomePage();
    homePage.navigateToDataManagement();
    dataManagementPage.verifyDataManagementPage();
    dataManagementPage.selectDataEntryForms();
    dataManagementPage.verifyDataEntryFormsSection();
  });
});