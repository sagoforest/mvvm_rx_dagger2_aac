package com.sagoforest.common.ui.navigation;

import io.reactivex.Observable;

/**
 * A contract for navigation manager.
 * <p>
 * Created by andy on 2/22/18.
 */

public interface INavigationManager {

    /**
     * Navigates to the supplied page
     *
     * @param page the page to navigate to
     */
    void navigateToPage(INavigationPage page);

    /**
     * The observable for the current page.
     *
     * @return the current page stream.
     */
    Observable<INavigationPage> getCurrentPage();
}
