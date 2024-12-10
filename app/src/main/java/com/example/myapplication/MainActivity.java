package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private float currentFontSize = 18f; // Initial font size
    private int colorIndex = 0; // Index to track the current color

    // Array of colors to cycle through
    private int[] colors = {Color.MAGENTA, Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.YELLOW};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextName = findViewById(R.id.editTextName);
        TextView textViewGreeting = findViewById(R.id.textViewGreeting);
        Button buttonIncreaseSize = findViewById(R.id.buttonIncreaseSize);
        Button buttonChangeColor = findViewById(R.id.buttonChangeColor);

        // Set OnClickListener for the Increase Size button
        buttonIncreaseSize.setOnClickListener(v -> {
            // Increase font size
            currentFontSize += 2f;
            textViewGreeting.setTextSize(currentFontSize);
            textViewGreeting.setVisibility(View.VISIBLE);
        });

        // Set OnClickListener for the Change Color button
        buttonChangeColor.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            textViewGreeting.setText(name);
            textViewGreeting.setVisibility(View.VISIBLE);

            // Change text color by cycling through the array
            textViewGreeting.setTextColor(colors[colorIndex]);

            // Update the color index to cycle through colors
            colorIndex = (colorIndex + 1) % colors.length; // Reset when it reaches the end of the array
        });
    }
}
