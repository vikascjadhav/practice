package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;


@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
       /*  given()
          .when().get("/greet/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive")); */
    }

}