import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.pageobjects.RegistrationPage;
import static org.testng.Assert.assertEquals;

public class RegistrationTest {

    RegistrationPage registrationPage;

    @BeforeMethod
    public void setUp() {
        registrationPage = new RegistrationPage();
        registrationPage.navigateToRegistrationPage();
    }

    @Test
    public void testSuccessfulRegistration() {
        registrationPage.enterFirstName("John");
        registrationPage.enterLastName("Doe");
        registrationPage.enterEmail("john.doe@test.com");
        registrationPage.enterPassword("Pass@123");
        registrationPage.enterConfirmPassword("Pass@123");
        registrationPage.clickRegisterButton();
        registrationPage.verifyRegistrationSuccess("Registration successful!");
    }

    @AfterMethod
    public void tearDown() {
        // Code to close browser or clean up
    }
}