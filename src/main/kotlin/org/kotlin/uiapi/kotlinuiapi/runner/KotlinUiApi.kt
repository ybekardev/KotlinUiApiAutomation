package org.kotlin.uiapi.kotlinuiapi.runner

import org.springframework.boot.autoconfigure.SpringBootApplication
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber::class)
    @CucumberOptions(
        features = ["src/main/resources/features"],
        glue = ["org/kotlin/uiapi/kotlinuiapi/stepdefinitions"],
        tags = ["@api"],
        dryRun = false,
        plugin = [
            "pretty",
            "html:target/cucumber-report",
            "json:target/cucumber-report/cucumber.json",
            "junit:target/cucumber-report/cucumber-results.xml",
        ])


@SpringBootApplication
class KotlinUiApi


