Feature: Sign in

  Scenario: Login with correct credentials
    Given browser started
    And mail.ru page is loaded
    When I type "itacademyselenium" to id input
    And I select "@mail.ru" in dropdown list
    And I click password button
    And I type "6MHXZS/O" to password input
    And I click submit button
    Then I see "itacademyselenium@mail.ru" id

  Scenario Outline: Login with incorrect password
    Given browser started
    And mail.ru page is loaded
    When I type "<login>" to id input
    And I select "<domain>" in dropdown list
    And I click password button
    And I type "<password>" to password input
    And I click submit button
    Then I see "<errorMessage>"
    Examples:
      | login             | domain      | password          | errorMessage            |
      | itacademyselenium | @mail.ru    | incorrectPassword | Неверное имя или пароль |
      | itacademyselenium | @mail.ru    |                   | Введите пароль          |

  Scenario Outline: Login with incorrect email
    Given browser started
    And mail.ru page is loaded
    When I type "<login>" to id input
    And I select "<domain>" in dropdown list
    And I click password button
    Then I see "<errorMessage>"
    Examples:
      | login             | domain   | errorMessage       |
      | incorrectLogin    | @mail.ru | Неверное имя ящика |
      | itacademyselenium | @list.ru | Неверное имя ящика |
      |                   | @mail.ru | Введите имя ящика  |