package org.kotlin.uiapi.kotlinuiapi.utils


import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebDriverException
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.safari.SafariDriver


object Driver {
    private var driver: WebDriver? = null
    @Synchronized
    fun getDriver(browser: String?): WebDriver? {
        // String browser ==>  it originally comes from xml file to test base class, from test base it comes here
        var browser = browser
        if (driver == null) {
            // first we check if the value from xml file is null or not
            // if the value from xml file NOT null we use
            // the value from xml file IS null, we get the browser from properties file
            browser = browser ?: ConfigurationReader.getProperty("browser")
            when (browser) {
                "chrome" -> {
                    WebDriverManager.chromedriver().setup()
                    driver = ChromeDriver()
                }
                "chromeHeadless" -> {
                    WebDriverManager.chromedriver().setup()
                    driver = ChromeDriver(ChromeOptions().setHeadless(true))
                }
                "firefox" -> {
                    WebDriverManager.firefoxdriver().setup()
                    driver = FirefoxDriver()
                }
                "firefoxHeadless" -> {
                    WebDriverManager.firefoxdriver().setup()
                    driver = FirefoxDriver(FirefoxOptions().setHeadless(true))
                }
                "ie" -> {
                    if (System.getProperty("os.name").toLowerCase()
                            .contains("mac")
                    ) throw WebDriverException("You are operating Mac OS which doesn't support Internet Explorer")
                    WebDriverManager.iedriver().setup()
                    driver = InternetExplorerDriver()
                }
                "edge" -> {
                    WebDriverManager.edgedriver().setup()
                    driver = EdgeDriver()
                }
                "safari" -> {
                    if (System.getProperty("os.name").toLowerCase()
                            .contains("windows")
                    ) throw WebDriverException("You are operating Windows OS which doesn't support Safari")
                    WebDriverManager.getInstance(SafariDriver::class.java).setup()
                    driver = SafariDriver()
                }
                else -> throw RuntimeException("Illegal browser type!")
            }
        }
        return driver
    }

    fun getDriver(): WebDriver? {
        return getDriver(null)
    }

    fun closeDriver() {
        if (driver != null) {
            driver!!.quit()
            driver = null
        }
    }
}
