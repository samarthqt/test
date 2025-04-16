describe('Property Detail Page Tests', () => {
  const propertyId = '12345';
  const invalidPropertyId = '99999';
  const missingImagePropertyId = '12346';
  const missingDescriptionPropertyId = '12347';
  const missingPricePropertyId = '12348';
  const missingAmenitiesPropertyId = '12349';

  beforeEach(() => {
    cy.visit('/property-listing');
  });

  it('should display property detail page with images, description, price, and amenities', () => {
    cy.get(`[data-property-id="${propertyId}"]`).click();
    cy.url().should('include', `/property/${propertyId}`);

    cy.get('.property-image').should('have.attr', 'src', 'image_url.jpg');
    cy.get('.property-description').should('contain', 'Spacious 3-bedroom apartment');
    cy.get('.property-price').should('contain', '$250,000');
    cy.get('.property-amenities').should('contain', 'Pool, Gym');
  });

  it('should refresh the property detail page and retain data', () => {
    cy.get(`[data-property-id="${propertyId}"]`).click();
    cy.reload();
    cy.get('.property-image').should('have.attr', 'src', 'image_url.jpg');
    cy.get('.property-description').should('contain', 'Spacious 3-bedroom apartment');
    cy.get('.property-price').should('contain', '$250,000');
    cy.get('.property-amenities').should('contain', 'Pool, Gym');
  });

  it('should display error message for invalid property ID', () => {
    cy.visit(`/property/${invalidPropertyId}`);
    cy.get('.error-message').should('contain', 'Invalid property ID');
  });

  it('should display placeholder image for missing images', () => {
    cy.visit(`/property/${missingImagePropertyId}`);
    cy.get('.property-image').should('have.attr', 'src', 'placeholder.jpg');
  });

  it('should display error message for missing description', () => {
    cy.visit(`/property/${missingDescriptionPropertyId}`);
    cy.get('.error-message').should('contain', 'Missing description');
  });

  it('should display error message for missing price', () => {
    cy.visit(`/property/${missingPricePropertyId}`);
    cy.get('.error-message').should('contain', 'Missing price');
  });

  it('should display error message for missing amenities', () => {
    cy.visit(`/property/${missingAmenitiesPropertyId}`);
    cy.get('.error-message').should('contain', 'Missing amenities');
  });
});