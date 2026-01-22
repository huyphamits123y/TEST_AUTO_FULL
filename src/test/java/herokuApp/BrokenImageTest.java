package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class BrokenImageTest {
    // dùng để check coi ảnh có bị vỡ hay không
    // dùng nhiều câu lệnh trong foreach thì thêm dấu {}
    @Test
    void verifyBrokenImages(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/broken_images");
        driver.findElements(By.xpath("//div/img"))
                .forEach(img -> {
                    int naturalHeight = Integer.parseInt(Objects.requireNonNull(img.getDomProperty("naturalHeight")));
                    int naturalWidth = Integer.parseInt(Objects.requireNonNull(img.getDomProperty("naturalWidth")));
                    Assert.assertTrue(naturalWidth>0);
                    Assert.assertTrue(naturalHeight>0);
                });
        driver.quit();
    }
}
