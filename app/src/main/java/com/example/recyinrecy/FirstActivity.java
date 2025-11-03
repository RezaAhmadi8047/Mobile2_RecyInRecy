package com.example.recyinrecy;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class FirstActivity extends AppCompatActivity implements InterfaceNumber {

    Button btnDate, btnTime, btnShowDialog, btnSave, btnListDialog;
    TextView txtDate, txtTime;
    int year, month, day, hour, minute;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);
        btnShowDialog = findViewById(R.id.btnShowDialog);
        btnSave = findViewById(R.id.btnSave);
        btnListDialog = findViewById(R.id.btnListDialog);
        txtDate = findViewById(R.id.txtDate);
        txtTime = findViewById(R.id.txtTime);

        btnDate.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(FirstActivity.this,
                    (DatePicker view, int year1, int monthOfYear, int dayOfMonth) ->
                            txtDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1),
                    year, month, day);
            datePickerDialog.show();
        });

        btnTime.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            hour = c.get(Calendar.HOUR_OF_DAY);
            minute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(FirstActivity.this,
                    (TimePicker view, int hourOfDay, int minute1) ->
                            txtTime.setText(hourOfDay + ":" + minute1),
                    hour, minute, true);
            timePickerDialog.show();
        });

        btnShowDialog.setOnClickListener(v -> {
            new AlertDialog.Builder(FirstActivity.this)
                    .setTitle("پیغام")
                    .setMessage("آیا مطمئن هستید؟")
                    .setPositiveButton("بله", (dialog, which) -> dialog.dismiss())
                    .setNegativeButton("خیر", (dialog, which) -> dialog.dismiss())
                    .show();
        });

        btnSave.setOnClickListener(v -> {
            new AlertDialog.Builder(FirstActivity.this)
                    .setTitle("موفق!")
                    .setMessage("یادآور با موفقیت ذخیره شد.")
                    .setPositiveButton("باشه", (d, w) -> d.dismiss())
                    .show();
        });

        btnListDialog.setOnClickListener(v -> {
            ListDialog dialog = new ListDialog(this, this);
            dialog.showDialog();
        });
    }

    @Override
    public void onItemClicked(String item) {
        Toast.makeText(this, "عدد انتخاب شد: " + item, Toast.LENGTH_SHORT).show();
    }
}
