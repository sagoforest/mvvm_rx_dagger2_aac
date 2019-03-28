package com.sagoforest.common.ui.views

import android.content.Context
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by andy on 2/9/18.
 */


abstract class FragmentBase : DialogFragment(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentInjector
    }
}

