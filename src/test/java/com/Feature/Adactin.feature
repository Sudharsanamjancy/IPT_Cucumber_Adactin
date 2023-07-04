Feature: Hotel Booking in Adactin Application

  @smokeTest
  Scenario Outline: Login
    Given : user Launch The Application
    When : User enter "<username>" in User field
    And : User enter "<password>" in Password field
    Then : User click the login button and navigate to Homepage

    Examples: 
      | username    | password |
      | KANNAN       |    12345 |
      | sujan       |   12345667 |
      | sudharsanam | 8XXIFP   |

  @sanityTest
  Scenario: Search Hotel
    When : User select the "London" in location
    And : User select the "Hotel Sunshine" in Hotel
    And : User select the "Double" in Roomtype
    And : User select the "5" in No of Rooms
    And : User select the "15/01/2022" in Checkin date
    And : User select the "16/01/2022" in Checkout date
    And : User select the "2" in Adults per room
    And : User select the "1" in Children Per room
    Then : User click on search button and navigate to select hotel

  @sanityTest
  Scenario: Select Hotel
    When : User select the hotel
    Then : User click on continue Button and navigate to Book a hotel

  @sanityTest
  Scenario: Select Book a Hotel
    When : User enter "Sudhar" in the Firstname
    And : User enter "Sanam" in the Lastname
    And : User enter "Ashatabujam Road" in the Billing address
    And : User enter  cardnumber in the Creditcard Number
    And : User select  cardtype in the Creditcard Type
    And : User select month in  the expiry month
    And : User select year in the expiry year
    And : user enter cvv in CVV number
    Then : user Click on Booknow Button and Navigate to Booking Confirmation
