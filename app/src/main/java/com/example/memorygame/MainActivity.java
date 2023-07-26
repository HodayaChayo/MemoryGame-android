package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void outGame(View view) {
        finish();
    }

    public void startGame(View view) {
        Intent intent = new Intent(MainActivity.this, newGame.class);
        startActivity(intent);
    }

    public void aboutThisGame(View view) {
        Intent intent = new Intent(MainActivity.this, aboutGame.class);
        startActivity(intent);
    }
}