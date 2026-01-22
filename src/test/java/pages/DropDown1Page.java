package pages;

import Utils.Browsers;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DropDown1Page {

    By selectBy = By.id("dropdown");
    By selectByList = By.id("fruits");

    public DropDown1Page() {

    }

    public void open() {
        Browsers.visit("https://the-internet.herokuapp.com/dropdown");
    }

    public void openMul() {
        Browsers.visit("https://output.jsbin.com/osebed/2");
    }

    public boolean isSelectedByVisibleText(String visibleText) {
        return Browsers.isSelectedByVisibleText(visibleText);
    }

    public void selectedOptions(List<String> option) {
        Browsers.selectedOptions(option, selectByList);
    }

    public void selectedOption(String option) {
        Browsers.selectedOption(option, selectBy);
    }

    //    public boolean areOptionsSelected(List<String> option) {
//        List<Boolean> list = Browsers.areOptionsSelected(option);
//        int a = 0;
//        for (Boolean b : list) {
//            if (!b) {
//                a = 1;
//            }
//        }
//        if (a == 0) {
//            return true;
//        } else {
//            return false;
//        }
//
//    }
    public boolean areOptionsSelected(List<String> visibleTexts) {
        return Browsers.areOptionsSelected(visibleTexts)
                .stream()
                .allMatch(Boolean::booleanValue);
        // AllMatch trả về true nếu tất cả phần từ thỏa điều kiện
        // AnyMatch trả về FALSE nếu một phần từ không thỏa điều kiện
    }

    public void deleteByValue(String value) {
        Browsers.deleteByValue(value, selectByList);
    }

}
