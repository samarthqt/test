describe('Product Category Management', () => {
  const categoryPage = new CategoryPage();

  beforeEach(() => {
    cy.loginAsAdmin();
    categoryPage.navigateToCategoryManagementPage();
  });

  it('should add a new category', () => {
    categoryPage.clickAddCategoryButton();
    categoryPage.enterCategoryName('Home Appliances');
    categoryPage.saveCategory();
    categoryPage.verifyCategoryExists('Home Appliances');
  });

  it('should edit an existing category', () => {
    categoryPage.selectCategory('Electronics');
    categoryPage.clickEditButton();
    categoryPage.enterCategoryName('Consumer Electronics');
    categoryPage.saveCategory();
    categoryPage.verifyCategoryExists('Consumer Electronics');
  });

  it('should remove a category', () => {
    categoryPage.selectCategory('Consumer Electronics');
    categoryPage.clickRemoveButton();
    categoryPage.verifyCategoryNotExists('Consumer Electronics');
  });
});