Feature: Verifying the Adactin Hotel Cancel Order ID

  Scenario Outline: Verifying to Cancel the Generated Order Id
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
    And User Should Cancel the Generated Order Id
    Then User Should Verify After Cancel Order Id Get success Message "The booking has been cancelled."

    Examples: 
      | userName   | password        | location  | hotels         | roomType | noOfRooms | CheckInDate | CheckOutDate | adultsRoom | childrenRoom | firstName | lastName | billingAddress |
      | Akilan1008 | Iphone@11promax | Melbourne | Hotel Sunshine | Double   | 2 - Two   | 14/12/2022  | 15/12/2022   | 2 - Two    | 1 - One      | Akilan    | Arumugam | Chennai        |

  Scenario Outline: Verifying to Cancel Existing the Order Id
    Given User is on the Adactin Page
    When User Should Perform Login "<userName>" and "<password>"
    Then User Should Verify After Login Success Message "Hello Akilan1008!"
    And User Should Cancel the Existing Order Id "<orderId>"
    Then User Should Verify After Cancel Order Id Get success Message "The booking has been cancelled."

    Examples: 
      | userName   | password        | orderId    |
      | Akilan1008 | Iphone@11promax | R3463N50J6 |
