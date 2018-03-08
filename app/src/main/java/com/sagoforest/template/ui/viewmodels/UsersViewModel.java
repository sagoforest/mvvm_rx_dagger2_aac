package com.sagoforest.template.ui.viewmodels;

import android.util.Log;

import com.sagoforest.common.ui.navigation.INavigationManager;
import com.sagoforest.common.ui.rx.SchedulerFacade;
import com.sagoforest.common.ui.viewmodels.ViewModelBase;
import com.sagoforest.template.dataaccess.User;
import com.sagoforest.template.dataaccess.repository.UserRepository;
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
    private UserRepository mRepository;

    @Inject
    public UsersViewModel(@NonNull @Named("template") INavigationManager navigationManager,
                          @NonNull UserRepository repository) {

        mNavigationManager = navigationManager;
        mRepository = repository;

        addSubscription(mRepository.getUsers()
                .subscribeOn(SchedulerFacade.io())
                .observeOn(SchedulerFacade.ui())
                .subscribe(users -> {
                    for (User user : users) {
                        Log.d("hi", user.firstName + ' ' + user.lastName);
                    }
                }));

    }

    public void newUserCommand() {
        mNavigationManager.navigateToPage(new TemplateNavigationPage(TemplateNavigationPage.NEW_USER));
    }
}
