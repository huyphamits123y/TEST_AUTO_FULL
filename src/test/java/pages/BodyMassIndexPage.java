package pages;

import Utils.Browsers;
import org.openqa.selenium.By;

public class BodyMassIndexPage {

    // Nếu mà locator chưa hiện trên giao diện hoặc phải click một nút gì đó để xuất hiện mà bạn đã lấy locator rồi
    // thì phải dùng wait để chờ cho đến khi nó hiện trên giao diện
    By metric = By.xpath("//a[normalize-space()='Metric Units']");
    By age = By.xpath("//input[@id='cage']");
    By height = By.xpath("//input[@id='cheightmeter']");
    By weight = By.xpath("//input[@id='ckg']");
    By button = By.xpath("//input[@type='submit']");
    By invalidAged = By.xpath("//font[normalize-space()='Please provide an age between 2 and 120.']");
    By invalidHeight = By.xpath("//font[normalize-space()='Please provide positive height value.']");
    By invalidWeight = By.xpath("//font[normalize-space()='Please provide positive weight value.']");
    public BodyMassIndexPage(){

    }
    public void open(){
        Browsers.visit("https://www.calculator.net/bmi-calculator.html");
    }
    public void selectMetricUnits(){
        Browsers.click(metric);
    }
    public void clickButton(){
        Browsers.click(button);
    }
    public void fillForm(String age1, String height1, String weight1){
        Browsers.clear(age);
        Browsers.fill(age, age1);
        Browsers.clear(height);
        Browsers.fill(height, height1);
        Browsers.clear(weight);
        Browsers.fill(weight, weight1);
    }
    // invalid khong hop le
    // valid hople
    // verify xac minh, kiem tra



}
