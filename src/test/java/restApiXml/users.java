package restApiXml;

import common.endPoint;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class users {

    @Test(groups = "demo")
    public void getValidation() {

        given().header( "Accept","text/xml").get(endPoint.GET_USERS).then().statusCode(200).log().all();

    }

    @Test(groups = "demo")
    public void getIdValidation() {

        given().header( "Accept","text/xml").get(endPoint.GET_USERS+"/1").then().statusCode(200).log().all();

    }

    @Test(groups = "demo")
    public void postValidation() {


        String requestBody = "User {}";

        given().header( "Content-Type", "text/xml","Accept","text/xml").body(requestBody).post(endPoint.GET_USERS).then().statusCode(200).log().all();

    }

    // It required to update the element that was recently added during post validation, but in case of fake API it's impossible. So, i'll delete the first one.
    @Test(groups = "demo")
    public void putValidation() {


        String requestBody = "User {}";

        given().header( "Content-Type", "text/xml","Accept","text/xml").body(requestBody).put(endPoint.GET_USERS + "/1").then().statusCode(200).log().all();

    }

    // It required to delete the element that was recently added during post validation, but in case of fake API it's impossible. So, i'll delete the first one.
    @Test(groups = "demo")
    public void deleteValidation() {

        given().header( "Content-Type", "text/xml","Accept","text/xml").delete(endPoint.GET_USERS + "/1").then().statusCode(200).log().all();

    }

}
