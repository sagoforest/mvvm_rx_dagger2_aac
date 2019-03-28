package com.sagoforest.template.ui.views.mainview


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.util.Log

import com.sagoforest.common.ui.navigation.INavigationManager
import com.sagoforest.common.ui.navigation.INavigationPage
import com.sagoforest.common.ui.views.NavigationControllerBase
import com.sagoforest.template.R
import com.sagoforest.template.ui.views.newuser.NewUserFragment
import com.sagoforest.template.ui.views.users.UsersFragment

import javax.inject.Inject

/**
 * The navigation controller for Precice
 *
 *
 * Created by andy on 2/20/18.
 */

class TemplateNavigationController @Inject
constructor(activity: MainActivity,
            navigationManager: INavigationManager) : NavigationControllerBase(navigationManager) {
    private val mFragmentManager: FragmentManager = activity.supportFragmentManager
    private val mContainerId: Int = R.id.template_container

    /**
     * Return the homepage for Precice
     *
     * @return the precice homepage
     */
    private val homePage: INavigationPage
        get() = TemplateNavigationPage(TemplateNavigationPage.USERS)

    init {
        mNavigationManager.navigateToPage(homePage)
    }

    /**
     * Replaces the container fragment to the supplied navigation page
     *
     * @param page the page to replace the existing view.
     */
    override fun switchPage(page: INavigationPage) {
        when (page.page) {
            TemplateNavigationPage.NEW_USER -> {
                replaceFragment(NewUserFragment(), "newUserFragment")
                return
            }
            TemplateNavigationPage.USERS -> {
                replaceFragment(UsersFragment(), "usersFragment")
                return
            }
            else -> Log.e(TAG, "Unknown navigation page")
        }
    }

    /**
     * Replace the existing fragment with the supplied fragment
     *
     * @param fragment the new fragment to show.
     * @param tag      the tag of the fragment
     */
    private fun replaceFragment(fragment: Fragment, tag: String) {
        mFragmentManager
                .beginTransaction()
                .replace(mContainerId, fragment)
                .addToBackStack(tag)
                .commitAllowingStateLoss()
    }

    companion object {
        private val TAG = TemplateNavigationController::class.java.simpleName
    }
}