package com.example.manav.tindermaths;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.manav.tindermaths.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class FacebookLogin extends Activity {

    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private String UserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_facebook_login);
        loginButton = (LoginButton)findViewById(R.id.login_button);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>(){
            @Override
            public void onSuccess(LoginResult loginResult) {
               UserId = loginResult.getAccessToken().getUserId();
                           GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {

                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                Log.v("Main", response.toString());
                                profilePic(object);

                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();
            }


            public void profilePic(JSONObject jsonObject)
            {
                try {
                    String fbName = jsonObject.getString("name");
                    Intent i = new Intent(FacebookLogin.this, MainActivity.class);
                    i.putExtra("userID", UserId);
                    i.putExtra("userName", fbName);
                    startActivity(i);


                }
                catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException e) {
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void guestLogin(View view){
        Intent i = new Intent(FacebookLogin.this, MainActivity.class);
        i.putExtra("userID", "GUEST");
        i.putExtra("userName", "Guest");
        startActivity(i);

    }
}