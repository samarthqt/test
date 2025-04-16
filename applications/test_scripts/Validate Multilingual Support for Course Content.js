describe('Multilingual Support for Course Content', () => {
    const courseId = 'C003';
    const languages = ['English', 'Spanish', 'French'];

    before(() => {
        cy.loginAsStudent();
    });

    it('should display course details for C003', () => {
        cy.navigateToCourses();
        cy.selectCourse(courseId);
        cy.coursePage.verifyCourseDetailsDisplayed(courseId);
    });

    languages.forEach(language => {
        it(`should display course content in ${language}`, () => {
            cy.coursePage.selectLanguage(language);
            cy.coursePage.verifyContentLanguage(language);
        });
    });

    it('should prevent selection of unavailable languages', () => {
        cy.coursePage.attemptToSelectUnavailableLanguage();
        cy.coursePage.verifyUnavailableLanguageMessage();
    });

    it('should retain language selection after re-login', () => {
        cy.logout();
        cy.loginAsStudent();
        cy.coursePage.verifyRetainedLanguagePreference();
    });

    it('should apply language selection across all course sections', () => {
        cy.coursePage.verifyUniformLanguageAcrossSections();
    });

    it('should support multilingual assessments and quizzes', () => {
        cy.coursePage.verifyAssessmentLanguageSupport();
    });

    it('should allow language change during a quiz', () => {
        cy.coursePage.changeLanguageDuringQuiz('French');
        cy.coursePage.verifyQuizContentLanguage('French');
    });

    it('should not affect user progress or scores on language change', () => {
        cy.coursePage.verifyUserProgressUnaffected();
    });

    it('should adhere to accessibility standards for multilingual content', () => {
        cy.coursePage.verifyAccessibilityForMultilingualContent();
    });

    it('should provide options for translating user-generated content', () => {
        cy.coursePage.verifyTranslationOptionsForUserContent();
    });
});