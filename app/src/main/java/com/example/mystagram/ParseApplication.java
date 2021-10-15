package com.example.mystagram;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseObject;


public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("lPWfCPeUV46qzCmRSSAIxDKgsmBAXkxQIzgStlIg")
                .clientKey("1aVvbHlLxoOQBOc1hfb7MNe1DpDU1YMUXrWK0cyy")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
