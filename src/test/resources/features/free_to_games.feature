Feature: Examen Anny Huamani Zapata

  @Anny1
  Scenario: Validar status 200

    When consultar plarform "pc", category "shooter"
    Then el codigo de respuesta es 200

  @Anny2
  Scenario: Validar status 404

    When consultar plarform "pc", category "123"
    Then el codigo de respuesta de error es 404