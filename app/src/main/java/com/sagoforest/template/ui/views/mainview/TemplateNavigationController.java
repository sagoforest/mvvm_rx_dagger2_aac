package com.sagoforest.template.ui.views.mainview;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.sagoforest.common.ui.navigation.INavigationManager;
import com.sagoforest.common.ui.navigation.INavigationPage;
import com.sagoforest.common.ui.views.NavigationControllerBase;
import com.sagoforest.template.R;
import com.sagoforest.template.ui.views.newuser.NewUserFragment;
import com.sagoforest.template.ui.views.users.UsersFragment;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * The navigation controller for Precice
 * <p>
 * Created by andy on 2/20/18.
 */

public class TemplateNavigationController extends NavigationControllerBase {
    private static final String TAG = TemplateNavigationController.class.getSimpleName();
    private final FragmentManager mFragmentManager;
    private final int mContainerId;

    @Inject
    public TemplateNavigationController(@NonNull MainActivity activity,
                                        @NonNull @Named("template") INavigationManager navigationManager) {
        super(navigationManager);
        mFragmentManager = activity.getSupportFragmentManager();
        mContainerId = R.id.template_container;
        mNavigationManager.navigateToPage(getHomePage());
    }

    /**
     * Replaces the container fragment to the supplied navigation page
     *
     * @param page the page to replace the existing view.
     */
    @Override
    protected void switchPage(INavigationPage page) {
        switch (page.getPage()) {
            case TemplateNavigationPage.NEW_USER:
                replaceFragment(new NewUserFragment(), "newUserFragment");
                return;
            case TemplateNavigationPage.USERS:
                replaceFragment(new UsersFragment(), "usersFragment");
                return;
            default:
                Log.e(TAG, "Unknown navigation page");
        }
    }

    /**
     * Replace the existing fragment with the supplied fragment
     *
     * @param fragment the new fragment to show.
     * @param tag      the tag of the fragment
     */
    private void replaceFragment(Fragment fragment, String tag) {
        mFragmentManager
                .beginTransaction()
                .replace(mContainerId, fragment)
                .addToBackStack(tag)
                .commitAllowingStateLoss();
    }

    /**
     * Return the homepage for Precice
     *
     * @return the precice homepage
     */
    private INavigationPage getHomePage() {
        return new TemplateNavigationPage(TemplateNavigationPage.USERS);
    }
}