package com.nttdata.petstore;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.given;

public class LoginUsuario {

    //private static String GET_USER ="https://petstore.swagger.io/v2/user/login";

    @When("Login usuario en PetStore")
    public void loginUsuario(String username, int password){
        SerenityRest.given()
                .pathParam("username", username)
                .pathParam("password", password)
                .when().get("https://petstore.swagger.io/v2/user/login?{username}&{password}");
    }

}
