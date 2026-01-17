Feature: Registro del usuario
  Como usuario se podra dar de alta el portal

@TC001
  Scenario: Registro de cuenta
    Given Ingreso al portal
    When Tiempo de espera 3
    And Clic en el menu "REGISTER"
    And Tiempo de espera 4
    And Type en el campo "firstName" "Raul"
    And Type en el campo "lastName" "Lopez"
    And Type en el campo "phone" "5611258987"
    And Type en el campo "userName" "raul.lopez@mailranate.com"
    And Type en el campo "address1" "las vegas no. 9"
    And Type en el campo "city" "Aguacalisntes"
    And Type en el campo "state" "Aguascalietnes"
    And Type en el campo "postalCode" "589456"
    And Seleccionar opcion "MEXICO"
    And Cerrar ventana emergente
    And Type en el campo "email" "raullopez"
    And Type en el campo "password" "abcd1234"
    And Type en el campo "confirmPassword" "abcd1234"
    Then click en el boton "submit"
    And Tiempo de espera 3
    And Flujo terminado
   
    