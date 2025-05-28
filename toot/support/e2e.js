import { Before, After } from '@badeball/cypress-cucumber-preprocessor';

Before(() => {
  cy.clearCookies();
  cy.clearLocalStorage();
  cy.visit('/');
});

After(() => {
  console.log('Teardown complete.');
});

export { Before, After };