package org.kotlin.uiapi.kotlinuiapi.stepdefinitions

import cucumber.api.PendingException
import cucumber.api.java8.En
import io.restassured.RestAssured
import io.restassured.config.EncoderConfig
import io.restassured.response.Response
import org.hamcrest.CoreMatchers.equalTo
import org.kotlin.uiapi.kotlinuiapi.utils.TestScope


class KotlinApi: En {

    var generateEmpJWT: String? = null
    var emplocationUrl: String? = null
    var getEmpUrlCode: String? = null
    var empAccessToken: String? = null
    var testScope: TestScope? = null
    var apiResponse: Response? = null


    init {

        When(
            "I send the get request to {string}"
        ) { string: String? ->
            println("START...")
            val encoderconfig = EncoderConfig()

            val response: Response = RestAssured
                .given()
                .log().all()
                .config(
                    RestAssured.config()
                        .encoderConfig(encoderconfig.appendDefaultContentCharsetToContentTypeIfUndefined(false))
                )
                .`when`()
                .get(string)
                .then().body("data[0].employee_name", equalTo("Tiger Nixon"))
                .statusCode(200)
                .extract()
                .response()

            println(response.getBody().asString())
            //testScope.response = response;
            //testScope.getInstance(response);
            //testScope.response = response;
            //testScope.getInstance(response);
            apiResponse = testScope?.getInstance(response)
            //System.out.println(apiResponse.getBody().asString());

            //String s = generateEmpJWT = response.body().prettyPrint();
            //System.out.println(s);



        }
    }
}