package com.example.afinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class MainActivity extends AppCompatActivity {
    private ChipGroup   chipGroup;
    private RadioGroup  radioGroup;
    private Button      button;
    private String      food;
    private String      drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        chipGroup   =   findViewById(R.id.chip_group);
        radioGroup  =   findViewById(R.id.radioGroup);
        button      =   findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMenu();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void getMenu() {
        
        int     selectedFoodID    =   chipGroup.getCheckedChipId();
        int     selectedDrinkID   =   radioGroup.getCheckedRadioButtonId();

        Chip             selectedFood    =   findViewById(selectedFoodID);
        RadioButton      selectedDrink   =   findViewById(selectedDrinkID);

        food  = selectedFood.getText().toString();
        drink = selectedDrink.getText().toString();

        Toast.makeText(MainActivity.this, food + " " + drink , Toast.LENGTH_SHORT).show();
    }
}