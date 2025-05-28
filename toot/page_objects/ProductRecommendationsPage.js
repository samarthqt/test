import { login, register, loadHistory, loadSimilarBehavior, interactWith, optOut } from '../support/actions'; 
class ProductRecommendationsPage { 
static login() { 
login(); 
} 

static registerNewUser() { 
register(); 
} 

static loadUserHistory() { 
loadHistory(); 
} 

static loadSimilarUserBehavior() { 
loadSimilarBehavior(); 
} 

static visitHomepage() { 
cy.visit('/homepage'); 
} 

static viewPersonalizedRecommendations() { 
cy.visit('/recommendations'); 
} 

static viewProductDetailPage() { 
cy.visit('/product-detail'); 
} 

static verifyPersonalizedRecommendations() { 
cy.get('.recommendations').should('be.visible'); 
} 

static verifyRecommendationsBasedOnBehavior() { 
cy.get('.recommendations').should('contain', 'based on your behavior'); 
} 

static verifyNoRecommendations() { 
cy.get('.recommendations').should('not.exist'); 
} 

static verifyExploreProductsMessage() { 
cy.get('.explore-message').should('be.visible'); 
} 

static interactWithProduct() { 
interactWith('product'); 
} 

static verifyUpdatedRecommendations() { 
cy.get('.recommendations').should('contain', 'updated'); 
} 

static scrollDownPage() { 
cy.scrollTo('bottom'); 
} 

static verifyAdditionalRecommendations() { 
cy.get('.additional-recommendations').should('be.visible'); 
} 

static verifyRelatedRecommendations() { 
cy.get('.related-recommendations').should('contain', 'related'); 
} 

static verifySimilarBehaviorRecommendations() { 
cy.get('.recommendations').should('contain', 'similar behavior'); 
} 

static optOutPersonalizedRecommendations() { 
optOut(); 
} 

static verifyNoPersonalizedRecommendations() { 
cy.get('.personalized-recommendations').should('not.exist'); 
} 

static verifyOptInOption() { 
cy.get('.opt-in').should('be.visible'); 
} 
} 

export default ProductRecommendationsPage;