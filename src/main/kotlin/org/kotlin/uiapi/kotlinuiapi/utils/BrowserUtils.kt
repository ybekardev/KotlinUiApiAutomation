package org.kotlin.uiapi.kotlinuiapi.utils

object BrowserUtils {

    fun waitPlease(seconds: Int) {
        try {
            Thread.sleep((seconds * 1000).toLong())
        } catch (e: Exception) {
            println(e.message)
        }
    }
}