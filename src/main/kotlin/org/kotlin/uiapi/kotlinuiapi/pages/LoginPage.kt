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
        Driver.getDriver()?.get(url)


    }



}