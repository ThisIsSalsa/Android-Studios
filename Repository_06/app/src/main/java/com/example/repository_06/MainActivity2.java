package com.example.repository_06;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private Button readPrefsButton;
    private Button clearPrefsButton;
    private Button backButton;
    private EditText textValue;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        readPrefsButton = findViewById(R.id.readPrefsButton);
        clearPrefsButton = findViewById(R.id.clearPrefsButton); // New button
        backButton = findViewById(R.id.backButton);
        textValue = findViewById(R.id.textValue);
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        readPrefsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String savedText = sharedPreferences.getString("text", "");
                if (!savedText.isEmpty()) {
                    textValue.setText(savedText);
                } else {
                    Toast.makeText(MainActivity2.this, "Nothing found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        clearPrefsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the saved text from SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("text");
                editor.apply();
                textValue.setText(""); // Clear the text field
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
