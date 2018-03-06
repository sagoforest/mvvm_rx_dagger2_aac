package com.sagoforest.template.ui.viewmodels;

import android.databinding.ObservableField;

import com.sagoforest.common.ui.navigation.INavigationManager;
import com.sagoforest.common.ui.viewmodels.ViewModelBase;
import com.sagoforest.template.ui.views.mainview.TemplateNavigationPage;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import io.reactivex.annotations.NonNull;

/**
 * A sample view model using AAC
 * <p>
 * Created by andy on 1/30/18.
 */
@Singleton
public class SecondViewModel extends ViewModelBase {

    private final ObservableField<String> mMessage = new ObservableField<>();

    private INavigationManager mNavigationManager;

    @Inject
    public SecondViewModel(@NonNull @Named("template") INavigationManager navigationManager) {

        mNavigationManager = navigationManager;

    }


    public void navigateHomeCommand() {
        mNavigationManager.navigateToPage(new TemplateNavigationPage(TemplateNavigationPage.MAIN));
    }
}
