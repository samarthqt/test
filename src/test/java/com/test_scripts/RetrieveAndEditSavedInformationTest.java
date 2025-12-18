package com.cucumber.test_scripts;

import com.page_objects.UserProfilePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.framework.reusable.WebReusableComponents;

public class RetrieveAndEditSavedInformationTest {

    private UserProfilePage userProfilePage;

    @BeforeMethod
    public void setUp() {
        userProfilePage = new UserProfilePage();
        userProfilePage.navigateToUserProfile();
    }

    @Test
    public void testRetrieveAndEditSavedInformation() {
        userProfilePage.accessSavedInformationSection();
        userProfilePage.editShippingAddress("New Address Line", "New City", "New State", "New PostalCode", "New Country");
        userProfilePage.editBillingAddress("New Billing Address Line", "New Billing City", "New Billing State", "New Billing PostalCode", "New Billing Country");
        userProfilePage.saveChanges();
        userProfilePage.verifyChangesSaved();
        userProfilePage.logout();
        userProfilePage.login();
        userProfilePage.verifyUpdatedInformation();
    }

    @AfterMethod
    public void tearDown() {
        userProfilePage.logout();
    }
}