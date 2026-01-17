Feature: Abrir sesion del usuario
  Usuario previamente dado de alta, podra abrir sesion en el portal 


@TC002
  Scenario: Abrir sesion
    Given Ingreso al portal     
    And Type en el campo "userName" "raullopez"   
    And Type en el campo "password" "abcd1234"
    Then click en el boton "submit"
   