package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.view.MenuItem;

import com.udacity.gradle.builditbigger.BaseActivity;
import com.udacity.gradle.builditbigger.R;

/**
 * Created by baybora on 1/2/16.
 */
public class MainActivity extends BaseActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void executeJokeAsyncTask() {
        super.executeJokeAsyncTask();
    }


}
