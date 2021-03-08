package org.kotlin.uiapi.kotlinuiapi.utils

import java.io.FileInputStream
import java.util.*


object ConfigurationReader {
    private var configFile: Properties? = null
    fun getProperty(key: String?): String {
        return configFile!!.getProperty(key)
    }

    init {
        try {
            //path to our .properties file
            //MIGHT BE WRONG PATH HERE, PAY ATTENTION
            val path = "src/main/resources/application.properties"
            //we create object of input stream to access file
            println(path)
            //provides access to file
            val input = FileInputStream(path)
            //initialize configFile
            configFile = Properties()
            //load properties file
            configFile!!.load(input)
            //close input stream
            input.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}