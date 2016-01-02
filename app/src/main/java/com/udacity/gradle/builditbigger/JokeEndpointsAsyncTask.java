package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.builditbigger.backend.jokeApi.JokeApi;
import com.udacity.builditbigger.backend.jokeApi.model.JokeBean;

import java.io.IOException;

/**
 * Created by baybora on 12/30/15.
 */
class JokeEndpointsAsyncTask extends AsyncTask<Void, Void, JokeBean> {
    private static JokeApi jokeApiService = null;
    private BaseView baseView;

    //set context to show message from andoid library jokes via gce
    public JokeEndpointsAsyncTask(BaseView baseView){
        this.baseView = baseView;
    }

    @Override
    protected JokeBean doInBackground(Void...params) {

        JokeBean jokeBean  = new JokeBean();

        if(jokeApiService == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - 10.0.3.2 is localhost's IP address in Genymotion
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            jokeApiService = builder.build();
        }

        try {

            jokeBean = jokeApiService.getJoke().execute();
            return jokeBean;

        } catch (IOException e) {
            jokeBean.setErrorMesage(e.getMessage());
            return jokeBean;
        }
    }

    @Override
    protected void onPostExecute(JokeBean jokeBean) {

        if(null==jokeBean.getJokeData()) {
            baseView.showErrorMessage(jokeBean);
        } else {
            baseView.showJoke(jokeBean);
        }

    }
}