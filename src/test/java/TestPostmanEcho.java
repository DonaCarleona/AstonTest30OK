import io.restassured.http.ContentType;
import io.restassured.http.Method;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.lessThan;

public class TestPostmanEcho {

    @Test
    public void testGetRequest() {
        given()
                .queryParam("foo1","bar1")
                .queryParam("foo2","bar2")
                .response()
                .contentType(ContentType.JSON)
                .time(lessThan(2000L))
                .header("Connection", "keep-alive")
                .expect()
                .body("args.foo1", is("bar1"))
                .body("args.foo2", is("bar2"))
                .body("headers.host", is("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", is("close"))
                .body("headers.x-forwarded-proto", is("https"))
                .body("headers.x-forwarded-port", is("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", is("*/*"))
                .body("headers.cache-control", nullValue())
                .body("headers.postman-token", nullValue())
                .body("headers.cookie", nullValue())
                .body("url", is("https://postman-echo.com/get?foo1=bar1&foo2=bar2"))
                .when()
                .request(Method.GET,"https://postman-echo.com/get")
                .then()
                .statusCode(200);
    }

    @Test
    public void testPostRequest() {
        given()
                .body("{\n" +
                        "    \"test\": \"value\"\n" +
                        "}")
                .response()
                .expect()
                .body("args", notNullValue())
                .body("data", is("{\n" +
                        "    \"test\": \"value\"\n" +
                        "}"))
                .body("headers.host", is("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", is("close"))
                .body("headers.x-forwarded-proto", is("https"))
                .body("headers.x-forwarded-port", is("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", notNullValue())
                .body("content-type", nullValue())
                .body("headers.accept", is("*/*"))
                .body("headers.cache-control", nullValue())
                .body("headers.postman-token", nullValue())
                .body("headers.cookie", nullValue())
                .body("url", is("https://postman-echo.com/post"))
                .body("json", nullValue())
                .when()
                .request(Method.POST,"https://postman-echo.com/post")
                .then()
                .statusCode(200);
    }

    // не понимаю почему если не передать отдельно body то будет ошибка. В Постман все ок
    @Test
    public void testPostRequestFormData() {

        given()
                .formParam("foo1","bar1")
                .formParam("foo2","bar2")
                .when()
                .request(Method.POST,"https://postman-echo.com/post")
                .then()
                .statusCode(500);
    }

    @Test
    public void testPutRequest() {

        given()
                .body("raw")
                .response()
                .expect()
                .body("args", notNullValue())
                .body("data", is("raw"))
                .body("files", notNullValue())
                .body("headers.host", is("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", is("close"))
                .body("headers.x-forwarded-proto", is("https"))
                .body("headers.x-forwarded-port", is("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", notNullValue())
                .body("content-type", nullValue())
                .body("headers.accept", is("*/*"))
                .body("headers.cache-control", nullValue())
                .body("headers.postman-token", nullValue())
                .body("headers.cookie", nullValue())
                .body("url", is("https://postman-echo.com/put"))
                .body("json", nullValue())
                .when()
                .request(Method.PUT,"https://postman-echo.com/put")
                .then()
                .statusCode(200);
    }

    @Test
    public void testPatchRequest() {

        given()
                .body("raw")
                .response()
                .expect()
                .body("args", notNullValue())
                .body("data", is("raw"))
                .body("files", notNullValue())
                .body("headers.host", is("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", is("close"))
                .body("headers.x-forwarded-proto", is("https"))
                .body("headers.x-forwarded-port", is("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", notNullValue())
                .body("content-type", nullValue())
                .body("headers.accept", is("*/*"))
                .body("headers.cache-control", nullValue())
                .body("headers.postman-token", nullValue())
                .body("headers.cookie", nullValue())
                .body("url", is("https://postman-echo.com/patch"))
                .body("json", nullValue())
                .when()
                .request(Method.PATCH,"https://postman-echo.com/patch")
                .then()
                .statusCode(200);
    }

    @Test
    public void testDeleteRequest() {

        given()
                .body("raw")
                .response()
                .expect()
                .body("args", notNullValue())
                .body("data", is("raw"))
                .body("files", notNullValue())
                .body("headers.host", is("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", is("close"))
                .body("headers.x-forwarded-proto", is("https"))
                .body("headers.x-forwarded-port", is("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", notNullValue())
                .body("content-type", nullValue())
                .body("headers.accept", is("*/*"))
                .body("headers.cache-control", nullValue())
                .body("headers.postman-token", nullValue())
                .body("headers.cookie", nullValue())
                .body("url", is("https://postman-echo.com/delete"))
                .body("json", nullValue())
                .when()
                .request(Method.DELETE,"https://postman-echo.com/delete")
                .then()
                .statusCode(200);
    }


}