package com.sagoforest.template.business.interfaces.usecases;

import io.reactivex.Observable;

/**
 * Contract for the random name use case.
 *
 * Created by andy on 1/30/18.
 */

public interface IRandomNameUseCase {

    void generateRandomName();

    Observable<String> getName();
}
