package com.pageobjects;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.cucumber.TestHarness;
import com.framework.reusable.WebReusableComponents;

public class GruSi_TraegerundBankPage extends WebReusableComponents {

    protected TestHarness harness = new TestHarness();
    protected String sheetName = "Traeger und Bank";

    public GruSi_TraegerundBankPage() {
        PageFactory.initElements(driver, this);
    }

    protected By radioButtonById(String id) {
        return By.id(id);
    }

    protected By textBoxById(String id) {
        return By.id(id);
    }

    protected By dropDownById(String id) {
        return By.id(id);
    }

    protected By commonButtonById(String id) {
        return By.id(id);
    }

    public void haben_Sie_in_den_letzten_2_Monaten_eine_stationaere_Einrichtung_verlassen(String iteration, String statEinrichtung) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        String data = harness.getData(sheetName, iteration, statEinrichtung);
        if (!data.isEmpty()) {
            clickElement(radioButtonById(prefixId + ".statEinrichtung"));
            Assert.assertEquals(getSelectedRadioButtonValue(prefixId + ".statEinrichtung"), data, "Radio button selection mismatch.");
        }
    }

    public void haben_Sie_jemals_im_Ausland_gelebt(String iteration, String traegerAusland, String zeitraumAnfang, String zeitraumEnde, String traegerAuslandOrt, String traegerAuslandStaat, String traegerAuslandErwerb) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        String data = harness.getData(sheetName, iteration, traegerAusland);
        if (!data.isEmpty()) {
            clickElement(radioButtonById(prefixId + ".traegerAusland"));
            handlePageLoading();
            Assert.assertEquals(getSelectedRadioButtonValue(prefixId + ".traegerAusland"), data, "Radio button selection mismatch.");
        }
        if (data.equalsIgnoreCase("Ja")) {
            int n = harness.getIterationCount(iteration, sheetName, zeitraumAnfang);
            for (int i = 1; i <= n; i++) {
                if (i > 1) {
                    clickElement(commonButtonById(".btn_zeitraum_add"));
                    handlePageLoading();
                }
                prefixId = String.valueOf(Integer.parseInt(iteration) - 1) + ".GruSi_TraegerAusland." + String.valueOf(i - 1);
                enterText(textBoxById(prefixId + ".zeitraumAnfang"), harness.getIterationData(iteration, sheetName, zeitraumAnfang, i));
                sendKeysToWindow(Keys.ESCAPE);
                handlePageLoading();
                enterText(textBoxById(prefixId + ".zeitraumEnde"), harness.getIterationData(iteration, sheetName, zeitraumEnde, i));
                sendKeysToWindow(Keys.ESCAPE);
                handlePageLoading();
                enterText(textBoxById(prefixId + ".traegerAuslandOrt"), harness.getIterationData(iteration, sheetName, traegerAuslandOrt, i));
                selectDropdownByValue(dropDownById(prefixId + ".traegerAuslandStaat"), harness.getIterationData(iteration, sheetName, traegerAuslandStaat, i));
                clickElement(radioButtonById(prefixId + ".traegerAuslandErwerb"));
                Assert.assertEquals(getSelectedRadioButtonValue(prefixId + ".traegerAuslandErwerb"), harness.getIterationData(iteration, sheetName, traegerAuslandErwerb, i), "Radio button selection mismatch.");
            }
        }
    }

    public void bankVerbindung(String ktoInh, String iban, String bic, String institut, String pfaendungsschutzkto, String begruendung) {
        enterText(textBoxById("kontoinhaber"), harness.getData(sheetName, ktoInh));
        enterText(textBoxById("iban"), harness.getData(sheetName, iban));
        enterText(textBoxById("bic"), harness.getData(sheetName, bic));
        enterText(textBoxById("geldinstitut"), harness.getData(sheetName, institut));
        String data = harness.getData(sheetName, pfaendungsschutzkto);
        if (!data.isEmpty()) {
            clickElement(radioButtonById(".traegerAusland"));
            handlePageLoading();
            Assert.assertEquals(getSelectedRadioButtonValue(".traegerAusland"), data, "Radio button selection mismatch.");
        }
        enterText(textBoxById("Freifeld"), harness.getData(sheetName, begruendung));
    }

    private void handlePageLoading() {
        waitUntilPageLoads();
    }

    private String getSelectedRadioButtonValue(String id) {
        WebElement element = driver.findElement(radioButtonById(id));
        return element.getAttribute("value");
    }

    private void waitUntilPageLoads() {
        // Implement wait logic here
    }
}