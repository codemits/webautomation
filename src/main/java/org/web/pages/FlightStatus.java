package org.web.pages;

import org.web.base.TestBase;
import org.web.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FlightStatus extends TestBase {
    public FlightStatus() {
        PageFactory.initElements(driver, this);
    }


    //public pageURL()
    @FindBy(css = ".a-header-logo")
    private WebElement logoImage;

    @FindBy(css = ".flightstatus")
    private WebElement flightStatusSection;

    @FindBy(css = "div[class*='origin']")
    private WebElement departInput;

    @FindBy(css = "input[aria-label = 'Departure airport']")
    private WebElement departDrop;


    @FindBy(css = "div[class*='destination']")
    private WebElement destinationInput;

    @FindBy(css = "input[aria-label = 'Destination airport']")
    private WebElement destinationDrop;

    @FindBy(xpath = "//div[@name='departureDate']")
    private WebElement departDateField;

    @FindBy(css = ".fieldset-form-footer button[data-component-name='cta']")
    private WebElement showFlightStatusButton;

    @FindBy(xpath="//div[contains(@class, 'display-info')]//h2")
    private WebElement textOfTheStatus;

    @FindBy(css = "button[class*='cookie-consent--cta-accept']")
    private WebElement cookieButton;

    long timeUnitToWait = 60;

    public Boolean isLogoImageDisplayed() {
        return TestUtil.isDisplayedForElement(driver, logoImage, timeUnitToWait);
    }

    public Boolean isFlightStatusSectionVisible() {
        return TestUtil.isDisplayedForElement(driver, flightStatusSection, timeUnitToWait);
    }

    private void selectDepart(String airportCode) {
        TestUtil.isDisplayedForElement(driver, departInput, timeUnitToWait);
        departInput.click();
        TestUtil.isDisplayedForElement(driver, departDrop, timeUnitToWait);
        departDrop.sendKeys(airportCode);
        TestUtil.isDisplayedForElement(driver, departDrop, timeUnitToWait);
        departDrop.sendKeys(Keys.RETURN);
    }

    private void selectDestination(String airportCode) {
        TestUtil.isDisplayedForElement(driver, destinationInput, timeUnitToWait);
        destinationInput.click();
        TestUtil.isDisplayedForElement(driver, destinationDrop, timeUnitToWait);
        destinationDrop.sendKeys(airportCode);
        destinationDrop.sendKeys(Keys.RETURN);
    }

    private void selectDate(String currentMonthDate){
        TestUtil.isDisplayedForElement(driver, departDateField, timeUnitToWait);
        departDateField.click();
        //String day = String.valueOf(LocalDate.now().getDayOfMonth());

        WebElement dateToSelect = driver.findElement(By.xpath("//table//td//span[text()='" + currentMonthDate + "']/preceding-sibling::input"));
        dateToSelect.click();
    }

    public void checkFlightStatus(String depCode, String destinationCode, String currentMonthDate){
        selectDepart(depCode);
        selectDestination(destinationCode);
        selectDate(currentMonthDate);
        TestUtil.isDisplayedForElement(driver, showFlightStatusButton, timeUnitToWait);
        showFlightStatusButton.click();
    }

    public String getTextOfTheSearchedFlightStatus(){
        return textOfTheStatus.getText();
    }


    public void acceptCookie(){
        TestUtil.isDisplayedForElement(driver, cookieButton, timeUnitToWait);
        cookieButton.click();
    }
}