package com.sagoforest.template.ui.viewmodels;

import android.databinding.ObservableField;

import com.sagoforest.common.ui.viewmodels.ViewModelBase;
import com.sagoforest.template.business.interfaces.usecases.IRandomNameUseCase;

import javax.inject.Inject;
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
public class MainViewModel extends ViewModelBase {

    private final ObservableField<String> mMessage = new ObservableField<>();

    private IRandomNameUseCase mUseCase;

    @Inject
    public MainViewModel(@NonNull IRandomNameUseCase useCase) {

        mUseCase = useCase;

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


    public void getNewNameCommand() {
        mUseCase.generateRandomName();
    }

}
