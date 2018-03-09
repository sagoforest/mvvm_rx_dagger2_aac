package com.sagoforest.template.ui.viewmodels;

import android.databinding.ObservableField;

import com.sagoforest.common.dataaccess.repositories.interfaces.IRepository;
import com.sagoforest.common.ui.navigation.INavigationManager;
import com.sagoforest.common.ui.viewmodels.ViewModelBase;
import com.sagoforest.template.dataaccess.entities.User;
import com.sagoforest.template.dataaccess.interfaces.repositories.IUserRepository;
import com.sagoforest.template.ui.views.mainview.TemplateNavigationPage;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.annotations.NonNull;

/**
 * A sample view model using AAC
 * <p>
 * Created by andy on 1/30/18.
 */
@Singleton
public class NewUserViewModel extends ViewModelBase {

    private final ObservableField<String> mFirstName = new ObservableField<>();
    private final ObservableField<String> mLastName = new ObservableField<>();

    private INavigationManager mNavigationManager;
    private IUserRepository mRepository;

    @Inject
    public NewUserViewModel(@NonNull INavigationManager navigationManager,
                            @NonNull IUserRepository repository) {

        mNavigationManager = navigationManager;
        mRepository = repository;
    }

    public ObservableField<String> getFirstName() {
        return mFirstName;
    }

    public ObservableField<String> getLastName() {
        return mLastName;
    }

    public void addUserCommand() {
        mRepository.add(new User(mFirstName.get(), mLastName.get()));
        navigateToUsersCommand();
        resetData();
    }

    public void navigateToUsersCommand() {
        mNavigationManager.navigateToPage(new TemplateNavigationPage(TemplateNavigationPage.USERS));
    }

    private void resetData() {
        mFirstName.set("");
        mLastName.set("");
    }
}
