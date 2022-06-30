package com.nttdata.petstore;

import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.when;

public class ActualizarUsuario {

    @When("Actualizar usuario en PetStore")
    public void actualizarUsuario(String username, String firsname, String lastname){
        SerenityRest.given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": \"46245259\",\n" +
                        "  \"username\": \""+username+"\",\n" +
                        "  \"firstName\": \""+firsname+"\",\n" +
                        "  \"lastName\": \""+lastname+"\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when().put("https://petstore.swagger.io/v2/user/"+username);
    }

}
