Feature: Login and Registration

  Scenario: Ingreso de nombre de usuario con datos almacenados en BD
    Given que estoy en la página de inicio de sesión
    When ingreso el nombre de usuario "usuario_valido" y password "password_correcto"
    Then el sistema permite el acceso exitosamente

  Scenario: Ingreso de nombre de usuario y password con datos erróneos
    Given que estoy en la página de inicio de sesión
    When ingreso el nombre de usuario "usuario_invalido" y password "password_invalido"
    Then el sistema muestra un mensaje de error

  Scenario: Registro de hora médica
    Given que estoy en la página de registro de citas
    When selecciono el horario "10:00 AM"
    And confirmo la cita
    Then el sistema registra la cita exitosamente
