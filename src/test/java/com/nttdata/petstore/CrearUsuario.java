package com.nttdata.petstore;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CrearUsuario {
    private static String CREATE_USER ="https://petstore.swagger.io/v2/user";

    @Step("Cear usuario {0} en PetStore")
    public void crearUsuario(String username, int id, String lastname, String firsname, int password){
        SerenityRest.given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": \""+id+"\",\n" +
                        "  \"username\": \""+username+"\",\n" +
                        "  \"firstName\": \""+firsname+"\",\n" +
                        "  \"lastName\": \""+lastname+"\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \""+password+"\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .post(CREATE_USER);

    }
}
