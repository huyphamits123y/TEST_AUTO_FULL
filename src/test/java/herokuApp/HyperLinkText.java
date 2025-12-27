package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HyperLinkText {
    WebDriver driver;
    @Test
    public void verifyHyperLinkText(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");

        driver.findElement(By.linkText("200")).click();
        WebElement statsus200 = driver.findElement(By.xpath("//div[@class='example']/p"));
        Assert.assertTrue(statsus200.getText().contains("200 status code"));
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("301")).click();
        WebElement statsus301 = driver.findElement(By.xpath("//div[@class='example']/p"));
        Assert.assertTrue(statsus301.getText().contains("301 status code"));
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("404")).click();
        WebElement statsus404 = driver.findElement(By.xpath("//div[@class='example']/p"));
        Assert.assertTrue(statsus404.getText().contains("404 status code"));
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("500")).click();
        WebElement statsus500 = driver.findElement(By.xpath("//div[@class='example']/p"));
        Assert.assertTrue(statsus500.getText().contains("500 status code"));
        driver.findElement(By.linkText("here")).click();
//        driver.quit();


    }
// Cách 2
//    WebDriver driver;
//    @Test
//    public void verifyHyperLinkText(){
//        driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/status_codes");
//        driver.findElement(By.linkText("200")).click();
//        Assert.assertTrue(driver.getCurrentUrl().contains("status_codes/200"));
////        driver.findElement(By.linkText("here")).click();
//        driver.navigate().back(); // thay cho driver.findElement(By.linkText("here")).click();
//
//        driver.findElement(By.linkText("301")).click();
//        Assert.assertTrue(driver.getCurrentUrl().contains("status_codes/301"));
//        driver.findElement(By.linkText("here")).click();
//        driver.findElement(By.linkText("404")).click();
//        Assert.assertTrue(driver.getCurrentUrl().contains("status_codes/404"));
//        driver.findElement(By.linkText("here")).click();
//        driver.findElement(By.linkText("500")).click();
//        Assert.assertTrue(driver.getCurrentUrl().contains("status_codes/500"));
//        driver.findElement(By.linkText("here")).click();
////        driver.quit();
//    }
}
