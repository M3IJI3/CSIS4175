package com.example.classwork_3_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.classwork_3_2.databinding.ActivityMainBinding;
import com.example.classwork_3_2.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        EdgeToEdge.enable(this);
        setContentView(view);

        Bundle extra = getIntent().getExtras();
        if(extra == null)
        {
            return;
        }

        String qString = extra.getString("qString");
        binding.textView2.setText(qString);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void returnText(View view) {
        finish();
    }

    @Override
    public void finish()
    {
        Intent data = new Intent();
        String returnString = binding.editText2.getText().toString();
        data.putExtra("returnData", returnString);
        setResult(RESULT_OK,data);
        super.finish();
    }
}