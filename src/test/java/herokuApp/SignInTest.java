package herokuApp;

import Utils.Browsers;
import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class SignInTest extends Browsers {

    WebDriver driver;
    LoginPage loginPage;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        driver = setDriver(browser);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        quit();
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!", "You logged into a secure area!", true},
                {"InvalidUsername", "SuperSecretPassword!", "Your username is invalid!", false},
                {"tomsmith", "InvalidPassword!", "Your password is invalid!", false}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password,
                          String expectedMessage, boolean isSuccess) {

        loginPage = new LoginPage();
        loginPage.open();
        loginPage.submitForm(username, password);
        if (isSuccess) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
            Assert.assertTrue(getText(By.className("success")).contains(expectedMessage));
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error")));
            Assert.assertTrue(getText(By.className("error")).contains(expectedMessage));
        }
    }
}
