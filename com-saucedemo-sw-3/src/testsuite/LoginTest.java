package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValid(){

        //Find email field element
        sendTextToElement(By.name("user-name"), "standard_user");

        //Find password field element
        sendTextToElement(By.id("password"),"secret_sauce");

        //Find login link and click on it
        clickOnElement(By.xpath("//input[@id='login-button']"));

        //Verify the text “PRODUCTS”
        //This is from requirement
        String expectedMessage = "PRODUCTS";

        //actual message
        String actualMessage = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));

        //Valiadte expected message and actual message
        Assert.assertEquals("unable to navigate on product page", expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
       //Find email field element
        sendTextToElement(By.name("user-name"), "standard_user");

        //Find password field element
        sendTextToElement(By.id("password"), "secret_sauce");

        //Find login link and click on it

        clickOnElement(By.xpath("//input[@id='login-button']"));

        //Verify that six products are displayed on page
        //This is from requirement
        int expectedMessage = 6;
        List<WebElement> Items = listOfWebElementsList(By.xpath("//div[@class='inventory_item']"));
        int actualCountedItems = Items.size();

        //Validate expected and actual message
        Assert.assertEquals("unable to display 6 products", expectedMessage, actualCountedItems);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
