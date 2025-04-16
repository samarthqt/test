describe('Landlord Property Marketing', () => {
  const propertyDetails = {
    name: 'Sunny Apartment',
    location: 'Downtown',
    price: '$1200/month',
    description: '2-bedroom apartment with a sunny balcony',
    images: ['image1.jpg', 'image2.jpg'],
    channels: ['Facebook', 'Twitter']
  };

  before(() => {
    cy.visit('/login');
    cy.get('#username').type('landlord');
    cy.get('#password').type('password');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('should allow landlords to create and market property listings', () => {
    cy.get('#createListingButton').click();
    cy.url().should('include', '/create-listing');

    cy.get('#propertyName').type(propertyDetails.name);
    cy.get('#location').type(propertyDetails.location);
    cy.get('#price').type(propertyDetails.price);
    cy.get('#description').type(propertyDetails.description);

    propertyDetails.images.forEach(image => {
      cy.get('#uploadImage').attachFile(image);
    });

    propertyDetails.channels.forEach(channel => {
      cy.get(`#${channel}`).click();
    });

    cy.get('#publishButton').click();
    cy.get('.confirmationMessage').should('be.visible');

    propertyDetails.channels.forEach(channel => {
      cy.visit(`/channel/${channel}`);
      cy.contains(propertyDetails.name).should('be.visible');
    });
  });
});