import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class PostmanMethodsTests {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeAll
    public static void setup() {
        // Настройка RequestSpecification
        requestSpec = RestAssured.given()
                .baseUri("https://postman-echo.com")
                .header("User-Agent", "PostmanRuntime/7.39.0")
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive");

        // Настройка ResponseSpecification
        responseSpec = RestAssured.expect()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("args", equalTo(new HashMap<>()))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers", hasKey("x-amzn-trace-id"))
                .body("headers.user-agent", equalTo("PostmanRuntime/7.39.0"))
                .body("headers.accept", equalTo("*/*"));

    }

    @Test
    //Метод GET Request
    public void testGetRequest() {
        given()
                .spec(requestSpec)
        .when()
                .get("/get")
        .then()
                .spec(responseSpec)
                .body("url", equalTo("https://postman-echo.com/get"));
    }

    @Test
    //Метод POST Raw Text
    public void testPostRawText() {
        String requestBody = "{\n    \"test\": \"value\"\n}";

        given()
                .spec(requestSpec)
                .contentType("text/plain")
                .body(requestBody)
        .when()
                .post("/post")
        .then()
                .spec(responseSpec)
                .body("data", equalTo("{\n    \"test\": \"value\"\n}"))
                .body("files", equalTo(new HashMap<>()))
                .body("form", equalTo(new HashMap<>()))
                .body("headers.content-length", equalTo("23"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.accept-encoding", equalTo("gzip, deflate, br"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    //Метод POST Form Data
    public void testPostFormData() {

        given()
                .spec(requestSpec)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
        .when()
                .post("/post")
        .then()
                .spec(responseSpec)
                .body("data", equalTo(""))
                .body("files", equalTo(new HashMap<>()))
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("headers.content-length", equalTo("19"))
                .body("headers.content-type", equalTo("application/x-www-form-urlencoded; charset=UTF-8"))
                .body("headers.accept-encoding", equalTo("gzip, deflate, br"))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    //Метод PUT Request
    public void testPutRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .spec(requestSpec)
                .contentType("text/plain")
                .body(requestBody)
                //.log().all()
                .when()
                .put("/put")
                .then()
                //.log().all()
                .spec(responseSpec)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(new HashMap<>()))
                .body("form", equalTo(new HashMap<>()))
                .body("headers.content-length", equalTo("58"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.accept-encoding", equalTo("gzip, deflate, br"))
                .body("url", equalTo("https://postman-echo.com/put"));
                //.extract().response();
    }

    @Test
    //Метод PATCH Request
    public void testPatchRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .spec(requestSpec)
                .contentType("text/plain")
                .body(requestBody)
                //.log().all()
                .when()
                .patch("/patch")
                .then()
                //.log().all()
                .spec(responseSpec)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(new HashMap<>()))
                .body("form", equalTo(new HashMap<>()))
                .body("headers.content-length", equalTo("58"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.accept-encoding", equalTo("gzip, deflate, br"))
                .body("url", equalTo("https://postman-echo.com/patch"));
                //.extract().response();
    }

    @Test
    //Метод DELETE Request
    public void testDeleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .spec(requestSpec)
                .contentType("text/plain")
                .body(requestBody)
                .log().all()
                .when()
                .delete("/delete")
                .then()
                .log().all()
                .spec(responseSpec)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(new HashMap<>()))
                .body("form", equalTo(new HashMap<>()))
                .body("headers.content-length", equalTo("58"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.accept-encoding", equalTo("gzip, deflate, br"))
                .body("url", equalTo("https://postman-echo.com/delete"))
                .extract().response();
    }

}
