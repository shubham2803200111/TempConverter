package com.example.temprecon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText editTextCelsius;
    private Button buttonConvert;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCelsius = findViewById(R.id.editTextCelsius);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        try {
            String celsiusString = editTextCelsius.getText().toString();
            double celsius = Double.parseDouble(celsiusString);
            double fahrenheit = (celsius * 9/5) + 32;
            String result = celsius + "°C is equal to " + fahrenheit + "°F";
            textViewResult.setText(result);
        } catch (NumberFormatException e) {
            textViewResult.setText("Invalid input. Please enter a valid number.");
        }
    }
}