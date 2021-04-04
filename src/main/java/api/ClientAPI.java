package api;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.Defaults;

import java.util.List;
import java.util.stream.Collectors;

public class ClientAPI extends Request {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    private static final String CLIENT_URL = "/client";
    private static final String CLIENTS_URL = "/clients";

    static {
        RestAssured.authentication = RestAssured.preemptive().basic(Defaults.EMAIL, Defaults.PASSWORD);
        RestAssured.baseURI = Defaults.BASE_URL;
        RestAssured.basePath = "/RESTapi";
    }

    public static Response deleteClient(String clientId) {
        return delete(CLIENT_URL, clientId);
    }

    public static Response getAllClients() {
        return get(CLIENTS_URL);
    }


    public static void deleteAllClients() {
        LOGGER.info("Deleting all clients");
        Response getResp = getAllClients();
        List<String> ids = JsonPath.read(getResp.body().asString(), "$..id");
        List<String> uniqueClients = ids.stream().distinct().collect(Collectors.toList());
        LOGGER.info("Clients found for deletion: " + uniqueClients.size() + " => " + uniqueClients.toString());
        uniqueClients.forEach(id -> deleteClient(id));
    }

}
