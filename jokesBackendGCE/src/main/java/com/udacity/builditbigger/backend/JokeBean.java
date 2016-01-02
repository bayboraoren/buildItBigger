package com.udacity.builditbigger.backend;

/** The object model for the data we are sending through endpoints */
public class JokeBean {

    private String jokeData;
    private String errorMesage="NO ERROR";

    public String getJokeData() {
        return jokeData;
    }

    public String getErrorMesage() {
        return errorMesage;
    }

    public void setErrorMesage(String errorMesage) {
        this.errorMesage = errorMesage;
    }

    public void setJokeData(String jokeData) {
        this.jokeData = jokeData;
    }


}