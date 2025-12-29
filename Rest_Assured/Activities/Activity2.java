package RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Activity2 {
    
    // No need for @BeforeClass setup if not using parser
    
    @Test(priority=1)
    public void addNewUserFromFile() throws IOException {
        // Try multiple possible paths
        String[] possiblePaths = {
            "src/main/resources/userinfo.json",
            "src/test/resources/userinfo.json",
            "userinfo.json"
        };
        
        FileInputStream inputJSON = null;
        File jsonFile = null;
        
        for (String path : possiblePaths) {
            jsonFile = new File(path);
            if (jsonFile.exists()) {
                System.out.println("Found file at: " + jsonFile.getAbsolutePath());
                inputJSON = new FileInputStream(jsonFile);
                break;
            }
        }
        
        if (inputJSON == null) {
            throw new IOException("userinfo.json not found in any location");
        }

        Response response = given()
            .baseUri("https://petstore.swagger.io/v2")
            .header("Content-Type", "application/json")
            .body(inputJSON) 
            .when().post("/user");

        inputJSON.close();

        // Debug output
        System.out.println("POST Response: " + response.asPrettyString());
        
        // Assertions
        response.then().statusCode(200);
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("9901"));
    }
    
    @Test(priority=2)
    public void getUserInfo() {
        Response response = given()
            .baseUri("https://petstore.swagger.io/v2")
            .header("Content-Type", "application/json")
            .pathParam("username", "justinc")
            .when().get("/user/{username}");
        
        System.out.println("GET Response: " + response.asPrettyString());
        
        // Save response to file
        File outputDir = new File("test-output");
        if (!outputDir.exists()) {
            outputDir.mkdir();
        }
        
        File outputJSON = new File("test-output/userGETResponse.json");
        
        try {
            String resBody = response.asPrettyString();
            FileWriter writer = new FileWriter(outputJSON);
            writer.write(resBody);
            writer.close();
            System.out.println("Response saved to: " + outputJSON.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Assertions
        response.then().statusCode(200);
        response.then().body("id", equalTo(9901));
        response.then().body("username", equalTo("justinc"));
    }
    
    @Test(priority=3)
    public void deleteUser() {
        Response response = given()
            .baseUri("https://petstore.swagger.io/v2")
            .header("Content-Type", "application/json")
            .pathParam("username", "justinc")
            .when().delete("/user/{username}");

        System.out.println("DELETE Response: " + response.asPrettyString());
        
        response.then().statusCode(200);
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("justinc"));
    }
}