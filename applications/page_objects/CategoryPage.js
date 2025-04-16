class CategoryPage {
  navigateToCategoryManagementPage() {
    cy.visit('/category-management');
  }

  clickAddCategoryButton() {
    cy.get('button').contains('Add Category').click();
  }

  enterCategoryName(name) {
    cy.get('input[name="categoryName"]').clear().type(name);
  }

  saveCategory() {
    cy.get('button').contains('Save').click();
  }

  selectCategory(name) {
    cy.get('.category-list').contains(name).click();
  }

  clickEditButton() {
    cy.get('button').contains('Edit').click();
  }

  clickRemoveButton() {
    cy.get('button').contains('Remove').click();
  }

  verifyCategoryExists(name) {
    cy.get('.category-list').should('contain', name);
  }

  verifyCategoryNotExists(name) {
    cy.get('.category-list').should('not.contain', name);
  }
}