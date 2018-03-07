package com.sagoforest.template.ui.viewmodels;

import android.databinding.ObservableField;

import com.sagoforest.common.ui.navigation.INavigationManager;
import com.sagoforest.common.ui.viewmodels.ViewModelBase;
import com.sagoforest.template.dataaccess.UsersDatabase;
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
public class UsersViewModel extends ViewModelBase {

    private INavigationManager mNavigationManager;
    private UsersDatabase mUsersDatabase;

    @Inject
    public UsersViewModel(@NonNull @Named("template") INavigationManager navigationManager,
                          @NonNull UsersDatabase usersDatabase) {

        mNavigationManager = navigationManager;
        mUsersDatabase = usersDatabase;
    }


    public void newUserCommand() {
        mNavigationManager.navigateToPage(new TemplateNavigationPage(TemplateNavigationPage.NEW_USER));
    }
}
