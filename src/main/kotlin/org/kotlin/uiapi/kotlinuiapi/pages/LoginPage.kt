package org.kotlin.uiapi.kotlinuiapi.pages

import org.kotlin.uiapi.kotlinuiapi.utils.ConfigurationReader.getProperty
import org.kotlin.uiapi.kotlinuiapi.utils.Driver
import org.openqa.selenium.support.PageFactory


class LoginPage() {

    init {
        PageFactory.initElements(Driver.getDriver(), this)
        // Driver.getDriver()?.get(getProperty("url"))
    }

    fun goToLandingPage(url: String){
        //if the url is given on the feature file directly use the below ome;
        // Driver.getDriver()?.get(url)

        // link is given on config property file
        Driver.getDriver()?.get(getProperty("url"))



    }



}