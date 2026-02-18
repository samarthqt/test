package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class TimeSlotPage extends WebReusableComponents {

    protected By timeSlotList = By.id("timeSlotList");
    protected By selectTimeSlotButton = By.id("selectTimeSlotButton");

    public TimeSlotPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyAvailableTimeSlots() {
        waitUntilElementVisible(timeSlotList, 3);
        Assert.assertTrue(getWebElementList(timeSlotList).size() > 0, "No time slots available.");
    }

    public void viewAvailableTimeSlots() {
        waitUntilElementVisible(timeSlotList, 3);
    }

    public void selectPreferredTimeSlot() {
        waitUntilElementVisible(selectTimeSlotButton, 3);
        clickElement(selectTimeSlotButton);
    }

    public void verifyUnbookedTimeSlots() {
        waitUntilElementVisible(timeSlotList, 3);
        Assert.assertTrue(getWebElementList(timeSlotList).stream().noneMatch(WebElement::isSelected), "Some time slots are already booked.");
    }
}