package herokuApp;

import Utils.Browsers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

import java.time.Duration;

public class CheckBoxesTest {
// trong POM thì chỉ trong Test mới được dùng assert còn page và những cái khác không được
    CheckboxesPage checkboxesPage;
    @BeforeMethod
    public void setup(){
        Browsers.setDriver("chrome");
        checkboxesPage = new CheckboxesPage();
        checkboxesPage.open();
    }

    @Test
    public void successfullyCheckCheckBoxes(){
        checkboxesPage.checkOnCheckBox1();
        Assert.assertTrue(checkboxesPage.isCheckBox1Selected());

        checkboxesPage.checkOnCheckBox2();
        Assert.assertTrue(checkboxesPage.isCheckBox2Selected());
    }

    @Test
    void successfullyUnCheckCheckBoxes() {
        checkboxesPage.uncheckOnCheckBox1();
        Assert.assertFalse(checkboxesPage.isCheckBox1Selected());

        checkboxesPage.uncheckOnCheckBox2();
        Assert.assertFalse(checkboxesPage.isCheckBox2Selected());
    }

    @AfterMethod
    void tearDown()  {
        Browsers.quit();
    }



}
