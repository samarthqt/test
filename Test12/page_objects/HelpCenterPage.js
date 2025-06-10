import { login, logout } from '../support/authentication'; 
class HelpCenterPage { 
 static visitWebPlatform() { 
 cy.visit('/web-platform'); 
 } 
 
 static visitMobilePlatform() { 
 cy.visit('/mobile-platform'); 
 } 
 
 static visitHelpCenter() { 
 cy.visit('/help-center'); 
 } 
 
 static visitFAQsSection() { 
 cy.visit('/help-center/faqs'); 
 } 
 
 static visitTroubleshootingGuidesSection() { 
 cy.visit('/help-center/troubleshooting'); 
 } 
 
 static authenticateUser() { 
 login(); 
 } 
 
 static deauthenticateUser() { 
 logout(); 
 } 
 
 static navigateToHelpCenter() { 
 cy.get('#helpCenterLink').click(); 
 } 
 
 static searchFAQs(keyword) { 
 cy.get('#searchInput').type(keyword); 
 cy.get('#searchButton').click(); 
 } 
 
 static viewArticle() { 
 cy.get('.article').click(); 
 } 
 
 static openTroubleshootingGuide() { 
 cy.get('.troubleshooting-guide').click(); 
 } 
 
 static provideFeedback(feedback) { 
 cy.get('#feedbackInput').type(feedback); 
 cy.get('#submitFeedback').click(); 
 } 
 
 static verifyHelpCenterDisplayed() { 
 cy.get('#helpCenter').should('be.visible'); 
 } 
 
 static verifyCategoryContentDisplayed() { 
 cy.get('.category-content').should('be.visible'); 
 } 
 
 static verifyFAQsDisplayed(keyword) { 
 cy.get('.faq').contains(keyword).should('be.visible'); 
 } 
 
 static verifyTroubleshootingInstructionsDisplayed() { 
 cy.get('.instructions').should('be.visible'); 
 } 
 
 static verifyContentUpToDateAndAccurate() { 
 cy.get('.content').should('contain', '2023'); 
 } 
 
 static verifyFeedbackSubmitted() { 
 cy.get('.feedback-success').should('be.visible'); 
 } 
 
 static verifyContentAccessible() { 
 cy.get('.accessible-content').should('be.visible'); 
 } 
 
 static verifyInteractionLogged() { 
 cy.get('.interaction-log').should('exist'); 
 } 
} 

export default HelpCenterPage;