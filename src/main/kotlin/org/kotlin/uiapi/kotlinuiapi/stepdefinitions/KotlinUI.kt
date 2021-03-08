package org.kotlin.uiapi.kotlinuiapi.stepdefinitions

import cucumber.api.java8.En
import org.kotlin.uiapi.kotlinuiapi.utils.Pages

class KotlinUI: En {

    init {
        Given("User lands on the {string} page")
        { string: String? ->
            var page: Unit? = Pages().loginPage()?.goToLandingPage(string!!)
            //var page: Unit = Pages().loginPage()?.goToLandingPage(string!!) ?:
            //var page: Unit = (Pages().loginPage()?.goToLandingPage(string!!) ?: 0) as Unit

            //This can be commented out and the Login Page one can be used
            //Driver.getDriver()?.get(ConfigurationReader.getProperty(string))


        }
    }
}