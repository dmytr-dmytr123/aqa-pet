package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.qameta.allure.Step;
import model.Board;
import model.Organization;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.PropertyReader;

import static io.restassured.RestAssured.given;

public class TrelloApiHelper {

    private static final Logger logger = LogManager.getLogger(TrelloApiHelper.class);

    private static final String BASE_URL = PropertyReader.getProperty("trello.baseUrl");
    private static final String KEY = PropertyReader.getProperty("trello.key");
    private static final String TOKEN = PropertyReader.getProperty("trello.token");

    @Step("create organization with display name: {displayName}")
    public static Organization createOrganization(String displayName) {
        logger.info("creating organization with display name: {}", displayName);
        Response response = given()
                .queryParam("displayName", displayName)
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL + "organizations")
                .then()
                .log().body() // Optional: Log response for debugging
                .statusCode(200)
                .extract()
                .response();

        logger.info("prganization created with ID: {}", response.jsonPath().getString("id"));

        return new Organization(
                response.jsonPath().getString("id"),
                response.jsonPath().getString("displayName")
        );
    }

    @Step("create board with name: {name} in organization ID: {organizationId}")
    public static Board createBoard(String name, String organizationId) {
        logger.info("creating board with name: {} in organization ID: {}", name, organizationId);
        Response response = given()
                .queryParam("name", name)
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .queryParam("idOrganization", organizationId)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL + "boards")
                .then()
                .log().body() // Optional: Log response for debugging
                .statusCode(200)
                .extract()
                .response();

        logger.info("board created with ID: {}", response.jsonPath().getString("id"));

        return new Board(
                response.jsonPath().getString("id"),
                response.jsonPath().getString("name")
        );
    }

    @Step("вelete organization with ID: {organizationId}")
    public static void deleteOrganization(String organizationId) {
        logger.info("deleting organization with ID: {}", organizationId);
        given()
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .header("Accept", "application/json")
                .when()
                .delete(BASE_URL + "organizations/" + organizationId)
                .then()
                .log().body()
                .statusCode(200);

        logger.info("organization with ID: {} deleted successfully", organizationId);
    }
}
