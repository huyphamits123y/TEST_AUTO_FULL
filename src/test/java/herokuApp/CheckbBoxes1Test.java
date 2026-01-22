package herokuApp;

import Utils.Browsers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckBoxes1Page;

public class CheckbBoxes1Test {

   CheckBoxes1Page checkBoxes1Page;
    @BeforeClass
    void setUp() {
        Browsers.setDriver("chrome");
        checkBoxes1Page = new  CheckBoxes1Page();
       checkBoxes1Page.setUp();
    }



    @Test
    void theCheckboxesShouldSelected() {
        checkBoxes1Page.check();
        Assert.assertTrue(checkBoxes1Page.isCheckBox1Selected());

        checkBoxes1Page.check1();
        Assert.assertTrue(checkBoxes1Page.isCheckBox2Selected());



    }

    @Test
    void theCheckboxesShouldDeSelected() {
        checkBoxes1Page.uncheck();
        Assert.assertFalse(checkBoxes1Page.isCheckBox1Selected());

        checkBoxes1Page.uncheck1();
        Assert.assertFalse(checkBoxes1Page.isCheckBox2Selected());
    }

    @AfterClass
    void tearDown() {
        Browsers.quit();
    }


}
