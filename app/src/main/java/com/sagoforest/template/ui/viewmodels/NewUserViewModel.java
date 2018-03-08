package com.sagoforest.template.ui.viewmodels;

import android.databinding.ObservableField;

import com.sagoforest.common.ui.navigation.INavigationManager;
import com.sagoforest.common.ui.viewmodels.ViewModelBase;
import com.sagoforest.template.business.interfaces.usecases.IRandomNameUseCase;
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
public class NewUserViewModel extends ViewModelBase {

    private final ObservableField<String> mFirstName = new ObservableField<>();
    private final ObservableField<String> mLastName = new ObservableField<>();

    private INavigationManager mNavigationManager;
    private IRandomNameUseCase mUseCase;
    private UserRepository mUsersRepository;

    @Inject
    public NewUserViewModel(@NonNull IRandomNameUseCase useCase,
                            @NonNull @Named("template") INavigationManager navigationManager,
                            @NonNull UserRepository usersRepository) {

        mUseCase = useCase;
        mNavigationManager = navigationManager;
        mUsersRepository = usersRepository;
    }

    public ObservableField<String> getFirstName() {
        return mFirstName;
    }

    public ObservableField<String> getLastName() {
        return mLastName;
    }

    public void addUserCommand() {
        mUsersRepository.addUser(new User(mFirstName.get(), mLastName.get()));
    }

    public void getNewNameCommand() {
        mUseCase.generateRandomName();
    }

    public void navigateToUsersCommand() {
        mNavigationManager.navigateToPage(new TemplateNavigationPage(TemplateNavigationPage.USERS));
    }
}
