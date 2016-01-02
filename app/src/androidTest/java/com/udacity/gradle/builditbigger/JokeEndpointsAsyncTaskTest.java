package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import com.udacity.builditbigger.backend.jokeApi.model.JokeBean;

/**
 * Created by baybora on 1/2/16.
 */
public class JokeEndpointsAsyncTaskTest extends AndroidTestCase implements BaseView{

    public void testGetJokeBean(){
        JokeEndpointsAsyncTask jokeEndpointsAsyncTask = new JokeEndpointsAsyncTask(this);
    }

    @Override
    public void showJoke(JokeBean jokeBean) {

        if(jokeBean.getErrorMesage().isEmpty()){
            assertNotNull("Joke Text received...", jokeBean);
        }else{
            assertFalse("Joke Text received...", false);
        }

    }

    @Override
    public void showErrorMessage(JokeBean jokeBean) {
        fail(jokeBean.getErrorMesage());
    }
}
