package RestAssured;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.V4Pact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class Activity5 {
    // Set the headers
    Map<String, String> headers = new HashMap<>();

    // Create the fragment for POST request
    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPostFragment(PactDslWithProvider builder) {
        // Set headers
        headers.put("Content-Type", "application/json");
        
        // Create the JSON body
        PactDslJsonBody reqResBody = new PactDslJsonBody()
            .numberType("id", 123)
            .stringType("firstName", "Judith")
            .stringType("lastName", "Dorathy")
            .stringType("email", "judith.dorathy@example.com");

        // Create the contract(Pact)
        return builder.given("POST Request")
            .uponReceiving("A request to add a user")
                .method("POST")
                .path("/api/users")
                .headers(headers)
                .body(reqResBody)
            .willRespondWith()
                .status(201)
                .headers(headers)
                .body(reqResBody)
            .toPact();
    }

    // Create the fragment for GET request
    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createGetFragment(PactDslWithProvider builder) {
        // Set headers
        headers.put("Content-Type", "application/json");
        
        // Create the JSON body for response
        PactDslJsonBody responseBody = new PactDslJsonBody()
            .numberType("id", 123)
            .stringType("firstName", "Judith")
            .stringType("lastName", "Dorathy")
            .stringType("email", "judith.dorathy@example.com");

        // Create the contract(Pact)
        return builder.given("GET Request")
            .uponReceiving("A request to get a user")
                .method("GET")
                .path("/api/users/123")
                .headers(headers)
            .willRespondWith()
                .status(200)
                .headers(headers)
                .body(responseBody)
            .toPact();
    }

    // Create the fragment for DELETE request
    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public V4Pact createDeleteFragment(PactDslWithProvider builder) {
        // Set headers
        headers.put("Content-Type", "application/json");
        
        // Create the contract(Pact)
        return builder.given("DELETE Request")
            .uponReceiving("A request to delete a user")
                .method("DELETE")
                .path("/api/users/123")
                .headers(headers)
            .willRespondWith()
                .status(204)
            .toPact(V4Pact.class);
    }

    // Consumer test with mock provider - POST
    @Test
    @PactTestFor(providerName = "UserProvider", pactMethod = "createPostFragment")
    public void postRequestTest(MockServer mockServer) {
        // Create a request body
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 123);
        reqBody.put("firstName", "Judith");
        reqBody.put("lastName", "Dorathy");
        reqBody.put("email", "judith.dorathy@example.com");

        // Send request, get response, assert response
        given()
            .baseUri(mockServer.getUrl())
            .headers(headers)
            .body(reqBody)
            .log().all()
        .when()
            .post("/api/users")
        .then()
            .log().all()
            .statusCode(201)
            .body("firstName", equalTo("Judith"))
            .body("lastName", equalTo("Dorathy"))
            .body("email", equalTo("judith.dorathy@example.com"));
    }

    // Consumer test with mock provider - GET
    @Test
    @PactTestFor(providerName = "UserProvider", pactMethod = "createGetFragment")
    public void getRequestTest(MockServer mockServer) {
        // Send request, get response, assert response
        given()
            .baseUri(mockServer.getUrl())
            .headers(headers)
            .log().all()
        .when()
            .get("/api/users/123")
        .then()
            .statusCode(200)
            .log().all()
            .body("firstName", equalTo("Judith"))
            .body("lastName", equalTo("Dorathy"))
            .body("email", equalTo("judith.dorathy@example.com"));
    }

    // Consumer test with mock provider - DELETE
    @Test
    @PactTestFor(providerName = "UserProvider", pactMethod = "createDeleteFragment")
    public void deleteRequestTest(MockServer mockServer) {
        // Send request, get response, assert response
        given()
            .baseUri(mockServer.getUrl())
            .headers(headers)
            .log().all()
        .when()
            .delete("/api/users/123")
        .then()
            .statusCode(204)
            .log().all();
    }
}