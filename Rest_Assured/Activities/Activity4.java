package RestAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity4 {
    
    // Declare request specification
    RequestSpecification requestSpec;
    
    // Declare response specification
    ResponseSpecification responseSpec;

    @BeforeClass
    public void setUp() {
        // Create request specification
        requestSpec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri("https://petstore.swagger.io/v2")
            .build();
            
        // Create response specification
        responseSpec = new ResponseSpecBuilder()
            // Check status code in response
            .expectStatusCode(200)
            // Check response content type
            .expectContentType("application/json")
            // Check if response contains status property with value "alive"
            // Note: You might want to adjust this based on actual API response
            .expectBody("status", equalTo("alive"))
            // Build response specification
            .build();
    }

    @Test
    public void testPet1() {
        Response response = 
            given()
                .spec(requestSpec) // Use requestSpec
                .pathParam("petId", "77232") // Set path parameter
            .when()
                .get("/pet/{petId}"); // Send GET request

        // Print response
        String body = response.getBody().asPrettyString();
        System.out.println("Response for petId 77232:");
        System.out.println(body);

        // Assertion with response specification
        response.then().spec(responseSpec);
        
        // Additional specific assertion
        response.then().body("name", equalTo("Riley"));
    }

    @Test
    public void testPet2() {
        Response response = 
            given()
                .spec(requestSpec) // Use requestSpec
                .pathParam("petId", "77233") // Set path parameter
            .when()
                .get("/pet/{petId}"); // Send GET request

        // Print response
        String body = response.getBody().asPrettyString();
        System.out.println("\nResponse for petId 77233:");
        System.out.println(body);

        // Assertion with response specification
        response.then().spec(responseSpec);
        
        // Additional specific assertion
        response.then().body("name", equalTo("Hansel"));
    }
}