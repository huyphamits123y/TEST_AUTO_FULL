package herokuApp;

import className.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TableTestPerson {
    List<Person> personList = new ArrayList<>();
    @BeforeClass
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/tables");
        driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).forEach(i -> {
            String[] chuoi = i.getText().split(" ");
            personList.add(new Person(chuoi[0], chuoi[1], Double.valueOf(chuoi[3].replace("$", ""))));

        });
    }
    @Test
    public void verifyMaxPerson(){
        double maxDue = personList.stream().max(Comparator.comparing(Person::getDue)).get().getDue();
        List<String> list = personList.stream()
                .filter(i -> i.getDue() == maxDue) // lọc dữ liệu
                .map(Person::getFullName) // biến đổi dữ liệu
                .toList();
        list.forEach(i -> System.out.println("nguoi co max" + i));
    }
    @Test
    public void verifyMinPerson(){
        double mixDue = personList.stream().min(Comparator.comparing(Person::getDue)).get().getDue();
        // muốn biết Líst dữ liệu kiểu gì dựa vào map
        List<String> list = personList.stream()
                .filter(i -> i.getDue() == mixDue) // lọc dữ liệu
                .map(Person::getFullName) // biến đổi dữ liệu
                .toList();
        list.forEach(i -> System.out.println("nguoi co minn" + i));
    }


}
