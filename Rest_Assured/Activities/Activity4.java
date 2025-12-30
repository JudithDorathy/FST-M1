package RestAssured;

import org.testng.Reporter;
import org.testng.annotations.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class GitHubSSHKeyTest {
    
    // Declare RequestSpecification object
    private static RequestSpecification requestSpec;
    
    // Declare String variable for SSH key
    private static String sshKey;
    
    // Declare int variable for SSH key ID
    private static int sshKeyId;
    
    @BeforeClass
    public void setup() {
        // Replace with your actual SSH key (truncated for example)
        sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIFoiR7b+qk9DoUub6HQ5ta1A9r4GA2F7IbijjN+mKc5i";
        
        // Replace <GitHub access token> with your actual token
        String gitHubToken = "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";
        
        // Create request specification using RequestSpecBuilder
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "token " + gitHubToken)
                .setBaseUri("https://api.github.com")
                .build();
    }
    
    @Test(priority = 1)
    public void addSSHKey() {
        // Create request body as JSON string
        String requestBody = String.format(
            "{\n" +
            "    \"title\": \"TestAPIKey\",\n" +
            "    \"key\": \"%s\"\n" +
            "}", sshKey);
        
        // Send POST request and save response
        Response response = given()
                .spec(requestSpec)
                .body(requestBody)
            .when()
                .post("/user/keys")
            .then()
                .extract().response();
        
        // Extract the SSH key ID from response and save it
        sshKeyId = response.jsonPath().getInt("id");
        
        // Add assertions
        int statusCode = response.getStatusCode();
        String keyTitle = response.jsonPath().getString("title");
        
        // Assert status code is 201 (Created)
        assert statusCode == 201 : "Expected status code 201 but got " + statusCode;
        
        // Assert key title matches what we sent
        assert "TestAPIKey".equals(keyTitle) : "Expected title 'TestAPIKey' but got '" + keyTitle + "'";
        
        // Assert key ID is extracted successfully
        assert sshKeyId > 0 : "SSH key ID should be greater than 0";
        
        Reporter.log("POST Request - SSH Key added successfully with ID: " + sshKeyId);
        Reporter.log("Response Status Code: " + statusCode);
    }
    
    @Test(priority = 2, dependsOnMethods = "addSSHKey")
    public void getSSHKey() {
        // Send GET request with path parameter for keyId
        Response response = given()
                .spec(requestSpec)
                .pathParam("keyId", sshKeyId)
            .when()
                .get("/user/keys/{keyId}")
            .then()
                .extract().response();
        
        // Print response to TestNG report
        Reporter.log("GET Request - Response for SSH Key ID: " + sshKeyId);
        Reporter.log("Response Status Code: " + response.getStatusCode());
        Reporter.log("Response Body: " + response.asPrettyString());
        
        // Add assertions
        int statusCode = response.getStatusCode();
        int responseId = response.jsonPath().getInt("id");
        
        // Assert status code is 200 (OK)
        assert statusCode == 200 : "Expected status code 200 but got " + statusCode;
        
        // Assert the retrieved key ID matches our stored ID
        assert responseId == sshKeyId : "Expected key ID " + sshKeyId + " but got " + responseId;
        
        // Assert key title
        String keyTitle = response.jsonPath().getString("title");
        assert "TestAPIKey".equals(keyTitle) : "Expected title 'TestAPIKey' but got '" + keyTitle + "'";
    }
    
    @Test(priority = 3, dependsOnMethods = "getSSHKey")
    public void deleteSSHKey() {
        // Send DELETE request with path parameter for keyId
        Response response = given()
                .spec(requestSpec)
                .pathParam("keyId", sshKeyId)
            .when()
                .delete("/user/keys/{keyId}")
            .then()
                .extract().response();
        
        // Print response to TestNG report
        Reporter.log("DELETE Request - Response for SSH Key ID: " + sshKeyId);
        Reporter.log("Response Status Code: " + response.getStatusCode());
        Reporter.log("Response Body: " + response.asString());
        
        // Add assertions
        int statusCode = response.getStatusCode();
        
        // Assert status code is 204 (No Content)
        assert statusCode == 204 : "Expected status code 204 but got " + statusCode;
        
        // Optionally verify the key is deleted by trying to GET it
        Response verifyResponse = given()
                .spec(requestSpec)
                .pathParam("keyId", sshKeyId)
            .when()
                .get("/user/keys/{keyId}");
        
        // The key should not exist anymore - expecting 404
        assert verifyResponse.getStatusCode() == 404 : 
            "Key should be deleted (404) but got status code: " + verifyResponse.getStatusCode();
    }
}