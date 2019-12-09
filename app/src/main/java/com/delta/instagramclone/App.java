package com.delta.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("dg57LmT8A9Gly6TXarBEtjut70y77y31Jj6TNTWZ")
                // if defined
                .clientKey("whYLeewFD7iirs0PisrB73lPKIhpmm2TZu0dMKKa")
                .server("https://parseapi.back4app.com/")
                .build()
        );


    }
}
