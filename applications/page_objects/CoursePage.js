class CoursePage {
    navigateToCourses() {
        cy.get('.courses-nav').click();
    }

    selectCourse(courseId) {
        cy.get(`.course-id-${courseId}`).click();
    }

    verifyCourseDetailsDisplayed(courseId) {
        cy.get('.course-details').should('contain', courseId);
    }

    selectLanguage(language) {
        cy.get('.language-selector').click();
        cy.get(`.language-option-${language}`).click();
    }

    verifyContentLanguage(language) {
        cy.get('.course-content').should('have.attr', 'lang', language);
    }

    attemptToSelectUnavailableLanguage() {
        cy.get('.language-selector').click();
        cy.get('.language-option-unavailable').click();
    }

    verifyUnavailableLanguageMessage() {
        cy.get('.error-message').should('contain', 'Language not available');
    }

    verifyRetainedLanguagePreference() {
        cy.get('.course-content').should('have.attr', 'lang', 'Spanish');
    }

    verifyUniformLanguageAcrossSections() {
        cy.get('.section-content').each(section => {
            cy.wrap(section).should('have.attr', 'lang', 'Spanish');
        });
    }

    verifyAssessmentLanguageSupport() {
        cy.get('.assessment-content').should('have.attr', 'lang', 'Spanish');
    }

    changeLanguageDuringQuiz(language) {
        cy.get('.quiz-language-selector').click();
        cy.get(`.quiz-language-option-${language}`).click();
    }

    verifyQuizContentLanguage(language) {
        cy.get('.quiz-content').should('have.attr', 'lang', language);
    }

    verifyUserProgressUnaffected() {
        cy.get('.user-progress').should('not.have.attr', 'lang-change-error');
    }

    verifyAccessibilityForMultilingualContent() {
        cy.get('.course-content').should('have.attr', 'aria-label');
    }

    verifyTranslationOptionsForUserContent() {
        cy.get('.user-content').should('contain', 'Translate options available');
    }
}

export default CoursePage;