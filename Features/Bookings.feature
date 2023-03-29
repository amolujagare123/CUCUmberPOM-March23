Feature: All bookings.com scenarios

  https://www.booking.com/searchresults.html?ss=Goa&ssne=Goa&ssne_untouched=Goa&label=gog235jc-1DCAEoggI46AdIM1gDaGyIAQGYATG4ARfIAQzYAQPoAQH4AQqIAgGoAgO4AqCxsZ0GwAIB0gIkYjlhNTBmNWEtZDEzMS00OGU5LTlkZGEtNTBiOTZkZWU1YTE42AIE4AIB&sid=3a835ee8169eab4b6a1c4a9772dcba43&aid=397594&lang=en-us&sb=1&src_elem=sb&src=index&dest_id=4127&dest_type=region&group_adults=2&no_rooms=1&group_children=0&sb_travel_purpose=leisure


# 1
  @starverify
  Scenario Outline: Verify user can only view the result by selected property class
    Given I am on default locations search result screen
    When I select option for stars as <stars>
    Then I verify system displays only <stars> hotels on search result
    Examples:
      | stars   |
      | 5 stars |
      | 4 stars |
      | 3 stars |


#2

  @maxAmount
  Scenario: check the hotel prices are below a certain amount
    Given I am on default locations search result screen
    Then I verify system displays all hotels within "40000" amount


#3
  @hotelsSearch
  Scenario: verify given hotel is present in the list
    Given I am on default locations search result screen
    Then I verify "swagat" is within the search result
