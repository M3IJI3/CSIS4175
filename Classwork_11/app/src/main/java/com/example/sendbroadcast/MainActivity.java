package com.example.sendbroadcast;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        configureReceiver();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void configureReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.sendbroadcast");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        receiver = new MyReceiver();
        registerReceiver(receiver, intentFilter);

    }

    public void broadcastIntent(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.sendbroadcast");

        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }

    protected void OnDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}