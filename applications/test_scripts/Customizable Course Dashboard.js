describe('Customizable Course Dashboard', () => {
  const courseDashboardPage = new CourseDashboardPage();

  beforeEach(() => {
    // Assuming user is already logged in
    cy.visit('/course-dashboard');
  });

  it('should allow the user to customize the dashboard view by rearranging widgets', () => {
    // Navigate to Course Dashboard
    courseDashboardPage.verifyOnDashboard();

    // Select Customize Option
    courseDashboardPage.clickCustomizeButton();
    courseDashboardPage.verifyCustomizationOptionsDisplayed();

    // Drag and Drop Widgets
    courseDashboardPage.rearrangeWidgets();
    courseDashboardPage.verifyWidgetsRearranged();

    // Save New Dashboard Layout
    courseDashboardPage.saveDashboardLayout();
    courseDashboardPage.verifyLayoutSaved();

    // Refresh Page to Ensure Layout Persistence
    cy.reload();
    courseDashboardPage.verifyLayoutPersistence();
  });
});