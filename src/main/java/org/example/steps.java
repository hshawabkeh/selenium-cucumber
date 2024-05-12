package org.example;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class steps {
    private WebDriver driver;

    @Given("User navigate to stctv page")
    public void navigatetoSTCTV() {
        String projectDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectDir + "/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://subscribe.stctv.com/sa-en?");
    }

    @When("User select {} with {} code")
    public void selectCountry(String country, String countryId) {
        WebElement countryButton = driver.findElement(By.xpath("//span[@id='country-name']"));
        WebElement countryLink = driver.findElement(By.xpath("//a[@id='" + countryId + "']"));

        if(country.equals("KSA")){
            countryButton.isDisplayed();
            countryLink.isDisplayed();
        } else {
            countryButton.click();
            countryLink.click();
        }
    }

    @Then("User validate currency is {}")
    public void validateCurrency(String expectedCurrency) {
        WebElement currency = driver.findElement(By.xpath("//div[@id='currency-lite']/i"));
        String actualCurrency = currency.getText();
        Assert.assertTrue(actualCurrency.contains(expectedCurrency));
    }

    @And("User validate subscription package for lite price is {}")
    public void validateLite(String litePrice) {
        WebElement litePackagePrice = driver.findElement(By.xpath("//div[@id='currency-lite']/b"));
        String actualLite = litePackagePrice.getText();
        Assert.assertTrue(actualLite.contains(litePrice));
    }

    @And("User validate subscription package for classic price is {}")
    public void validateClassic(String classicPrice) {
        WebElement classicPackagePrice = driver.findElement(By.xpath("//div[@id='currency-classic']/b"));
        String actualClassic = classicPackagePrice.getText();
        Assert.assertTrue(actualClassic.contains(classicPrice));
    }

    @And("User validate subscription package for premium price is {}")
    public void validatePremium(String premiumPrice) {
        WebElement premiumPackagePrice = driver.findElement(By.xpath("//div[@id='currency-premium']/b"));
        String actualPremium = premiumPackagePrice.getText();
        Assert.assertTrue(actualPremium.contains(premiumPrice));
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }

}
