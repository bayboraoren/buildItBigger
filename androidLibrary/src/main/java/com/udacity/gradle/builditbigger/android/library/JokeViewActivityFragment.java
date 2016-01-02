package com.udacity.gradle.builditbigger.android.library;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidlibrary.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class JokeViewActivityFragment extends Fragment {

    public JokeViewActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.joke_view_fragment_main, container, false);

        Intent i = getActivity().getIntent();
        //for joke text
        if (i != null && i.hasExtra(JokeViewActivity.INTENT_EXTRA_PARAM_FOR_JOKE)) {
            TextView jokeTextView = (TextView) rootView.findViewById(R.id.jokeText);
            jokeTextView.setText(i.getStringExtra(JokeViewActivity.INTENT_EXTRA_PARAM_FOR_JOKE));
        }

        //for joke error message
        if (i != null && i.hasExtra(JokeViewActivity.INTENT_EXTRA_PARAM_FOR_JOKE_ERROR_MESSAGE)) {
            TextView jokeErrorMessageTextView = (TextView) rootView.findViewById(R.id.joke_error_message_text);
            jokeErrorMessageTextView.setText(i.getStringExtra(JokeViewActivity.INTENT_EXTRA_PARAM_FOR_JOKE_ERROR_MESSAGE));
        }


        return rootView;
    }
}
