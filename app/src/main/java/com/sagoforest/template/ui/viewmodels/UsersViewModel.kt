package com.sagoforest.template.ui.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams

import com.sagoforest.common.ui.navigation.INavigationManager
import com.sagoforest.common.ui.rx.SchedulerFacade
import com.sagoforest.common.ui.viewmodels.ViewModelBase
import com.sagoforest.template.business.interfaces.usecases.IUsersUseCase
import com.sagoforest.template.da.entities.User
import com.sagoforest.template.ui.views.mainview.TemplateNavigationPage

import javax.inject.Inject
import javax.inject.Singleton


/**
 * A sample view model using AAC
 *
 *
 * Created by andy on 1/30/18.
 */
@Singleton
class UsersViewModel
@Inject
constructor(private val mNavigationManager: INavigationManager,
            private val mUseCase: IUsersUseCase) : ViewModelBase() {

    val usersLiveData: LiveData<List<User>>


    init {

        // create the live stream from the flowable
        usersLiveData = LiveDataReactiveStreams.fromPublisher(mUseCase.users
                .subscribeOn(SchedulerFacade.io())
                .observeOn(SchedulerFacade.ui()))
    }

    fun newUserCommand() {
        mNavigationManager.navigateToPage(TemplateNavigationPage(TemplateNavigationPage.NEW_USER))
    }

    fun clearUsersCommand() {
        mUseCase.clearAll()
    }
}
