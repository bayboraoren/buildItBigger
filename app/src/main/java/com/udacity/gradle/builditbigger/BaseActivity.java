package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.udacity.builditbigger.backend.jokeApi.model.JokeBean;
import com.udacity.gradle.builditbigger.android.library.JokeViewActivity;

/**
 * Created by baybora on 1/2/16.
 */
public class BaseActivity extends ActionBarActivity implements BaseView {

    @Override
    public void showJoke(JokeBean jokeBean) {
        Intent i = new Intent(this, JokeViewActivity.class);
        i.putExtra(JokeViewActivity.INTENT_EXTRA_PARAM_FOR_JOKE, jokeBean.getJokeData());
        this.startActivity(i);
    }

    @Override
    public void showErrorMessage(JokeBean jokeBean) {
        Toast.makeText(this, jokeBean.getErrorMesage(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void executeJokeAsyncTask() {
        new JokeEndpointsAsyncTask(this).execute();
    }
}
