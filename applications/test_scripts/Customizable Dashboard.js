describe('Customizable Dashboard Test Suite', () => {
  before(() => {
    // Assuming user is already logged in
    cy.visit('/dashboard-customization');
  });

  it('should navigate to the dashboard customization page', () => {
    cy.url().should('include', '/dashboard-customization');
    cy.get('.dashboard-customization-page').should('be.visible');
  });

  it('should select desired widgets', () => {
    const widgets = ['Sales', 'Inventory', 'Customer Feedback'];
    widgets.forEach(widget => {
      cy.get(`input[value="${widget}"]`).check();
    });
    widgets.forEach(widget => {
      cy.get('.selected-widgets').should('contain', widget);
    });
  });

  it('should choose a preferred layout option', () => {
    const layoutOption = 'Grid';
    cy.get(`input[value="${layoutOption}"]`).check();
    cy.get('.dashboard-layout').should('have.class', layoutOption.toLowerCase());
  });

  it('should select service statistics to be displayed', () => {
    const statistics = ['Monthly Sales', 'Yearly Growth'];
    statistics.forEach(stat => {
      cy.get(`input[value="${stat}"]`).check();
    });
    statistics.forEach(stat => {
      cy.get('.selected-statistics').should('contain', stat);
    });
  });

  it('should save the customization settings', () => {
    cy.get('.save-settings-button').click();
    cy.get('.notification').should('contain', 'Customization settings saved successfully');
  });

  it('should retain customized settings after page refresh', () => {
    cy.reload();
    cy.get('.selected-widgets').should('contain', 'Sales');
    cy.get('.selected-widgets').should('contain', 'Inventory');
    cy.get('.selected-widgets').should('contain', 'Customer Feedback');
    cy.get('.dashboard-layout').should('have.class', 'grid');
    cy.get('.selected-statistics').should('contain', 'Monthly Sales');
    cy.get('.selected-statistics').should('contain', 'Yearly Growth');
  });
});