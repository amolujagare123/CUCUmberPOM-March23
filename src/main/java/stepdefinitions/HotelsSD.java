package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

}
