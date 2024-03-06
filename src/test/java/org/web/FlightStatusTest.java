package org.web;

import org.web.base.TestBase;
import org.web.pages.FlightStatus;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlightStatusTest extends TestBase {

    FlightStatus flightStatus;

    public FlightStatusTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        flightStatus = new FlightStatus();
        flightStatus.acceptCookie();
        percy = new Percy(driver);
    }

    @Test
    public void testLogoImageDisplayed() {
        Assert.assertTrue(flightStatus.isLogoImageDisplayed(),
                "Logo image is not displayed");
    }

    @Test
    public void testFlightStatusSectionDisplayed() {
        Assert.assertTrue(flightStatus.isFlightStatusSectionVisible(),
                "Flight Status section is not displayed");
    }

    @Test
    public void testFlightStatus() {
        flightStatus.checkFlightStatus("EDI", "BER", "18");
        String noFlightFoundMessage = "Unfortunately, we could not find any results for your search.";
        Assert.assertTrue(flightStatus.getTextOfTheSearchedFlightStatus().equalsIgnoreCase(noFlightFoundMessage),
                "Searched Flight status is available");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
