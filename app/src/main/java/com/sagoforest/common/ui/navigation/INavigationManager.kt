package com.sagoforest.common.ui.navigation

import io.reactivex.Observable

/**
 * A contract for navigation manager.
 *
 *
 * Created by andy on 2/22/18.
 */

interface INavigationManager {

    /**
     * The observable for the current page.
     *
     * @return the current page stream.
     */
    val currentPage: Observable<INavigationPage>

    /**
     * Navigates to the supplied page
     *
     * @param page the page to navigate to
     */
    fun navigateToPage(page: INavigationPage)
}
