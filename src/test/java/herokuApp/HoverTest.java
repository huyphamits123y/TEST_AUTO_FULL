package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest {

    @Test
    void userProfileShowWhenHoverAvatar(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        WebElement avatar1 = driver.findElement(By.xpath("//div[@class='example']/div[1]/img"));
        actions.moveToElement(avatar1).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='example']/div[1]/div[@class='figcaption']/h5")).isDisplayed());
    }
    // HOVER TEST
}
