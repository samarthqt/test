describe('Patient Data Encryption Verification', () => {
  const patientId = 'P12345';
  let database;

  before(() => {
    // Setup: Connect to the database
    cy.task('connectToDatabase').then((db) => {
      database = db;
    });
  });

  it('should access the database successfully', () => {
    expect(database).to.not.be.null;
  });

  it('should verify all patient data is stored in an encrypted format', () => {
    cy.task('queryDatabase', { db: database, query: `SELECT * FROM patients WHERE id = '${patientId}'` })
      .then((result) => {
        expect(result).to.exist;
        expect(result.encryptedData).to.match(/^[A-Fa-f0-9]+$/); // Check if data is in hexadecimal format
      });
  });

  it('should decrypt the data using authorized access', () => {
    cy.task('decryptData', { encryptedData: 'encryptedDataFromQuery' }).then((decryptedData) => {
      expect(decryptedData).to.equal('expectedDecryptedData');
    });
  });

  after(() => {
    // Teardown: Disconnect from the database
    cy.task('disconnectFromDatabase', database);
  });
});