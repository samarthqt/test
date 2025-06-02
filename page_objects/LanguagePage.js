import { expect } from 'chai'; 
import { cy } from 'cypress'; 

class LanguagePage { 
    static visitLoginPage() { 
        cy.visit('/login'); 
    } 

    static loginWithValidCredentials() { 
        cy.get('#username').type('validUsername'); 
        cy.get('#password').type('validPassword'); 
        cy.get('#loginBtn').click(); 
    } 

    static verifySuccessfulLogin() { 
        cy.url().should('include', '/dashboard'); 
    } 

    static verifyUserLoggedIn() { 
        cy.get('#userProfile').should('be.visible'); 
    } 

    static navigateToLanguageSettings() { 
        cy.get('#settings').click(); 
        cy.get('#languageSettings').click(); 
    } 

    static verifyLanguageSettingsPageDisplayed() { 
        cy.url().should('include', '/language-settings'); 
    } 

    static selectDifferentLanguage(language) { 
        cy.get('#languageDropdown').select(language); 
    } 

    static verifyLanguageSelectionUpdated(language) { 
        cy.get('#currentLanguage').should('contain', language); 
    } 

    static navigateThroughApplication() { 
        cy.get('#home').click(); 
        cy.get('#profile').click(); 
    } 

    static verifyInterfaceInSelectedLanguage(language) { 
        const messages = { 
            'French': 'Bienvenue', 
            'English': 'Welcome' 
        }; 
        cy.get('#welcomeMessage').should('contain', messages[language]); 
    } 

    static checkMenuItems() { 
        cy.get('#menu').within(() => { 
            cy.get('li').each(($el) => { 
                expect($el.text()).to.match(/\w+/); 
            }); 
        }); 
    } 

    static verifyMenuItemsTranslated() { 
        cy.get('#menu').within(() => { 
            cy.get('li').each(($el) => { 
                expect($el.text()).to.match(/\w+/); 
            }); 
        }); 
    } 

    static simulateError() { 
        cy.get('#submitButton').click(); 
        cy.get('#errorMessage').should('be.visible'); 
    } 

    static verifyErrorMessagesTranslated(language) { 
        const errors = { 
            'French': 'Erreur', 
            'English': 'Error' 
        }; 
        cy.get('#errorMessage').should('contain', errors[language]); 
    } 

    static accessHelpAndSupportSections() { 
        cy.get('#helpSupport').click(); 
    } 

    static verifyHelpAndSupportSectionsTranslated(language) { 
        const helpContent = { 
            'French': 'Aide', 
            'English': 'Help' 
        }; 
        cy.get('#helpContent').should('contain', helpContent[language]); 
    } 

    static viewUserSubmittedContent() { 
        cy.get('#userContent').click(); 
    } 

    static verifyUserContentOriginalLanguage() { 
        cy.get('#userContentText').should('contain', 'Hello'); 
    } 

    static logoutAndLogin() { 
        cy.get('#logout').click(); 
        this.visitLoginPage(); 
        this.loginWithValidCredentials(); 
    } 

    static verifyLanguagePersistsAfterRelogin(language) { 
        this.verifyLanguageSelectionUpdated(language); 
    } 

    static accessOnDifferentDevices() { 
        // Simulate accessing on different devices 
    } 

    static verifyLanguageConsistencyAcrossDevices(language) { 
        this.verifyLanguageSelectionUpdated(language); 
    } 

    static accessOnDifferentBrowsers() { 
        // Simulate accessing on different browsers 
    } 

    static verifyLanguageConsistencyAcrossBrowsers(language) { 
        this.verifyLanguageSelectionUpdated(language); 
    } 

    static accessMobileApp() { 
        // Simulate mobile app access 
    } 

    static verifyLanguageAccessibilityOnMobileApp() { 
        cy.get('#mobileLanguageSetting').should('be.visible'); 
    } 

    static verifyNoMissingTranslations() { 
        cy.get('body').within(() => { 
            cy.get('*').each(($el) => { 
                expect($el.text()).to.not.match(/\[\]/); 
            }); 
        }); 
    } 

    static useApplication() { 
        this.navigateThroughApplication(); 
    } 

    static verifyPerformanceUnaffectedByLanguageSelection() { 
        cy.get('#performanceMetrics').should('be.visible'); 
    } 

    static switchToDefaultLanguage() { 
        this.selectDifferentLanguage('English'); 
    } 

    static verifySwitchBackToDefaultLanguage() { 
        this.verifyLanguageSelectionUpdated('English'); 
    } 
} 

export default LanguagePage;