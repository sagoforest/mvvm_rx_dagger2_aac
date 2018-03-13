package com.sagoforest.template.ui.viewmodels;

import android.databinding.ObservableField;

import com.sagoforest.common.ui.navigation.INavigationManager;
import com.sagoforest.common.ui.viewmodels.ViewModelBase;
import com.sagoforest.template.business.interfaces.usecases.IUsersUseCase;
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
    private IUsersUseCase mUseCase;

    @Inject
    public NewUserViewModel(@NonNull INavigationManager navigationManager,
                            @NonNull IUsersUseCase useCase) {

        mNavigationManager = navigationManager;
        mUseCase = useCase;
    }

    public ObservableField<String> getFirstName() {
        return mFirstName;
    }

    public ObservableField<String> getLastName() {
        return mLastName;
    }

    public void addUserCommand() {
        mUseCase.addNew(mFirstName.get(), mLastName.get());
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
