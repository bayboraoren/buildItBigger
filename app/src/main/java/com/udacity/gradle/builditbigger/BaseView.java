package com.udacity.gradle.builditbigger;

import com.udacity.builditbigger.backend.jokeApi.model.JokeBean;

/**
 * Created by baybora on 1/2/16.
 */
public interface BaseView {

    void executeJokeAsyncTask();
    void showJoke(JokeBean jokeBean);
    void showErrorMessage(JokeBean jokeBean);
    void showProgressBar();
    void hideProgressBar();

}
