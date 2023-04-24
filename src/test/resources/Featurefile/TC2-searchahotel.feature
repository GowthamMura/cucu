Feature: Verifying the Adactin Search Hotel Details

  Scenario Outline: Verifying the Search Valid Hotel Room
    Given User is on the Adactin Page
    When User Should Perform Login "<userName>" and "<password>"
    Then User Should Verify After Login Success Message "Hello Akilan1008!"
    And User should Search the Hotel Details "<Location>","<hotels>","<roomType>","<noOfRooms>","<CheckInDate>","<CheckOutDate>","<adultsRoom>" and "<childrenRoom>"
    Then User should verify After Search Hotel Get the Success Message "Select Hotel"

    Examples: 
      | userName   | password        | Location  | hotels         | roomType | noOfRooms | CheckInDate | CheckOutDate | adultsRoom | childrenRoom |
      | Akilan1008 | Iphone@11promax | Melbourne | Hotel Sunshine | Double   | 2 - Two   | 14/12/2022  | 15/12/2022   | 2 - Two    | 1 - One      |

  Scenario Outline: Verifying the Valid Hotel Room with Mandatory Fields
    Given User is on the Adactin Page
    When User Should Perform Login "<userName>" and "<password>"
    Then User Should Verify After Login Success Message "Hello Akilan1008!"
    And User should Entry Mandatory Details "<location>","<noOfRooms>","<CheckInDate>","<CheckOutDate>" and "<adultsRoom>"
    Then User should verify After Search Hotel Get the Success Message "Select Hotel"

    Examples: 
      | userName   | password        | location  | noOfRooms | CheckInDate | CheckOutDate | adultsRoom |
      | Akilan1008 | Iphone@11promax | Melbourne | 2 - Two   | 14/12/2022  | 15/12/2022   | 2 - Two    |

  Scenario Outline: Verifying the Search hotel with Invalid Check-IN and Check-OUT Dates
    Given User is on the Adactin Page
    When User Should Perform Login "<userName>" and "<password>"
    Then User Should Verify After Login Success Message "Hello Akilan1008!"
    And User should Search the Hotel Details "<location>","<hotels>","<roomType>","<noOfRooms>","<CheckInDate>","<CheckOutDate>","<adultsRoom>" and "<childrenRoom>"
    Then User should verify After Search Hotel Get the Error Message "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName   | password        | location  | hotels         | roomType | noOfRooms | CheckInDate | CheckOutDate | adultsRoom | childrenRoom |
      | Akilan1008 | Iphone@11promax | Melbourne | Hotel Sunshine | Double   | 2 - Two   | 15/12/2025  | 14/12/2022   | 2 - Two    | 1 - One      |

  Scenario Outline: Verifying the Search hotel without entry fields
    Given User is on the Adactin Page
    When User Should Perform Login "<userName>" and "<password>"
    Then User Should Verify After Login Success Message "Hello Akilan1008!"
    And User should select search button
    Then User should verify After Search Hotel Get the Error message "Please Select a Location"

    Examples: 
      | userName   | password        |
      | Akilan1008 | Iphone@11promax |
