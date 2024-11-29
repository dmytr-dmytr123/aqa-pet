package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Board;
import model.Organization;
import util.PropertyReader;

import static io.restassured.RestAssured.given;

public class TrelloApiHelper {
    private static final String BASE_URL = PropertyReader.getProperty("trello.baseUrl");
    private static final String KEY = PropertyReader.getProperty("trello.key");
    private static final String TOKEN = PropertyReader.getProperty("trello.token");

    public static Organization createOrganization(String displayName) {
        Response response = given()
                .queryParam("displayName", displayName)
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL + "organizations")
                .then()
                .statusCode(200)
                .extract()
                .response();

        return new Organization(
                response.jsonPath().getString("id"),
                response.jsonPath().getString("displayName")
        );
    }

    public static Board createBoard(String name, String organizationId) {
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
                .statusCode(200)
                .extract()
                .response();

        return new Board(
                response.jsonPath().getString("id"),
                response.jsonPath().getString("name")
        );
    }

    public static void deleteOrganization(String organizationId) {
        given()
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .header("Accept", "application/json")
                .when()
                .delete(BASE_URL + "organizations/" + organizationId)
                .then()
                .statusCode(200);
    }
}
