package pages;

import Utils.Browsers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static Utils.Browsers.*;

public class CheckboxesPage {
    By checkBox1 = By.xpath("//form[@id='checkboxes']/input[1]");
    By checkBox2 = By.xpath("//form[@id='checkboxes']/input[2]");


    public void open(){
        Browsers.visit("https://the-internet.herokuapp.com/checkboxes");
    }

    public void checkOnCheckBox1(){
        check(checkBox1);
    }

    public boolean isCheckBox1Selected(){
        return isSelected(checkBox1);
    }

    public void checkOnCheckBox2(){
        check(checkBox2);
    }

    public boolean isCheckBox2Selected(){
        return isSelected(checkBox2);
    }

    public void uncheckOnCheckBox1(){
        uncheck(checkBox1);
    }
    public void uncheckOnCheckBox2(){
        uncheck(checkBox2);
    }


}
