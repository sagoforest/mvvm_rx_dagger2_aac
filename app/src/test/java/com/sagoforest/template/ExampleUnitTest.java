package com.sagoforest.template;

import org.junit.Test;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testDisposable() throws Exception {

        Disposable disposable;

        disposable = Single.just(1).subscribe(
                next -> System.out.println("Single Success"),
                error -> System.out.println("Single Error")
        );

        System.out.println("Single Disposed: " + disposable.isDisposed());

        disposable = Observable.just(1).subscribe(
                next -> System.out.println("Observable Next"),
                error -> System.out.println("Observable Error"),
                () -> System.out.println("Observable Complete")
        );

        System.out.println("Observable Disposed: " + disposable.isDisposed());


        disposable = Completable.fromAction(()->{}).subscribe(
                () -> System.out.println("Completable Success"),
                error -> System.out.println("Completable Error")
        );
        System.out.println("Completable Disposed: " + disposable.isDisposed());

    }
}