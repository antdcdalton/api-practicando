package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class APIStepDefinitions {
    private Response response;
    private String token;



    // obtener el token
    @Given("I request a token with valid credentials")
    public void iRequestATokenWithValidCredentials(){
        //Enviar credenciales para solicitar token
        response = given()
                .header("Content-Type", "application/json")
                .body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}")
                .when()
                .post("https://reqres.in/api/login");

        //obtener respuesta del tocken y se guarda en variable
        token = response.jsonPath().getString("token");
    }

    //validando que el tocken no ese vacion
    @Then("I should receive a valid token")
    public void iShouldReceiveAValidToken() {
        // Verificar que el token no sea nulo ni vacío
        assertNotNull(token, "Token should not be null");
        assertFalse(token.isEmpty(), "Token should not be empty");
    }


   //traer todos los registros pagina dos.

    @Then("I get all register about two {string}")
    public void IGetAllRegisterAbout(String url){

        response = given()
                .header("Autorization", "Bear" + token)
                .when()
                .get(url);
    }


    // Paso 3: Verificar que el cuerpo de la respuesta contiene una lista de usuarios
    @Then("the response body should contain user data")
    public void theResponseBodyShouldContainUserData() {
        // Verificar que la respuesta contenga datos de usuarios
        assertTrue(response.getBody().asString().contains("data"));
    }


}
