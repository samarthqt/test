import 'cypress-file-upload';
class FileUploadPage {
  static navigateToUploadSection() {
    cy.get('#fileUploadSection').click();
  }

  static verifyUploadSectionDisplayed() {
    cy.get('#uploadArea').should('be.visible');
  }

  static selectFile(fileName) {
    cy.get('#fileInput').attachFile(fileName);
  }

  static initiateUpload() {
    cy.get('#uploadButton').click();
  }

  static verifyUploadSuccess(fileName) {
    cy.get('#uploadStatus').should('contain', `${fileName} uploaded successfully`);
  }

  static verifyFileIntegrity(fileName) {
    cy.get('#fileIntegrity').should('contain', `Integrity of ${fileName} confirmed`);
  }

  static uploadMultipleFiles(fileNames) {
    fileNames.forEach(fileName => {
      this.selectFile(fileName);
      this.initiateUpload();
      this.verifyUploadSuccess(fileName);
      this.verifyFileIntegrity(fileName);
    });
  }

  static verifyMultipleFilesUploaded(fileNames) {
    fileNames.forEach(fileName => {
      this.verifyUploadSuccess(fileName);
      this.verifyFileIntegrity(fileName);
    });
  }

  static uploadFiles(fileNames) {
    this.uploadMultipleFiles(fileNames);
    this.verifyMultipleFilesUploaded(fileNames);
  }

  static verifyUploadCompletion() {
    cy.get('#uploadStatus').should('contain', 'All files uploaded successfully');
  }

  static interruptUpload() {
    cy.get('#interruptButton').click();
    cy.get('#uploadStatus').should('contain', 'Upload interrupted');
  }

  static uploadLargeFilesConcurrently(fileNames) {
    cy.wrap(fileNames).each(fileName => {
      this.selectFile(fileName);
      this.initiateUpload();
    });
    this.verifyUploadCompletion();
  }
}

export default FileUploadPage;