package com.sagoforest.template.ui.views.mainview;


import android.support.annotation.IntDef;

import com.sagoforest.common.ui.navigation.INavigationPage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The annotation definition for Precice pages.
 * <p>
 * Created by andrew.hanna on 2/21/18.
 */

public class TemplateNavigationPage implements INavigationPage {

    private static final String NAME = TemplateNavigationPage.class.getSimpleName();

    // Declare the constants
    public static final int MAIN = 0;
    public static final int SECOND = 1;
    private final int mPage;

    // Mark the argument as restricted to these enumerated types
    public TemplateNavigationPage(@PrecicePage int page) {
        mPage = page;
    }

    @Override
    public int getPage() {
        return mPage;
    }

    @Override
    public String toString() {
        return String.format("%s_%d", NAME, getPage());
    }

    // Describes when the annotation will be discarded
    @Retention(RetentionPolicy.SOURCE)
    // Enumerate valid values for this interface
    @IntDef({MAIN, SECOND})
    // Create an interface for validating int types
    public @interface PrecicePage {
    }
}
