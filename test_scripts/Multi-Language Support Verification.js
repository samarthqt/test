describe('Multi-Language Support Verification', () => {
  const languages = ['Spanish', 'French', 'English'];
  const pages = ['homepage', 'product page', 'checkout page'];
  let loginPage, languageSettingsPage, productPage, checkoutPage;

  before(() => {
    loginPage = new LoginPage();
    languageSettingsPage = new LanguageSettingsPage();
    productPage = new ProductPage();
    checkoutPage = new CheckoutPage();
  });

  it('should log in with valid credentials', () => {
    cy.visit('/login');
    loginPage.login('validUser', 'validPassword');
    cy.url().should('include', '/home');
  });

  it('should navigate to language settings', () => {
    languageSettingsPage.navigateTo();
    cy.url().should('include', '/language-settings');
  });

  languages.forEach(language => {
    it(`should select ${language} and verify translations`, () => {
      languageSettingsPage.selectLanguage(language);

      pages.forEach(page => {
        cy.visit(`/${page.replace(' ', '-')}`);
        cy.get('body').should('contain.text', getExpectedText(language, page));
      });
    });
  });

  it('should log out', () => {
    loginPage.logout();
    cy.url().should('include', '/login');
  });

  it('should verify language preference is saved', () => {
    cy.visit('/login');
    loginPage.login('validUser', 'validPassword');
    languageSettingsPage.verifySavedLanguagePreference('English');
  });

  it('should verify language translation for error messages', () => {
    cy.visit('/error-page');
    cy.get('.error-message').should('contain.text', getExpectedErrorMessage('English'));
  });

  it('should verify language translation for email notifications', () => {
    cy.task('getLastEmail').then(email => {
      expect(email.subject).to.contain(getExpectedEmailSubject('English'));
    });
  });

  function getExpectedText(language, page) {
    const translations = {
      'Spanish': {
        'homepage': 'Inicio',
        'product page': 'Página de producto',
        'checkout page': 'Página de pago'
      },
      'French': {
        'homepage': 'Accueil',
        'product page': 'Page produit',
        'checkout page': 'Page de paiement'
      },
      'English': {
        'homepage': 'Home',
        'product page': 'Product Page',
        'checkout page': 'Checkout Page'
      }
    };
    return translations[language][page];
  }

  function getExpectedErrorMessage(language) {
    const errorMessages = {
      'Spanish': 'Error',
      'French': 'Erreur',
      'English': 'Error'
    };
    return errorMessages[language];
  }

  function getExpectedEmailSubject(language) {
    const emailSubjects = {
      'Spanish': 'Asunto del correo',
      'French': 'Sujet de l'email',
      'English': 'Email Subject'
    };
    return emailSubjects[language];
  }
});