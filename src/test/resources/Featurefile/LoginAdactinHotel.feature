Feature: To verify adactin hotel

  Scenario Outline: User should login the page using the data given by client
    Given Start up the adactin webpage
    When User should enter the "<userName>","<password>"
    And After logged in fill the datas to select hotel "<location>","<selectHotel>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>","<childrenPerRoom>"
    And After fill the datas select the hotel
    And Fill up the personal details "<firstName>","<lastName>","<billingAddress>","<creditCardNumber>","<creditCardType>","<expMonth>","<expYear>","<cvvNumber>"
    Then Once we done booking we get order id which will display on console

    Examples: 
      | userName   | password        | location | selectHotel   | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress | creditCardNumber | creditCardType | expMonth | expYear | cvvNumber |
      | Akilan1008 | Iphone@11promax | London   | Hotel Cornice | Deluxe   | 2 - Two   | 04/01/2023  | 05/01/2023   | 2 - Two       | 1 - One         | Akilan    | Arumugam | Chennai        | 1234567890123456 | VISA           | August   |    2022 |       505 |

  Scenario Outline: b
    Given Start up the adactin webpage
    When User should enter the "<userName>","<password>"
    And After logged in fill the datas to select hotel "<location>","<selectHotel>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>","<childrenPerRoom>"
    And After fill the datas select the hotel
    And Fill up the personal details "<firstName>","<lastName>","<billingAddress>","<creditCardNumber>","<creditCardType>","<expMonth>","<expYear>","<cvvNumber>"
    Then Once we done booking we get order id which will display on console

    Examples: 
      | userName   | password        | location | selectHotel   | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress | creditCardNumber | creditCardType | expMonth | expYear | cvvNumber |
      | Akilan1009 | Iphone@11promax | London   | Hotel Cornice | Deluxe   | 2 - Two   | 04/01/2023  | 05/01/2023   | 2 - Two       | 1 - One         | Akilan    | Arumugam | Chennai        | 1234567890123456 | VISA           | August   |    2022 |       505 |

  Scenario Outline: c
    Given Start up the adactin webpage
    When User should enter the "<userName>","<password>"
    And After logged in fill the datas to select hotel "<location>","<selectHotel>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>","<childrenPerRoom>"
    And After fill the datas select the hotel
    And Fill up the personal details "<firstName>","<lastName>","<billingAddress>","<creditCardNumber>","<creditCardType>","<expMonth>","<expYear>","<cvvNumber>"
    Then Once we done booking we get order id which will display on console

    Examples: 
      | userName   | password        | location | selectHotel   | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress | creditCardNumber | creditCardType | expMonth | expYear | cvvNumber |
      | Akilan1007 | Iphone@11promax | London   | Hotel Cornice | Deluxe   | 2 - Two   | 04/01/2023  | 05/01/2023   | 2 - Two       | 1 - One         | Akilan    | Arumugam | Chennai        | 1234567890123456 | VISA           | August   |    2022 |       505 |
