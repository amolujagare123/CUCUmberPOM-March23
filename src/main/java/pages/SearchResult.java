package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static stepdefinitions.SharedSD.getDriver;

public class SearchResult extends Base {

    // driver.findElement
    // @FindBy
    // locator

    By allHotels = By.xpath("//div[@data-testid='title']");
    public ArrayList<String> getAllHotels()
    {
        return getElementTextList(allHotels);
    }

    public void clickStarRating(String star)
    {
        By rating  = By.xpath("//input[@name='class="+star+"']");
        clickOn(rating);
        getDriver().navigate().refresh();
    }

   // By ratingElement = By.xpath("//div[contains(@aria-label,'out of 5')]");

   /* public ArrayList<Integer> getHotelsRatings()
    {
        List<WebElement> wbList = getDriver().findElements(ratingElement);

        System.out.println(wbList.size());
        ArrayList<Integer> ratingList = new ArrayList<>();


        for (int i=0;i< wbList.size();i++)
        {
            String areaLabel = wbList.get(i).getAttribute("aria-label"); // "4 out of 5"
            String ratingStr  = areaLabel.split(" ")[0]; // "4"
            int rating = 0;
            try
            {
                rating = Integer.parseInt(ratingStr); // try .. catch
            }
            catch (Exception e)
            {

            }
            ratingList.add(rating);
        }

        return ratingList;
    }*/

    By allStars = By.xpath("//div[contains(@data-testid,'rating')]/span");
    //By allHotels = By.xpath("//div[contains(@data-testid,'rating')]/span");
    public int getRating()
    {
        int allHotelsCount = getDriver().findElements(allHotels).size();
        System.out.println("allHotelsCount="+allHotelsCount);
        int allStarsCount = getDriver().findElements(allStars).size();
        System.out.println("allStarsCount="+allStarsCount);
        return  allStarsCount / allHotelsCount ;
    }


    By priceList = By.xpath("//span[@data-testid='price-and-discounted-price']");
    public ArrayList<Integer> getAllPrices()
    {
        ArrayList<Integer> priceListInt = new ArrayList<Integer>();
        ArrayList<String> priceTxtList = getElementTextList(priceList);
        System.out.println(priceTxtList);
        int rawPriceInt =0 ;
        for (int i=0;i<priceTxtList.size();i++)
        {
            String rawPrice = priceTxtList.get(i); // ₹ 3,960
            String rawPriceWithoutRupeeSymbol = rawPrice.substring(2); // 3,960
            String rawPriceStr = rawPriceWithoutRupeeSymbol.replace(",",""); // 3960
            try {
                rawPriceInt = Integer.parseInt(rawPriceStr);
            }
            catch (Exception e)
            {

            }
            priceListInt.add(rawPriceInt);
        }

        return priceListInt;
    }
}
