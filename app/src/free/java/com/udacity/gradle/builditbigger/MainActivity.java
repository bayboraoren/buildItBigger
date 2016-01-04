package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by baybora on 1/2/16.
 */
public class MainActivity extends BaseActivity{

    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_ads_id));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                //close interstitial
                super.onAdClosed();
                //show joke
                executeJokeAsyncTask();
                // Request for add
                getNewInterstitial();

            }
        });

        getNewInterstitial();

    }

    private void getNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        interstitialAd.loadAd(adRequest);
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


    @Override
    public void executeJokeAsyncTask() {
        //interstitial is not loaded show interstitial else show joke
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            super.executeJokeAsyncTask();
        }
    }


}
