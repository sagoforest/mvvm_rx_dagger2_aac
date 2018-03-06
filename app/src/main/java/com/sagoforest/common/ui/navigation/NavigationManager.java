package com.sagoforest.common.ui.navigation;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * A generic navigation manager
 * <p>
 * Created by andy on 2/21/18.
 */
public class NavigationManager implements INavigationManager {

    private BehaviorSubject<INavigationPage> mCurrentPage = BehaviorSubject.create();

    @Inject
    public NavigationManager() {
    }

    /**
     * Navigates to the supplied page
     *
     * @param page the page to navigate to
     */
    public void navigateToPage(INavigationPage page) {
        mCurrentPage.onNext(page);
    }

    /**
     * The observable for the current page.
     *
     * @return the current page stream.
     */
    public Observable<INavigationPage> getCurrentPage() {
        return mCurrentPage;
    }


}
