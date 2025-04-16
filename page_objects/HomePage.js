class HomePage {
  verifyHomePageLoad() {
    cy.get('body').should('be.visible');
  }

  verifyLayoutAlignment() {
    cy.get('body').should('not.have.css', 'overflow-x', 'scroll');
  }

  checkNavigationMenu() {
    cy.get('.hamburger-icon').click();
  }

  verifyNavigationMenu() {
    cy.get('.nav-menu').should('be.visible');
  }

  checkImages() {
    cy.get('img').each(($img) => {
      cy.wrap($img).should('be.visible');
    });
  }

  verifyImagesResponsiveness() {
    cy.get('img').each(($img) => {
      cy.wrap($img).should('have.css', 'width').and('match', /\d+px/);
    });
  }

  scrollToFooter() {
    cy.scrollTo('bottom');
  }

  verifyFooterVisibility() {
    cy.get('footer').should('be.visible');
  }

  navigateToSecondaryPage() {
    cy.get('a.secondary-page-link').click();
  }

  interactWithApplication() {
    cy.get('button').click();
  }

  verifyPerformance() {
    cy.window().its('performance').should('be.ok');
  }

  verifyLandscapeLayout() {
    cy.get('body').should('not.have.css', 'overflow', 'hidden');
  }

  login() {
    cy.get('input[name="username"]').type('user');
    cy.get('input[name="password"]').type('password');
    cy.get('button[type="submit"]').click();
  }

  logout() {
    cy.get('button.logout').click();
  }

  verifyLogout() {
    cy.url().should('include', '/login');
  }

  verifyLoginPage() {
    cy.get('form.login-form').should('be.visible');
  }

  checkAccessibilityFeatures() {
    cy.get('body').should('have.attr', 'aria-label');
  }

  verifyAccessibilityFeatures() {
    cy.get('body').should('have.attr', 'aria-label');
  }

  useSearchFunctionality() {
    cy.get('input.search-bar').type('query{enter}');
  }

  verifySearchFunctionality() {
    cy.get('.search-results').should('be.visible');
  }

  interactWithButtons() {
    cy.get('button').each(($btn) => {
      cy.wrap($btn).click();
    });
  }

  verifyTouchResponsiveness() {
    cy.get('button').each(($btn) => {
      cy.wrap($btn).should('be.focused');
    });
  }

  playVideo() {
    cy.get('video').click();
  }

  verifyVideoResponsiveness() {
    cy.get('video').should('have.prop', 'paused', false);
  }
}

class SecondaryPage {
  verifyPageLoad() {
    cy.get('body').should('be.visible');
  }

  checkFormElements() {
    cy.get('form').should('be.visible');
  }

  verifyFormElements() {
    cy.get('form input').each(($input) => {
      cy.wrap($input).should('be.visible');
    });
  }
}

export default HomePage;