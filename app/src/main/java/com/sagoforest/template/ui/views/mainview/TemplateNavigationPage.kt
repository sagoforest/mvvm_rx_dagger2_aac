package com.sagoforest.template.ui.views.mainview


import android.support.annotation.IntDef

import com.sagoforest.common.ui.navigation.INavigationPage


/**
 * The annotation definition for Precice pages.
 *
 *
 * Created by andrew.hanna on 2/21/18.
 */

class TemplateNavigationPage(@PrecicePage override val page: Int) : INavigationPage {

    override fun toString(): String {
        return String.format("%s_%d", NAME, page)
    }

    // Describes when the annotation will be discarded
    @Retention(AnnotationRetention.SOURCE)
    // Enumerate valid values for this interface
    @IntDef(NEW_USER.toLong(), USERS.toLong())
    // Create an interface for validating int types
    annotation class PrecicePage

    companion object {

        private val NAME = TemplateNavigationPage::class.java.simpleName

        // Declare the constants
        const val NEW_USER = 0
        const val USERS = 1
    }
}
