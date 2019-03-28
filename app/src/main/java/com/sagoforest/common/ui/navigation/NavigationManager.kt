package com.sagoforest.common.ui.navigation

import javax.inject.Inject

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

/**
 * A generic navigation manager
 *
 *
 * Created by andy on 2/21/18.
 */
class NavigationManager
@Inject constructor() : INavigationManager {

    private val mCurrentPage = BehaviorSubject.create<INavigationPage>()

    /**
     * The observable for the current page.
     *
     * @return the current page stream.
     */
    override val currentPage: Observable<INavigationPage>
        get() = mCurrentPage

    /**
     * Navigates to the supplied page
     *
     * @param page the page to navigate to
     */
    override fun navigateToPage(page: INavigationPage) {
        mCurrentPage.onNext(page)
    }


}
