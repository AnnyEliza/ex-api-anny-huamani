Feature: Crear usuario PetStore

  @test1
  Scenario: Crear usuario

    When creo el usuario con nombre de usuario "annyh", id 46245259, firsname "huamani", lastname "zapata", password 123456
    Then el codigo de respuesta es  200
    And el type es "unknown"

  @test2
  Scenario: Consultar usuario

    When consulto el usuario con username "annyh"
    Then el codigo de respuesta es  200
    And el id es 46245259

  @test3
  Scenario: Login usuario

    When el usuario realiza login con username "annyh" y password 123456
    Then el codigo de respuesta es  200


  @test4
  Scenario: Actualizar usuario

    When el usuario actualiza datos de username "annyh", actualizo firsname "eliza", lastname "mallqui"
    Then el codigo de respuesta es  200