describe('Dashboard Customization with Invalid Widgets', () => {
  const dashboardPage = new DashboardPage();

  beforeEach(() => {
    // Assume user is already logged in
    cy.visit('/course-dashboard');
  });

  it('should navigate to the Course Dashboard section', () => {
    dashboardPage.verifyOnDashboard();
  });

  it('should display customization options when Customize is selected', () => {
    dashboardPage.clickCustomize();
    dashboardPage.verifyCustomizationOptionsDisplayed();
  });

  it('should prevent adding an invalid widget and display an error message', () => {
    dashboardPage.clickCustomize();
    dashboardPage.addInvalidWidget('Widget Z');
    dashboardPage.verifyErrorMessageDisplayed();
  });

  it('should ensure the dashboard remains unchanged after attempting to add an invalid widget', () => {
    dashboardPage.verifyDashboardUnchanged();
  });
});