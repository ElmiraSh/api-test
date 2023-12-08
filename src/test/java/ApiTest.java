import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

public class ApiTest {

    @Test
    void checkTotalMini(){
        get("https://selenoid.autotests.cloud/status")
                 .then()
                .body("total",is(21));
    }
@Test
void checkTotalwithLogs(){
        given()
                .log().all()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().all()
                .statusCode((200))
                .body("total",is (20))
        .body("browser.chrome",hasKey ("100.0"));
}
}
//https://selenoid.autotests.cloud/status