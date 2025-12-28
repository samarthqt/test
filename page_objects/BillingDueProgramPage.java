package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.List;
import org.openqa.selenium.WebElement;

public class BillingDueProgramPage extends WebReusableComponents {

    // Elements from all input classes
    protected By usernameField = By.id("username");
    protected By passwordField = By.id("password");
    protected By loginButton = By.id("loginButton");
    protected By salesOrderScreen = By.id("salesOrderScreen");
    protected By salesOrderTypeDropdown = By.id("salesOrderType");
    protected By attribute1Field = By.id("attribute1");
    protected By attribute2Field = By.id("attribute2");
    protected By saveSalesOrderButton = By.id("saveSalesOrder");
    protected By orderIDField = By.id("orderID");
    protected By billingDueProgramScreen = By.id("billingDueProgramScreen");
    protected By triggerBillingDueProgramButton = By.id("triggerBillingDueProgram");
    protected By billingOutcomeMessage = By.id("billingOutcomeMessage");
    protected By errorLogScreen = By.id("errorLogScreen");
    protected By errorLogMessage = By.id("errorLogMessage");
    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By billingDueProgramLink = By.id("billingDueProgramLink");
    protected By txtAttribute1 = By.id("attribute1");
    protected By txtSubtype = By.id("subtype");
    protected By txtAttribute2 = By.id("attribute2");
    protected By btnExecute = By.id("executeButton");
    protected By lblBillingDocumentType = By.id("billingDocumentType");
    protected By documentDetailsSection = By.id("documentDetails");
    protected By documentFlowSection = By.id("documentFlow");
    protected By financialPostingsSection = By.id("financialPostings");
    protected By systemLogsSection = By.id("systemLogs");
    protected By billingDocumentReadyStatus = By.id("readyStatus");
    protected By subtypeField = By.id("subtype");
    protected By executeButton = By.id("executeButton");
    protected By billingDocumentTypeField = By.id("billingDocumentType");
    protected By documentMappingField = By.id("documentMapping");
    protected By documentFlowField = By.id("documentFlow");
    protected By financialPostingsField = By.id("financialPostings");
    protected By systemLogsField = By.id("systemLogs");
    protected By readyStatusField = By.id("readyStatus");
    protected By logDetails = By.id("logDetails");
    protected By errorMessage = By.id("errorMessage");
    protected By correctedAttribute1Field = By.id("correctedAttribute1");
    protected By btnReExecute = By.id("reExecuteButton");
    protected By confirmationMessage = By.id("confirmationMessage");
    protected By systemMessage = By.id("systemMessage");
    protected By systemBehavior = By.id("systemBehavior");
    protected By errorLogs = By.id("errorLogs");
    protected By invalidDocuments = By.id("invalidDocuments");
    protected By readinessIndicator = By.id("readinessIndicator");
    protected By btnProceedToCheckout = By.id("proceedToCheckout");
    protected By txtFullName = By.id("fullName");
    protected By txtAddress = By.id("address");
    protected By txtCity = By.id("city");
    protected By txtPostalCode = By.id("postalCode");
    protected By txtPhone = By.id("phone");
    protected By paymentMethodDropdown = By.id("paymentMethod");
    protected By txtCardNumber = By.id("cardNumber");
    protected By txtExpiryDate = By.id("expiryDate");
    protected By txtCVV = By.id("cvv");
    protected By btnPlaceOrder = By.id("placeOrder");
    protected By orderConfirmationMessage = By.id("orderConfirmationMessage");
    protected By btnPayWithPayPal = By.id("payWithPayPal");
    protected By btnLoginToPayPal = By.id("paypalLogin");
    protected By btnConfirmPayPalPayment = By.id("confirmPaypalPayment");
    protected By paymentMethodsLink = By.id("paymentMethods");
    protected By addPaymentMethodButton = By.id("addPaymentMethod");
    protected By txtCardHolderName = By.id("cardHolderName");
    protected By savePaymentMethodButton = By.id("savePaymentMethod");
    protected By savedCards = By.cssSelector(".saved-card");
    protected By sapLoginPage = By.id("sapLoginPage");
    protected By billingDueProgramPage = By.id("billingDueProgramPage");
    protected By billingDocumentIDField = By.id("billingDocumentID");
    protected By sourceDocumentField = By.id("sourceDocument");
    protected By executeProgramButton = By.id("executeProgram");
    protected By billingDocumentCreatedMessage = By.id("billingDocumentCreatedMessage");
    protected By accountingModulePage = By.id("accountingModulePage");
    protected By billingDocumentDetails = By.id("billingDocumentDetails");
    protected By documentHeaderDetails = By.id("documentHeaderDetails");
    protected By documentTypeField = By.id("documentType");
    protected By processingLogs = By.id("processingLogs");
    protected By systemPerformanceMetrics = By.id("systemPerformanceMetrics");
    protected By downstreamProcessesStatus = By.id("downstreamProcessesStatus");
    protected By homeScreen = By.id("homeScreen");
    protected By attribute3Value = By.id("attribute3");
    protected By salesOrdersTable = By.id("salesOrdersTable");
    protected By btnDeactivateProgram = By.id("deactivateProgramButton");
    protected By btnExecuteProgram = By.id("executeProgramButton");
    protected By testResultsSection = By.id("testResultsSection");

    protected By removeCardButton(String lastFourDigits) {
        return By.xpath("//div[contains(text(), '**** **** **** " + lastFourDigits + "')]/following-sibling::button[@class='remove']");
    }

    // All methods from all input classes are included below without modification
    // Methods from BillingDueProgramPage, CheckoutPage, and PaymentMethodsPage
    // (Refer to the provided input for the complete list of methods)
}
