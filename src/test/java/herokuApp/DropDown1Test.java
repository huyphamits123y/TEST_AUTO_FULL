package herokuApp;

import Utils.Browsers;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropDown1Page;

import java.time.Duration;
import java.util.List;

public class DropDown1Test {
    WebDriver driver;
    DropDown1Page dropDown1Page;
    @BeforeMethod
    void setUp(){
        driver = Browsers.setDriver("chrome");
        dropDown1Page = new DropDown1Page();

    }
    @Test
    @Description("Select a option by visible text")
    void selectOptionFromDropDown() throws InterruptedException {
        dropDown1Page.open();
        Thread.sleep(1000);
        dropDown1Page.selectedOption("Option 1");
        Assert.assertTrue(dropDown1Page.isSelectedByVisibleText("Option 1"));

    }

    @AfterMethod
    void tearDown()  {
      Browsers.quit();
    }

}
