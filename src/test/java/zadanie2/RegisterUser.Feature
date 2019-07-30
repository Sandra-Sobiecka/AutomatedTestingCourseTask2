Feature: Registration

  Scenario Outline: user must register onto website Codersguru

    Given an open https://tester.codersguru.pl website

    When click zaloz konto

    And  type in user inputs "<emailAddress>""<name>""<lastName>","<password>""<city>" "<zip>""<street>""<houseNumber>"

    And click checkbox

    And click Zarestruj  button

    Then should be registered on website

    Examples:
      | emailAddress         | name | lastName | password  | city         | zip    | street | houseNumber
      | j.doe@mailinator.com | jdoe | kwack    | Warsaw123 | clearwater   | qwerty | Leeds  | 24
      | j.dee@mailinator.com | jdoe | Dluga    | Warsaw123 | philadelphia | qwerty | Tomato | 4
      | j.dee@mailinetor.com | jdae | Dlufa    | Warsaw123 | philadelphia | qwerty | Tomato | 4
      | j.dee@mailonetor.com | jdae | Dlufa    | Warsaw123 | philadelphia | qwerty | Tomato | 4
      | j.dee@mailonetpr.com | jdae | Dlufa    | Warsaw123 | philadelphia | qwerty | Tomato | 4