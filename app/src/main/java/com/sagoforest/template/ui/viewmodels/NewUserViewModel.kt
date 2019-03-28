package com.sagoforest.template.ui.viewmodels

import android.databinding.ObservableField
import com.sagoforest.common.ui.navigation.INavigationManager
import com.sagoforest.common.ui.viewmodels.ViewModelBase
import com.sagoforest.template.business.interfaces.usecases.IUsersUseCase
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
class NewUserViewModel @Inject
constructor(private val mNavigationManager: INavigationManager,
            private val mUseCase: IUsersUseCase) : ViewModelBase() {

    val firstName = ObservableField<String>()
    val lastName = ObservableField<String>()

    fun addUserCommand() {
        mUseCase.addNew(firstName.get()!!, lastName.get()!!)
        navigateToUsersCommand()
        resetData()
    }

    fun navigateToUsersCommand() {
        mNavigationManager.navigateToPage(TemplateNavigationPage(TemplateNavigationPage.USERS))
    }

    private fun resetData() {
        firstName.set("")
        lastName.set("")
    }
}
