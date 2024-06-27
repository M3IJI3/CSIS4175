package com.example.mywebview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mywebview.databinding.ActivityMainBinding;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        EdgeToEdge.enable(this);
        setContentView(view);

        handleIntent();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void handleIntent() {
        Intent intent = getIntent();
        Uri data = intent.getData();

        URL url = null;

        try {
            url = new URL(data.getScheme(), data.getHost(), data.getPath());
            Log.d("test", "handleIntent: " + url);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        assert url != null;
        binding.webView1.loadUrl(url.toString());
    }
}