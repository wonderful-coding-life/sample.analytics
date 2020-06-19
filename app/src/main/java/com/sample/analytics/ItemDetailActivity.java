package com.sample.analytics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        String itemName = getIntent().getStringExtra("itemName");
        TextView itemNameView = findViewById(R.id.item_name);
        itemNameView.setText(itemName);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseAnalytics.getInstance(this).setCurrentScreen(this, "제품상세화면", this.getClass().getSimpleName());
    }
}