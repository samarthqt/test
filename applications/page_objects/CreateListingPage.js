class CreateListingPage {
  visit() {
    cy.visit('/create-listing');
  }

  enterPropertyName(name) {
    cy.get('#propertyName').type(name);
  }

  enterLocation(location) {
    cy.get('#location').type(location);
  }

  enterPrice(price) {
    cy.get('#price').type(price);
  }

  enterDescription(description) {
    cy.get('#description').type(description);
  }

  uploadImages(images) {
    images.forEach(image => {
      cy.get('#uploadImage').attachFile(image);
    });
  }

  selectChannels(channels) {
    channels.forEach(channel => {
      cy.get(`#${channel}`).click();
    });
  }

  publish() {
    cy.get('#publishButton').click();
  }
}

export default CreateListingPage;