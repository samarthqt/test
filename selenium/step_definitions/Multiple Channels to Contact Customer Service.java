

@Then("customer service contact forms or live chat should include measures to prevent spam or automated abuse, such as CAPTCHA")
public void contactOptionsShouldBeProtectedFromSpam() {
    verifySpamProtectionMeasures();
}

@When("I attempt to print the customer service contact information page")
public void attemptToPrintContactInformation() {
    initiatePrintContactInformation();
}

@Then("the contact information should be formatted correctly for printing")
public void contactInformationShouldBeFormattedForPrinting() {
    verifyPrintFormatOfContactInformation();
}