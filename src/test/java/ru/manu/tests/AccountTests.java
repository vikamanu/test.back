package ru.manu.tests;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.proxy;
import static org.hamcrest.core.IsEqual.equalTo;
import javax.jws.WebParam;


public class AccountTests {
    private Object username;

    @Test
    void getAccountInfoTest() {
        given()
                .header("Authorization",proxy)
                .when()
                .get("https://api.imgur.com/3/account/{username}", username)
                .then()
                .statusCode(200);
    }



    @Test
    void getAccountInfoWithLoggingTest() {
        given()
                .header("Authorization","Bearer ed7328187fb5c0a24092507ce0415ab1a5f8f55c")
                .log()
                .method()
                .log()
                .uri()
                .when()
                .get("https://api.imgur.com/3/account/{username}")
                .prettyPeek()
                .then()
                .statusCode(200);
    }
    @Test
    void getAccountInfoWithAssertionsInGivenTest() {
        given()
                .header("Authorization","Bearer ed7328187fb5c0a24092507ce0415ab1a5f8f55c")
                .log()
                .method()
                .log()
                .uri()
                .expect()
                .statusCode(200)
                .body("data.url", equalTo(username))
                .body("success", equalTo(true))
                .body("status", equalTo(200))
                .contentType("application/json")
                .when()
                .get("https://api.imgur.com/3/account/{username}", username)
                .prettyPeek();
    }
    @Test
    void getAccountInfoWithAssertionsAfterTest() {
        Response response = given()
                .header("Authorization","Bearer ed7328187fb5c0a24092507ce0415ab1a5f8f55c")
                .log()
                .method()
                .log()
                .uri()
                .when()
                .get("https://api.imgur.com/3/account/{username}", proxy.getUsername())
                .prettyPeek();
        assertThat(response.jsonPath().get("data.url"), equalTo(username));
    }

    private void assertThat(Object o, Matcher<Object> equalTo) {
    }
}
