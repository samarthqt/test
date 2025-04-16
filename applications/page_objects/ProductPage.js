class ProductPage {
    visit() {
        cy.visit('/product-page');
    }

    getProductImages() {
        return cy.get('.product-image');
    }
}

class ErrorLogPage {
    visit() {
        cy.visit('/admin/error-logs');
    }

    getErrorLogs() {
        return cy.get('.error-log');
    }
}

module.exports = { ProductPage, ErrorLogPage };