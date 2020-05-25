package com.yuphilip.controller.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.codepath.oauth.OAuthLoginActionBarActivity;
import com.yuphilip.R;
import com.yuphilip.databinding.ActivityLoginBinding;
import com.yuphilip.model.net.TwitterClient;

public class LoginActivity extends OAuthLoginActionBarActivity<TwitterClient> {

    //region Properties

    private ActivityLoginBinding binding;

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

    }

    // Inflate the menu; this adds items to the action bar if it is present.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.login, menu);
        return true;

    }

    // OAuth authenticated successfully, launch primary authenticated activity
    // i.e Display application "homepage"
    @Override
    public void onLoginSuccess() {

        Log.i("rkprkp", "Login success");
        Intent i = new Intent(this, TimelineActivity.class);
        startActivity(i);

    }

    // OAuth authentication flow failed, handle the error
    // i.e Display an error dialog or toast
    @Override
    public void onLoginFailure(Exception e) {
        e.printStackTrace();
    }

    // Click handler method for the button used to start OAuth flow
    // Uses the client to initiate OAuth authorization
    // This should be tied to a button used to login
    public void loginToRest(View view) {
        getClient().connect();
    }

}
