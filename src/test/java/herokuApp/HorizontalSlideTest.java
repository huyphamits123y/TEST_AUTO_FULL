package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HorizontalSlideTest {
    @Test
    void slider(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        Actions actions = new Actions(driver);
        WebElement pointer = driver.findElement(By.cssSelector(".sliderContainer input"));
        actions.clickAndHold(pointer).moveByOffset(100,0).perform();
    }
}
