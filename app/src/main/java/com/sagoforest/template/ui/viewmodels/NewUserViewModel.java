package com.sagoforest.template.ui.viewmodels;

import android.databinding.ObservableField;

import com.sagoforest.common.ui.navigation.INavigationManager;
import com.sagoforest.common.ui.viewmodels.ViewModelBase;
import com.sagoforest.template.business.interfaces.usecases.IRandomNameUseCase;
import com.sagoforest.template.ui.views.mainview.TemplateNavigationPage;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * A sample view model using AAC
 * <p>
 * Created by andy on 1/30/18.
 */
@Singleton
public class NewUserViewModel extends ViewModelBase {

    private final ObservableField<String> mMessage = new ObservableField<>();

    private INavigationManager mNavigationManager;
    private IRandomNameUseCase mUseCase;

    @Inject
    public NewUserViewModel(@NonNull IRandomNameUseCase useCase,
                            @NonNull @Named("template") INavigationManager navigationManager) {

        mUseCase = useCase;
        mNavigationManager = navigationManager;
        // this takes care of cleaning it up
        addSubscription(mUseCase.getName()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    mMessage.set(s);
                }));
    }

    public ObservableField<String> getMessage() {
        return mMessage;
    }

    public void addUserCommand() {
        return;
    }

    public void getNewNameCommand() {
        mUseCase.generateRandomName();
    }

    public void navigateToUsersCommand() {
        mNavigationManager.navigateToPage(new TemplateNavigationPage(TemplateNavigationPage.USERS));
    }
}