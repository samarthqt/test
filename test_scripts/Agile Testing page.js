describe('Agile Testing Page Test Suite', () => {
  const agileTestingPage = new AgileTestingPage();

  before(() => {
    cy.visit('http://www.qasymphony.com/platform.html');
  });

  it('should navigate to Agile Testing sub-menu', () => {
    agileTestingPage.clickAgileTestingSubMenu();
    cy.url().should('include', '/agile-testing');
  });

  it('should call Get Free Trial', () => {
    agileTestingPage.clickGetFreeTrial();
    cy.url().should('include', '/free-trial');
  });

  it('should click Learn More on Scale Agile section', () => {
    agileTestingPage.clickScaleAgileLearnMore();
    cy.url().should('include', '/scale-agile');
  });

  it('should click Learn More on eXplorer Testing section', () => {
    agileTestingPage.clickExplorerTestingLearnMore();
    cy.url().should('include', '/explorer-testing');
  });

  it('should click Learn More on Distributed Team section', () => {
    agileTestingPage.clickDistributedTeamLearnMore();
    cy.url().should('include', '/distributed-team');
  });
});