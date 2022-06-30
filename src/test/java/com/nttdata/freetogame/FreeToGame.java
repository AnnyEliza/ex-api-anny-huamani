package com.nttdata.freetogame;

import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

public class FreeToGame {

    @When("Consultamos en FreeToGame")
    public void consultaFreeToGame(String plarform, String category){
        SerenityRest.given()
                .pathParam("plarform", plarform)
                .pathParam("category", category)
                .when().get("https://www.freetogame.com/api/games?{plarform}&{category}");
    }

}
