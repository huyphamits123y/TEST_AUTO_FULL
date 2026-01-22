package herokuApp;

import className.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class TableTest {
    // sự khác nhau giữa for và foreach
    // for qui định i và tăng
    // foreach chạy từ đầu tới cuối

    // for foreach, List, array bắt đầu từ 0
    // Ifreams bắt đầu từ 0
    // Xpath bắt đầu từ 1

    // //table[@id="table1"]//tr/td[4]
    // nghĩa là lấy tất cả các tr là con cháu của table, trong mỗi tr lấy con trực tiếp td thứ 4.

    WebElement lastName1;
    WebElement firstName1;
    @Test
    public void verifyMaxDuePerson(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        // Lấy tất cả giá trị của dòng tiêu đề
       List <WebElement> webElement = driver.findElements(By.xpath("//table[@id=\"table1\"]//th"));
       webElement.forEach(element -> System.out.println(element.getText()));
       // hoặc
//         for (WebElement element: webElement){
//              System.out.println(element.getText());
//         }
         // Lấy tất cả giá trị của cột 1
        List <WebElement> webElement1 = driver.findElements(By.xpath("//table[@id=\"table1\"]//td[1]"));
        webElement1.forEach(element -> System.out.println(element.getText()));
         // Lấy giá trị dòng 1 cột 1
        List <WebElement> webElement2 = driver.findElements(By.xpath("//table[@id=\"table1\"]//th[1]/span"));
        webElement2.forEach(element -> System.out.println(element.getText()));
        // Lấy tất cả giá trị của bảng
        driver.findElements(By.xpath("//table[@id=\"table1\"]//td")).forEach(element -> System.out.println(element.getText()));
        // Lấy tất cả giá trị của cột Due và tìm giá trị lớn nhất
        List<Double> dueList = new ArrayList<>();
        List <WebElement> webElement3 = driver.findElements(By.xpath("//table[@id=\"table1\"]//tr/td[4]"));
        webElement3.forEach(
                element ->
                        dueList.add(Double.valueOf(element.getText().replace("$","")))
        );
        dueList.forEach(aDouble -> System.out.println(aDouble + " "));
        Double max = Collections.max(dueList);
        // Index bắt đầu từ 0
        int maxDueIndex = dueList.indexOf(max);
        System.out.println("gia tri max " + max + " tai vi tri " + (maxDueIndex + 1));
        // Lấy firstname và lastname của người có giá trị Due lớn nhất
        WebElement lastName = driver.findElement(By.xpath("//table[@id=\"table1\"]//tr[" + (maxDueIndex + 1) + " ]/td[1]"));
        WebElement firstName = driver.findElement(By.xpath("//table[@id=\"table1\"]//tr[" + (maxDueIndex + 1) + " ]/td[2]"));
        String fullName = firstName.getText() + " " + lastName.getText();;
        System.out.println("Full name of max due person: " + fullName);

        // Cách 2
        List<Double> dueList1 = driver.findElements(By.xpath("//table[@id=\"table1\"]//tr/td[4]"))
                .stream()
                .map(cell -> Double.valueOf(cell.getText().replace("$","")))
                .toList();
        Double max1 = Collections.max(dueList1);
        // Index bắt đầu từ 0
        int maxDueIndex1 = dueList1.indexOf(max1);
        System.out.println("gia tri max CACH 2 " + max1 + " tai vi tri " + (maxDueIndex1 + 1));
        // Lấy firstname và lastname của người có giá trị Due lớn nhất
        WebElement lastName1 = driver.findElement(By.xpath("//table[@id=\"table1\"]//tr[" + (maxDueIndex1 + 1) + " ]/td[1]"));
        WebElement firstName1 = driver.findElement(By.xpath("//table[@id=\"table1\"]//tr[" + (maxDueIndex1 + 1) + " ]/td[2]"));
        String fullName1 = firstName1.getText() + " " + lastName1.getText();;
        System.out.println("Full name of max due person: " + fullName1);



    }

    @Test
    public void verifyMinDuePersonx(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<Double> dueList1 = driver.findElements(By.xpath("//table[@id=\"table1\"]//tr/td[4]"))
                .stream()
                .map(cell -> Double.valueOf(cell.getText().replace("$","")))
                .toList();
        Double min1 = Collections.min(dueList1);
        List <Integer> index = new ArrayList<>();
        for (int i = 0; i < dueList1.size(); i++){
            if (dueList1.get(i).equals(min1)){
                index.add(i + 1);
                System.out.println("gia tri index"+ (i+1));
            }
        }
        for (Integer indexx : index) {
            String lastName = driver.findElement(
                    By.xpath("//table[@id='table1']//tbody/tr[" + indexx + "]/td[1]")
            ).getText();

            String firstName = driver.findElement(
                    By.xpath("//table[@id='table1']//tbody/tr[" + indexx + "]/td[2]")
            ).getText();

            String fullName = firstName + " " + lastName;
            System.out.println("Full name of min due person: " + fullName);
        }




    }


    @Test
    public void verifyMaxDuePerson1(){
    WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<Double> list = driver.findElements(By.xpath("//table[@id=\"table1\"]//tr/td[4]"))
                .stream()
                .map(due -> Double.valueOf(due.getText().replace("$", "")))
                .toList();
        double max = Collections.max(list);
        int index = list.indexOf(max);
        System.out.println("gia tri max" + max + "tai vi tri" + (index + 1));
    }
    @Test
    public void verifyMinDuePerson(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<Double> list = driver.findElements(By.xpath("//table[@id=\"table1\"]//tr/td[4]"))
                .stream()
                .map(due -> Double.valueOf(due.getText().replace("$", "")))
                .toList();
        double min = Collections.min(list);
        List <Integer> index = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) == min){
                index.add(i);
            }
        }
        index.forEach(i -> {
            System.out.println("gia tri min la" + min + "tai vi tri" + (i+1));
        });
    }
    @Test
    public void verifyMinDueClassPerson(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<Double> list = driver.findElements(By.xpath("//table[@id=\"table1\"]//tr/td[4]"))
                .stream()
                .map(due -> Double.valueOf(due.getText().replace("$", "")))
                .toList();
        double min = Collections.min(list);
        List <Integer> index = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) == min){
                index.add(i);
            }
        }
        List<Person> person = new ArrayList<>();
        index.forEach(i -> {
            String[] chuoi = driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody//tr[" + (i+1) + "]")).getText().split(" ");
            person.add(new Person(chuoi[0], chuoi[1], Double.valueOf(chuoi[3].replace("$", ""))));

        });

        person.forEach(i -> {
            System.out.println("nguoi co due min" + i.getFirstName() + " " + i.getLastName() + " " + i.getDue() + "$");
        });
    }




//    @Test
//    void verifyMaxDuePerson() {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("headless=new");
//       WebDriver driver = new ChromeDriver(chromeOptions);
//        driver.get("https://the-internet.herokuapp.com/tables");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        //Step1: get due column
//        List<Double> dueList = driver
//                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
//                .stream()
//                .map(cell -> Double.valueOf(cell.getText().replace("$", "")))
//                .toList();
//        // step2: find max due
//        Double maxDue = dueList.stream().max(Comparator.naturalOrder()).get();
//        // step 3: find max due index
//        int maxDueIndex = dueList.indexOf(maxDue);
//
//        // tim index of max due value expected 2+1
//        //step 4: get firstname lastname with maxdue index +1 ==> array index from 0, xpath index from 1
//        String lastname = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[1]", maxDueIndex + 1))).getText();// => return cell[1][1]
//        String firstName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[2]", maxDueIndex + 1))).getText();// => return cell[1][1]
//        Assert.assertEquals(String.format("%s %s", firstName, lastname), "Jason Doe");
//        driver.quit();
//    }






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
