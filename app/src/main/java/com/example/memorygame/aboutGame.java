package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class aboutGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_game);


    }

    public void sendToEmail(View view) {

        Intent sendemail = new Intent(Intent.ACTION_SEND);
        sendemail.setData(Uri.parse("mailto:"));
        sendemail.setType("message/rfc822");
        sendemail.putExtra(Intent.EXTRA_EMAIL, new String[]{
                "ezrachayu94@gmail.com"
        });
        sendemail.putExtra(Intent.EXTRA_SUBJECT,"my app");
        sendemail.putExtra(Intent.EXTRA_TEXT,"Thank yuo for downloading my app");
        startActivity(sendemail);

    }

    public void shareApp(View view) {

        String textShare = "The memory game";
        String link = "https://www.google.com/";

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, textShare + "\n" + link);
        startActivity(Intent.createChooser(share,"My share"));

    }
}