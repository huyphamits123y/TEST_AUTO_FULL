package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBoxestest {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void successfullyCheckCheckBoxes(){
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        check(checkbox1);
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected());

        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        check(checkbox2);
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected());



    }
    @Test
    void successfullyUnCheckCheckBoxes() {
//        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        // lấy con đầu tiên
        WebElement checkbox1 = driver.findElement(By.cssSelector("#checkboxes > input:nth-of-type(1)"));
        uncheck(checkbox1);
        Assert.assertFalse(driver.findElement(By.xpath("#checkboxes > input:nth-of-type(1)")).isSelected());

//        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        // lấy con thứ 2
        WebElement checkbox2 = driver.findElement(By.cssSelector("#checkboxes > input:nth-of-type(2)"));
        uncheck(checkbox2);
        Assert.assertFalse(driver.findElement(By.xpath("#checkboxes > input:nth-of-type(2)")).isSelected());
    }
    public void check(WebElement checkbox){
        if (!checkbox.isSelected()){
            checkbox.click();
        }
    }
    public void uncheck(WebElement checkbox){
        if (checkbox.isSelected()){
            checkbox.click();
        }
    }

}
