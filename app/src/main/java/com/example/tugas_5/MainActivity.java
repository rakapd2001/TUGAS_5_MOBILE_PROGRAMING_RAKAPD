package com.example.tugas_5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button dateButton = findViewById(R.id.btnDatePicker);
        TextView dateText = findViewById(R.id.textSelectedDate);

        dateButton.setOnClickListener(view -> {
           Calendar cal = Calendar.getInstance();
           int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (view1, year1, monthOfYear, dayOfMonth) -> dateText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1), year, month, day);
            datePickerDialog.show();
        });
        EditText phoneNumber = findViewById(R.id.etPhoneNumber);
        Button showAlert = findViewById(R.id.btnShowAlert);

        showAlert.setOnClickListener(view -> {
            String phone = phoneNumber.getText().toString();
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder.setTitle("Confirmation");
            alertBuilder.setMessage("Is this your phone number? " + phone);
            alertBuilder.setPositiveButton("Yes", (dialog, which) -> {
                Toast.makeText(MainActivity.this, "Number confirmed!", Toast.LENGTH_SHORT).show();
            });
            alertBuilder.setNegativeButton("No", (dialog, which) -> {
                Toast.makeText(MainActivity.this, "Number rejected!", Toast.LENGTH_SHORT).show();
            });
            AlertDialog dialog = alertBuilder.create();
            dialog.show();
        });
    }
}