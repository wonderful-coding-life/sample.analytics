package com.sample.analytics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;

public class ItemListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // logging screen_view event
        FirebaseAnalytics.getInstance(this).setCurrentScreen(this, "제품목록화면", this.getClass().getSimpleName());
    }

    public void viewItemDetail(View view) {
        Intent intent = new Intent(this, ItemDetailActivity.class);
        switch (view.getId()) {
            case R.id.view_coke:
                logEventWithProductName("코카콜라");
                intent.putExtra("itemName", "코카콜라");
                break;
            case R.id.view_pepsi:
                logEventWithProductName("팹시콜라");
                intent.putExtra("itemName", "팹시콜라");
                break;
        }
        startActivity(intent);
    }

    // logging custom event
    // to enable debug mode: ./adb -s emulator-5554 shell setprop debug.firebase.analytics.app com.sample.analytics
    // to disable debug mode: ./adb -s emulator-5554 shell setprop debug.firebase.analytics.app .none.
    private void logEventWithProductName(String productName) {
        Bundle bundle = new Bundle();
        bundle.putString("product_name", productName);
        FirebaseAnalytics.getInstance(this).logEvent("custom_event", bundle);
    }
}