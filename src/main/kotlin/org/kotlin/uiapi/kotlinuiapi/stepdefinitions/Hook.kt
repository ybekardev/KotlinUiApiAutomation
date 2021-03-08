package org.kotlin.uiapi.kotlinuiapi.stepdefinitions

import cucumber.api.Scenario
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java8.En
import org.kotlin.uiapi.kotlinuiapi.utils.BrowserUtils
import org.kotlin.uiapi.kotlinuiapi.utils.Driver
import org.openqa.selenium.OutputType

import org.openqa.selenium.TakesScreenshot


class Hook: En {
    //default HOOK runs for any scenario
    @Before
    fun setup(scenario: Scenario) {
        System.out.println(scenario.getSourceTagNames())
        System.out.println(scenario.getName())
        println("BEFORE")
        //Driver.getDriver().manage().window().maximize();
        //Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    fun teardown(scenario: Scenario) {
        if (scenario.isFailed()) {
            val takesScreenshot = Driver.getDriver() as TakesScreenshot
            val image = takesScreenshot.getScreenshotAs(OutputType.BYTES)
            //will attach screenshot into report
            scenario.embed(image, "image/png")
        }
        BrowserUtils.waitPlease(10)
        Driver.closeDriver()
        println("AFTER")
    }
}