package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import com.udacity.builditbigger.backend.jokeApi.model.JokeBean;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by baybora on 1/2/16.
 */
public class JokeEndpointsAsyncTaskTest extends AndroidTestCase implements BaseView{

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public void testGetJokeBean(){

        executeJokeAsyncTask();

        try {

            countDownLatch.await(30, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            JokeBean jokeBean = new JokeBean();
            jokeBean.setErrorMesage(e.getMessage());
            showErrorMessage(jokeBean);
        }

    }

    @Override
    public void showJoke(JokeBean jokeBean) {
        assertNotNull("Joke Text received...", jokeBean.getJokeData());
    }

    @Override
    public void showErrorMessage(JokeBean jokeBean) {
        fail(jokeBean.getErrorMesage());
    }


    @Override
    public void executeJokeAsyncTask() {
        new JokeEndpointsAsyncTask(this).execute();
    }
}
