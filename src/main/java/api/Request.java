package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.Defaults;

public class Request {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    static {
        RestAssured.authentication = RestAssured.preemptive().basic(Defaults.EMAIL, Defaults.PASSWORD);
        RestAssured.baseURI = Defaults.BASE_URL;
        RestAssured.basePath = "/RESTapi";
    }

    protected static Response delete (String url, String clientId) {
        Response response = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .delete(url + "/" + clientId);
        response.prettyPrint();
        return response;
    }

    protected static Response get(String url) {
        Response response = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .get(url);
        response.prettyPrint();
        return response;
    }
}
