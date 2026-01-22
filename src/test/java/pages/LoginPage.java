package pages;

import Utils.Browsers;
import org.openqa.selenium.By;

public class LoginPage {
    public LoginPage(){}
    public void open(){
        Browsers.visit("https://the-internet.herokuapp.com/login");
    }
    public void submitForm(String username, String password){
        Browsers.fill(By.id("username"), username);
        Browsers.fill(By.id("password"), password);
        Browsers.click(By.cssSelector("button[type='submit']"));

    }
    public String getFlashMessage(String type){
        return Browsers.getText(By.className(type));

    }
}
