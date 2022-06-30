package com.nttdata.steps;
import com.nttdata.freetogame.FreeToGame;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class FreeToGameStepsDefs {

    @Steps
    FreeToGame freeToGame;

    @When("consultar plarform {string}, category {string}")
    public void consultarPlarformCategory(String plarform, String category) {
        freeToGame.consultaFreeToGame(plarform, category);
        System.out.println("VERR AQUII" + plarform + category);
    }

    @Then("el codigo de respuesta es {int}")
    public void elCodigoDeRespuestaEs(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
        System.out.println("id: " + SerenityRest.lastResponse().body().path("id").toString());
        System.out.println("title: " + SerenityRest.lastResponse().body().path("title").toString());
    }

    @Then("el codigo de respuesta de error es {int}")
    public void elCodigoDeRespuestaDeErrorEs(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }
}
