package restApiXmlFramework;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class restApiXmlConfig {

    @BeforeSuite(alwaysRun = true)

    public void configure() {
        RestAssured.baseURI = "http://fakerestapi.azurewebsites.net";

    }
}
