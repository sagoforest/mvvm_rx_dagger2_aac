package com.sagoforest.common.ui.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

import javax.inject.Inject

import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector

/**
 * Created by andy on 2/9/18.
 */

abstract class ActivityBase : FragmentActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentDispatchingAndroidInjector
    }

}
