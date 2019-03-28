package com.sagoforest.template.ui.views.mainview

import android.os.Bundle

import com.sagoforest.common.ui.views.ActivityBase
import com.sagoforest.template.R

import javax.inject.Inject

class MainActivity : ActivityBase() {

    @Inject
    lateinit var navigationController: TemplateNavigationController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(navigationController)
        setContentView(R.layout.activity_main)
    }


}
