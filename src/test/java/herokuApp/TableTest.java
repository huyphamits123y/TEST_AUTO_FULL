package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class TableTest {
    // sự khác nhau giữa for và foreach
    // for qui định i và tăng
    // foreach chạy từ đầu tới cuối

    // for foreach, List, array bắt đầu từ 0
    // Ifreams bắt đầu từ 0
    // Xpath bắt đầu từ 1
//    @Test
//    void verifyMaxDueValueInTable(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/tables");
//        driver.findElements(By.cssSelector("#table1 tbody tr"));
//
//        driver.findElements(By.cssSelector("#table1 tbody td"));
//
//    }
    @Test
    void verifyMaxDuePerson() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        //Step1: get due column
        List<Double> dueList = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .map(cell -> Double.valueOf(cell.getText().replace("$", "")))
                .toList();
        // step2: find max due
        Double maxDue = dueList.stream().max(Comparator.naturalOrder()).get();
        // step 3: find max due index
        int maxDueIndex = dueList.indexOf(maxDue);

        // tim index of max due value expected 2+1
        //step 4: get firstname lastname with maxdue index +1 ==> array index from 0, xpath index from 1
        String lastname = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[1]", maxDueIndex + 1))).getText();// => return cell[1][1]
        String firstName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[2]", maxDueIndex + 1))).getText();// => return cell[1][1]
        Assert.assertEquals(String.format("%s %s", firstName, lastname), "Jason Doe");
        driver.quit();
    }
//    #table1 tbody tr
//    driver
//            .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
//            .forEach(cell -> System.out.println(cell.getText()));
//
//    String[] arr = new String[]{"$50.00", "$51.00", "$100.00", "$50.00"};
//// tim index of max due value
////driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[max-due-index]/td[1]"));// => return cell[1][1]
////driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[max-due-index]/td[2]"));// => return cell[1][1]
}
