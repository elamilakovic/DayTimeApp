package com.example.rasporedaktivnosti2;

import androidx.appcompat.app.AppCompatActivity;

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
        time = LocalTime.now();
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
}