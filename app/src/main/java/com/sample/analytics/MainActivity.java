package com.sample.analytics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseAnalytics.getInstance(this).setCurrentScreen(this, "메인화면", this.getClass().getSimpleName());
    }

    public void viewItemList(View view) {
        Intent intent = new Intent(this, ItemListActivity.class);
        startActivity(intent);
    }
}