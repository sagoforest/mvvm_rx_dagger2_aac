package com.sagoforest.template.ui.views.mainview;

import android.os.Bundle;

import com.sagoforest.common.ui.views.ActivityBase;
import com.sagoforest.template.R;

import javax.inject.Inject;

public class MainActivity extends ActivityBase {

    @Inject
    TemplateNavigationController navigationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLifecycle().addObserver(navigationController);
        setContentView(R.layout.activity_main);
    }


}
