package com.sagoforest.template.ui.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;

import com.sagoforest.common.ui.navigation.INavigationManager;
import com.sagoforest.common.ui.rx.SchedulerFacade;
import com.sagoforest.common.ui.viewmodels.ViewModelBase;
import com.sagoforest.template.business.interfaces.usecases.IUsersUseCase;
import com.sagoforest.template.da.entities.User;
import com.sagoforest.template.ui.views.mainview.TemplateNavigationPage;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.annotations.NonNull;
import lombok.Getter;

/**
 * A sample view model using AAC
 * <p>
 * Created by andy on 1/30/18.
 */
@Singleton
public class UsersViewModel extends ViewModelBase {

    private INavigationManager mNavigationManager;
    private IUsersUseCase mUseCase;

    @Getter
    private LiveData<List<User>> mUsersLiveData;

    @Inject
    public UsersViewModel(@NonNull INavigationManager navigationManager,
                          @NonNull IUsersUseCase useCase) {

        mNavigationManager = navigationManager;
        mUseCase = useCase;

        // create the live stream from the flowable
        mUsersLiveData = LiveDataReactiveStreams.fromPublisher(mUseCase.getUsers()
                .subscribeOn(SchedulerFacade.io())
                .observeOn(SchedulerFacade.ui()));
    }

    public void newUserCommand() {
        mNavigationManager.navigateToPage(new TemplateNavigationPage(TemplateNavigationPage.NEW_USER));
    }

    public void clearUsersCommand() {
        mUseCase.clearAll();
    }
}
