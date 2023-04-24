Feature: Verifying the Adactin Book Hotel Details

  Scenario Outline: Verifying the Book Hotel with Entering Valid Details
    Given User is on the Adactin Page
    When User Should Perform Login "<userName>" and "<password>"
    Then User Should Verify After Login Success Message "Hello Akilan1008!"
    And User should Search the Hotel Details "<location>","<hotels>","<roomType>","<noOfRooms>","<CheckInDate>","<CheckOutDate>","<adultsRoom>" and "<childrenRoom>"
    Then User should verify After Search Hotel Get the Success Message "Select Hotel"
    And User Should perform select hotel
    Then User Should Verify After Select Hotel Success Message "Book A Hotel"
    And User Should Book the Hotel "<firstName>","<lastName>" and "<billingAddress>"
      | cc_num           | cc_type          | cc_exp_month | cc_exp_year | cc_cvv |
      | 9876543215671234 | American Express | June         |        2022 |    897 |
      | 9876543215671234 | VISA             | July         |        2021 |    897 |
      | 9876543215671234 | Master Card      | May          |        2020 |    897 |
      | 9876543215671234 | Other            | April        |        2019 |    897 |
    Then User Should Verify After Book the Hotel Get Success Message "Booking Confirmation" and Save the Generated OrderId

    Examples: 
      | userName   | password        | location  | hotels         | roomType | noOfRooms | CheckInDate | CheckOutDate | adultsRoom | childrenRoom | firstName | lastName | billingAddress |
      | Akilan1008 | Iphone@11promax | Melbourne | Hotel Sunshine | Double   | 2 - Two   | 14/12/2022  | 15/12/2022   | 2 - Two    | 1 - One      | Akilan    | Arumugam | Chennai        |

  Scenario Outline: Verifying the Book Hotel without Entering any Fields
    Given User is on the Adactin Page
    When User Should Perform Login "<userName>" and "<password>"
    Then User Should Verify After Login Success Message "Hello Akilan1008!"
    And User should Search the Hotel Details "<location>","<hotels>","<roomType>","<noOfRooms>","<CheckInDate>","<CheckOutDate>","<adultsRoom>" and "<childrenRoom>"
    Then User should verify After Search Hotel Get the Success Message "Select Hotel"
    And User Should perform select hotel
    Then User Should Verify After Select Hotel Success Message "Book A Hotel"
    And User Should Select the Book Now button without Entering any Fields
    Then User Should Verify Error Message "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName   | password        | location  | hotels         | roomType | noOfRooms | CheckInDate | CheckOutDate | adultsRoom | childrenRoom |
      | Akilan1008 | Iphone@11promax | Melbourne | Hotel Sunshine | Double   | 2 - Two   | 14/12/2022  | 15/12/2022   | 2 - Two    | 1 - One      |
