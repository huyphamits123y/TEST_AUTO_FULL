package pages;

import Utils.Browsers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxes1Page {

    By checkBox1 = By.xpath("//form[@id='checkboxes']/input[1]");
    By checkBox2 = By.xpath("//form[@id='checkboxes']/input[2]");

    public CheckBoxes1Page(){}
   public void check() {
       Browsers.check(checkBox1);
    }
    public void check1() {
       Browsers.check(checkBox2);
    }
    public void setUp(){
        Browsers.visit("https://the-internet.herokuapp.com/checkboxes");
    }

    public void uncheck() {
       Browsers.uncheck(checkBox1);
    }
    public void uncheck1() {
        Browsers.uncheck(checkBox2);
    }
    public boolean isCheckBox1Selected(){
        return Browsers.isSelected(checkBox1);
    }
    public boolean isCheckBox2Selected() {
        return Browsers.isSelected(checkBox2);
    }
}
