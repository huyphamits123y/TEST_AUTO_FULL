package herokuApp;

import Utils.Browsers;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BodyMassIndexPage;

public class BodyMassIndexTest {
    BodyMassIndexPage bodyMassIndexPage;
    @BeforeClass
    public void setUp(){
        Browsers.setDriver("chrome");
        bodyMassIndexPage = new BodyMassIndexPage();
        bodyMassIndexPage.open();

    }
    @DataProvider
    Object[][] bmiTestData(){
        return new Object[][]{
                {"26",182,70,"Male"},
                {"25",182,45,"Female"},
                {"0",182,45,"Female"},
                {"12",0,45,"Female"},
                {"20",182,0,"Female"}

        };
    }

//    @Test(dataProvider = "bmiTestData")
//    public void calculateBMI(String age, int height, int weight, String gender){
//       bodyMassIndexPage.selectMetricUnits();
//       bodyMassIndexPage.fillForm(age, String.valueOf(height), String.valueOf(weight));
//         bodyMassIndexPage.selectSex(gender);
//       bodyMassIndexPage.clickButton();
//       Assert.assertFalse(bodyMassIndexPage.isInvalidAgedDisplayed(), "Invalid age message is displayed");
//        Assert.assertFalse(bodyMassIndexPage.isInvalidHeightDisplayed(), "Invalid height message is displayed");
//        Assert.assertFalse(bodyMassIndexPage.isInvalidWeightDisplayed(), "Invalid weight message is displayed");
//    }
    @AfterClass
    public void tearDown(){
        Browsers.quit();
    }
}
