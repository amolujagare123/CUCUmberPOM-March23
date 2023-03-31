package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SearchResult;

import java.util.ArrayList;

import static stepdefinitions.SharedSD.getDriver;

public class HotelsSD {
    SearchResult searchResult = new SearchResult();
    @Given("I am on default locations search result screen")
    public void i_am_on_default_locations_search_result_screen() {

        Assert.assertEquals("This is not a correct page"
        ,"Booking.com : Hotels in Goa . Book your hotel now!"
                ,getDriver().getTitle());
    }
    @Then("I verify {string} is within the search result")
    public void i_verify_is_within_the_search_result(String hotelName) {

        System.out.println("hotelName="+hotelName);
        ArrayList<String> hotelsList = searchResult.getAllHotels();
        boolean flag = false;
        for (int i=0;i<hotelsList.size();i++){

                String currentHotel = hotelsList.get(i);

                if (currentHotel.contains(hotelName))
                {
                    flag = true;
                }

        }

        Assert.assertTrue("The given  hotel is not in the list",flag);
     }

    @When("^I select option for stars as (.+)$")
    public void i_select_option_for_stars_as(String stars)  {

        //String stars = "5 stars" ;

        searchResult.clickStarRating(stars.split(" ")[0]);

    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) {
              // 4 Starts

        int expectedStarRating =  Integer.parseInt(stars.split(" ")[0]);
        int actualStarRating = searchResult.getRating();

        System.out.println("expectedStarRating="+expectedStarRating);
        System.out.println("actualStarRating="+actualStarRating);

        Assert.assertEquals("all ratings are not same",expectedStarRating,actualStarRating);

    }

    @Then("I verify system displays all hotels within {string} amount")
    public void iVerifySystemDisplaysAllHotelsWithinAmount(String maxAmountStr) {

        int expectedMaxAmount = Integer.parseInt(maxAmountStr);

        ArrayList<Integer> priceList = searchResult.getAllPrices();
        System.out.println(priceList);
        boolean flag = true;
        for (int i=0;i<priceList.size();i++)
        {
            if (priceList.get(i)>expectedMaxAmount)
                flag=false;
        }

        Assert.assertTrue("Some prices are greater than:"+expectedMaxAmount,flag);
    }
}
