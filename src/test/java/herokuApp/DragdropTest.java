package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragdropTest {
    @Test
    void moveBox(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));
        actions.dragAndDrop(source,target).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("#column-a header")).getText(),"B");
        Assert.assertEquals(driver.findElement(By.cssSelector("#column-b header")).getText(),"A");
        driver.quit();
    }
}
