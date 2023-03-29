package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class SearchResult extends Base {

    // driver.findElement
    // @FindBy
    // locator

    By allHotels = By.xpath("//div[@data-testid='title']");
    public ArrayList<String> getAllHotels()
    {
        return getElementTextList(allHotels);
    }
}
