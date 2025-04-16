describe('TC-821 401 Generate Property Inspection Reports', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const propertyManagementPage = new PropertyManagementPage();
  const inspectionsPage = new InspectionsPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in as a Property Manager', () => {
    loginPage.login('propertyManager', 'password');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to Property Management module', () => {
    dashboardPage.goToPropertyManagement();
    propertyManagementPage.verifyPage();
  });

  it('should select the property with ID 56789', () => {
    propertyManagementPage.selectProperty('56789');
    propertyManagementPage.verifyPropertyDetails('56789');
  });

  it('should access the Inspections section', () => {
    propertyManagementPage.goToInspections();
    inspectionsPage.verifyInspectionsPage();
  });

  it('should initiate a new inspection report', () => {
    inspectionsPage.startNewInspection();
    inspectionsPage.verifyInspectionTemplate();
  });

  it('should enter inspection details', () => {
    inspectionsPage.enterInspectionDetails('01/01/2024', 'John Doe', 'Inspection comments');
    inspectionsPage.verifyInspectionDetails();
  });

  it('should attach images to the inspection', () => {
    inspectionsPage.attachImages(['image1.jpg', 'image2.jpg']);
    inspectionsPage.verifyImagesAttached();
  });

  it('should save the inspection report', () => {
    inspectionsPage.saveInspection();
    inspectionsPage.verifyInspectionSaved();
  });

  it('should generate the final inspection report document', () => {
    inspectionsPage.generateFinalReport();
    inspectionsPage.verifyReportGenerated();
  });

  after(() => {
    dashboardPage.logout();
    loginPage.verifyLoggedOut();
  });
});