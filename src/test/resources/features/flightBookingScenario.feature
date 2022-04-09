@booking
Feature: Booking a Flight

  @Sample
  Scenario Outline: Search for a flight and book a flight
    Given User is  on the home page
    When user selects and click customer account widget

    When enter credentials and click Login button

    |email|user@phptravels.com|
    |password |  search     |
    Then User navigates to the appropriate page

    And  Search a flight by providing "<fromCity>" and "<toCity>" and date
    Then click search to see the flight list
    Then select the first available flight from the list
    Then Enter booking details "<firstName>","<lastName>","<email>", "<phone>","<address>", "<travFname>", "<travLname>", "<travNation>","<passport>" and click confrim
    Then User should be able to see the confirmation page

    Examples:

      |fromCity			|toCity	|date|firstName|lastName|email|phone|address|travFname|travLname|travNation|passport|
      |SYD	|SIN| 04-30-2022    |Sam      |Last    |test@gmail.com|043123456 |16 test address|Sam|Last|AUS|12365454|
