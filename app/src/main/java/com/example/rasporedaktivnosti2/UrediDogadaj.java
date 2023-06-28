package com.example.rasporedaktivnosti2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.widget.TimePicker;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalTime;

public class UrediDogadaj extends AppCompatActivity
{
    private EditText nazivDogadajaID;
    private TextView datumDogadajaID, vrijemeDogadajaID;

    private LocalTime time;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uredi_dogadaj);
        initWidgets();
        datumDogadajaID.setText("Datum : " + KalendarUtils.formattedDate(KalendarUtils.selectedDate));
        vrijemeDogadajaID.setText("Vrijeme: " + KalendarUtils.formattedTime(time));
    }

    private void initWidgets()
    {
        nazivDogadajaID = findViewById(R.id.nazivDogadajaID);
        datumDogadajaID = findViewById(R.id.datumDogadajaID);
        vrijemeDogadajaID = findViewById(R.id.vrijemeDogadajaID);
    }

    public void spremiDogadaj(View view)
    {
        String eventName = nazivDogadajaID.getText().toString();
        Dogadaj newEvent = new Dogadaj(eventName, KalendarUtils.selectedDate, time);
        Dogadaj.eventsList.add(newEvent);
        finish();
    }

    public void selectVrijeme(View view) {
        // Create a TimePickerDialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                UrediDogadaj.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Update the time variable with the selected time
                        time = LocalTime.of(hourOfDay, minute);
                        // Update the vrijemeDogadajaID text view with the selected time
                        vrijemeDogadajaID.setText("Vrijeme: " + KalendarUtils.formattedTime(time));
                    }
                },
                time.getHour(), // Set the initial hour to the current time's hour
                time.getMinute(), // Set the initial minute to the current time's minute
                true); // Set true for

    }
}