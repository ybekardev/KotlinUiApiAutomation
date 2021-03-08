package org.kotlin.uiapi.kotlinuiapi.utils

import org.kotlin.uiapi.kotlinuiapi.pages.LoginPage

class Pages {
    private var loginPage: LoginPage? = null

    fun loginPage(): LoginPage? {
        if (loginPage == null) {
            loginPage = LoginPage()
        }
        return loginPage
    }

}