package stepsDefinition;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import cucumber.annotation.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import restApiXml.authors;
import website.bookDepository;
import static org.junit.Assert.assertNotEquals;

public class equalityFeature {

    public bookDepository webSite = new bookDepository();
    public authors restApiXml = new authors();

    private static WebDriver driver;


    @BeforeClass(groups = "testtask")
    @Given("Open https://www.bookdepository.com/author/1")
    public static void setup() {
        String pathToChromeDriver = "C://bin//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        driver = new ChromeDriver();
    }

    @Test(groups = "testtask")
    @When("Get the 1st author name in API and on the webSite")
    public void getData() {
        webSite.getAuthorName(driver);
        restApiXml.getAuthorById(1);

    }

    @Test(groups = "testtask")
    @Then("Check that the 1st author name in API and on the website are not equal")
    public void assertionOfValues() {
        assertNotEquals(webSite.getAuthorName(driver), restApiXml.getAuthorById(1));
    }

    @And("Close the browser")

    @AfterClass(groups = "testtask")
    public static void teardown(){
        driver.close();
    }


}
