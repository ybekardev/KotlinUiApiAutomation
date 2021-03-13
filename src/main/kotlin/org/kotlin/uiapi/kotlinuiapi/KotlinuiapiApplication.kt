package org.kotlin.uiapi.kotlinuiapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber::class)
    @CucumberOptions(
        features = ["src/main/resources/features"],
        glue = ["org/kotlin/uiapi/kotlinuiapi/stepdefinitions"],
        tags = ["@ui"],
        dryRun = false,
        plugin = [
            "pretty",
            "html:target/cucumber-report",
            "json:target/cucumber-report/cucumber.json",
            "junit:target/cucumber-report/cucumber-results.xml",
        ]


        /*
         features = ["src/main/resources/features"],
         glue = ["kotlinuiapi.stepdefinitions"],
            tags = ["@ui"],
            dryRun = false,
            plugin = [
                    "pretty",
                    "html:target/cucumber-report",
                    "json:target/cucumber-report/cucumber.json",
                    "junit:target/cucumber-report/cucumber-results.xml",
            ]
         */

       )


@SpringBootApplication
class KotlinuiapiApplication


