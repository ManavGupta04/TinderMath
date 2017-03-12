package com.example.manav.tindermaths;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.DeviceShareDialog;
import com.facebook.share.ShareApi;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.LikeView;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

public class EndGame extends AppCompatActivity {

    //global varibles for fb
    // share button
    private ShareButton shareButton;
    //image
    private Bitmap image;
    //counter
    private int counter = 0;
    String userID, userName;
    private CallbackManager callbackManager;
    private LoginManager loginManager;

    Bitmap mbitmap;
    Button captureScreenShot;

    private int usrTime;
    private android.os.Environment Environment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        Bundle b = getIntent().getExtras();
        String score = b.getString("score");
        String time = b.getString("time");

        userID = b.getString("userID");
        userName = b.getString("userName");
        TextView TVtime = (TextView) findViewById(R.id.EndTime);
        TVtime.setText(time);
        TextView TVscore = (TextView) findViewById(R.id.EndScore);
        TVscore.setText(score);
        Button button = (Button) findViewById(R.id.share_btn);
        final ShareDialog shareDialog = new ShareDialog(this);  // intialize facebook shareDialog.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //screenShot(v);
                SharePhoto photo = new SharePhoto.Builder()
                        .setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.logosmall))
                        .build();
                SharePhotoContent content = new SharePhotoContent.Builder()
                        .addPhoto(photo)
                        .build();
                System.out.println("qwertyui");
                shareDialog.show(content);

            }
        });

    }

    //checkIfPersonalBest();


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) > 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("userID", userID);
        i.putExtra("userName", userName);
        startActivity(i);
    }


}