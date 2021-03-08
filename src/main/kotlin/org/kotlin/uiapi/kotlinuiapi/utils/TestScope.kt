package org.kotlin.uiapi.kotlinuiapi.utils

import com.google.gson.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


object TestScope {
    @Volatile
    private var instance: TestScope? = null
    var response: Response? = null
    @Synchronized
    fun getInstance(apiResponse: Response?): Response? { //if you add sync in the method name it will be thread-safe
        if (response == null) {
            //lazy instantiating
            //the singleton instance is not created until the getInstance method is called for the first time.
            // This technique ensures that singleton instances are created only when needed.
            synchronized(TestScope::class.java) {
                //first instantiation is null and the object will be created once and it will not be kept as null
                // next time and the same object/value will be used in the other calls
                if (response == null) {
                    instance = TestScope
                    response = apiResponse
                    System.out.println(response?.getBody()?.asString())
                }
            }
        }
        return response
    }

    fun getNullInstance(apiResponse: Response?): Response? { //if you add sync in the method name it will be thread-safe
        instance = null
        instance = TestScope
        println("*****")
        //System.gc();
        System.out.println(response?.getBody()?.asString())
        return response
    }

    fun jsonStringParser(response: Response): String {
        val resp: String = response.getBody().asString()
        println(resp)
        val jsonPath = JsonPath(resp)
        return jsonPath.get("data[0].employee_name")
    }
}