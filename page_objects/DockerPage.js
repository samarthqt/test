class DockerPage {
  navigateToSourceCodeDirectory() {
    return cy.exec('cd /path/to/source/code');
  }

  runCommand(command) {
    return cy.exec(command);
  }

  verifyDirectoryPath(expectedPath) {
    return this.navigateToSourceCodeDirectory()
      .its('stdout').should('contain', expectedPath);
  }

  verifyBuildLogs() {
    return this.runCommand('docker build -t myapp:latest .')
      .its('stdout').should('contain', 'Successfully built');
  }

  verifyImageListed(imageName) {
    return this.runCommand('docker images')
      .its('stdout').should('contain', imageName);
  }

  inspectImage(imageName) {
    return this.runCommand(`docker inspect ${imageName}`)
      .its('stdout').should('contain', 'Config');
  }

  verifyContainerLogs(containerId) {
    return this.runCommand(`docker logs ${containerId}`)
      .its('stdout').should('not.contain', 'error');
  }

  stopContainer(containerId) {
    return this.runCommand(`docker stop ${containerId}`)
      .its('stdout').should('not.contain', 'error');
  }

  removeContainer(containerId) {
    return this.runCommand(`docker rm ${containerId}`)
      .its('stdout').should('not.contain', 'error');
  }

  removeImage(imageName) {
    return this.runCommand(`docker rmi ${imageName}`)
      .its('stdout').should('not.contain', 'error');
  }

  verifyImageNotListed(imageName) {
    return this.runCommand('docker images')
      .its('stdout').should('not.contain', imageName);
  }

  cleanUpDanglingImages() {
    return this.runCommand('docker image prune -f')
      .its('stdout').should('contain', 'Total reclaimed space');
  }
}

export default DockerPage;