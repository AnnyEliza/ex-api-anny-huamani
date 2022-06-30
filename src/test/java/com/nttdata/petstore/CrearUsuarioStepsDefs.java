package com.nttdata.petstore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearUsuarioStepsDefs {

    @Steps
    CrearUsuario crearUsuario;
    @Steps
    LoginUsuario loginUsuario;
    @Steps
    ActualizarUsuario actualizarUsuario;

    @When("creo el usuario con nombre de usuario {string}, id {int}, firsname {string}, lastname {string}, password {int}")
    public void creoElUsuarioConNombreDeUsuarioIdFirsnameLastnamePassword(String username, int id, String firsname, String lastname, int password) {
        crearUsuario.crearUsuario(username, id, firsname, lastname, password);
    }

    @Then("el codigo de respuesta es  {int}")
    public void elCodigoDeRespuestaEs(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @And("el type es {string}")
    public void elTypeEs(String type) {
        restAssuredThat(response -> response.body("'type'", equalTo(type)));
        System.out.println("Type: " + SerenityRest.lastResponse().body().path("type").toString());
    }

    @When("consulto el usuario con username {string}")
    public void consultoElUsuarioConUsername(String username) {
        when().get("https://petstore.swagger.io/v2/user/"+username);
        //consultarUsuario.consultarUsuario(username);
    }

    @And("el id es {int}")
    public void elIdEs(int id) {
        restAssuredThat(response -> response.body("'id'", equalTo(id)));
    }

    @When("el usuario realiza login con username {string} y password {int}")
    public void elUsuarioRealizaLoginConUsernameYPassword(String username, int password) {
        loginUsuario.loginUsuario(username, password);
        /*given().pathParam("username", username)
                .pathParam("password", password)
                .when().get("https://petstore.swagger.io/v2/user/login?{username}&{password}");*/
    }

    @Given("el usuario actualiza datos de username {string}")
    public void elUsuarioActualizaDatosDeUsername(String username) {
        when().put("https://petstore.swagger.io/v2/user/"+username);
    }

    @When("el usuario actualiza datos de username {string}, actualizo firsname {string}, lastname {string}")
    public void elUsuarioActualizaDatosDeUsernameActualizoFirsnameLastname(String username, String firsname, String lastname) {
        actualizarUsuario.actualizarUsuario(username, firsname, lastname);
    }


}
