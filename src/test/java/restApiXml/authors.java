package restApiXml;

import common.endPoint;
import io.restassured.path.xml.XmlPath;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class authors {

    public String getAuthorById(int i) {
        String firstName = "";
        String lastName = "";
        String restApiXmlAuthorName = "";

        XmlPath xmlPath = given().header( "Accept","text/xml").get("http://fakerestapi.azurewebsites.net/api/Authors/1").xmlPath();
        firstName = xmlPath.getString("Author.FirstName");
        lastName = xmlPath.getString("Author.LastName");
        restApiXmlAuthorName = firstName + " " + lastName;
        return restApiXmlAuthorName;
    }

    @Test(groups = "demo")
    public void getValidation() {

        given().header( "Accept","text/xml").get(endPoint.GET_AUTHORS).then().statusCode(200).log().all();

    }

    @Test(groups = "demo")
    public void getIdAuthorsBooksValidation() {

        given().header( "Accept","text/xml").get(endPoint.GET_AUTHORS_BOOKS+"/1").then().statusCode(200).log().all();

    }

    @Test(groups = "demo")
    public void postValidation() {

        String requestBody = "Author {}";

        given().header( "Content-Type", "text/xml","Accept","text/xml").body(requestBody).post(endPoint.GET_AUTHORS).then().statusCode(200).log().all();

    }

    // It required to update the element that was recently added during post validation, but in case of fake API it's impossible. So, i'll delete the first one.
    @Test(groups = "demo")
    public void putValidation() {

        String requestBody = "Author {}";

        given().header( "Content-Type", "text/xml","Accept","text/xml").body(requestBody).put(endPoint.GET_AUTHORS + "/1").then().statusCode(200).log().all();

    }

    // It required to delete the element that was recently added during post validation, but in case of fake API it's impossible. So, i'll delete the first one.
    @Test(groups = "demo")
    public void deleteValidation() {

        given().header( "Content-Type", "text/xml","Accept","text/xml").delete(endPoint.GET_AUTHORS + "/1").then().statusCode(200).log().all();

    }

}
