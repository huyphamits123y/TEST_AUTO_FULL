package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Browsers {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static WebDriver setDriver(String browser) {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless=new");
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        return driver;

    }

    public static void visit(String location) {
        driver.get(location);
    }

    public static void clear(By by) {
        driver.findElement(by).clear();
    }

    public static void fill(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static void click(By by) {
        driver.findElement(by).click();
    }

    public static String getText(By by) {
        return driver.findElement(by).getText();
    }

    public static void quit() {
        driver.quit();
    }


    public static void check(By locator) {
        if (!driver.findElement(locator).isSelected()) {
            click(locator);
        }
    }

    public static void uncheck(By locator) {
        if (driver.findElement(locator).isSelected()) {
            click(locator);
        }
    }

    public static boolean isSelected(By locator) {
        return driver.findElement(locator).isSelected();
    }

    public static boolean isSelectedByVisibleText(String visibleText) {
        return driver.findElement(getOption(visibleText)).isSelected();
    }


    public static void selectedOption(String visibleText, By selectBy) {
        Select select = new Select(driver.findElement(selectBy));
        select.selectByVisibleText(visibleText);
    }

    // trả về 1 list chứa các boolean
    public static List<Boolean> areOptionsSelected(List<String> visibleTexts) {
        return visibleTexts.stream().map(vi -> isSelectedByVisibleText(vi)).toList();

    }

    public static void selectedOptions(List<String> visibleTexts, By selectBy) {
        visibleTexts.forEach(i -> {
            selectedOption(i, selectBy);
        });

    }

    private static By getOption(String visibleText) {
        return By.xpath(String.format("//option[.='%s']", visibleText));
    }


    public static void deleteByValue(String value, By selectBy) {
        if (isSelectedByVisibleText(value)) {
            Select select = new Select(driver.findElement(selectBy));
            String value1 = value.toLowerCase();
            select.deselectByValue(value1);
        }
    }


    public static WebElement getElement(By by) {
        return driver.findElement(by);
    }

    public static List<WebElement> getElements(By by) {
        return driver.findElements(by);
    }

    public static void doubleClick(By by) {
        Actions actions = new Actions(driver);
        actions.doubleClick(getElement(by)).perform();
    }

    public static void doubleClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public static void executeScript(WebElement element, String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, element);
    }


}
