package com.gsix.covid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActividadInfoCovid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datoscovid);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }//todo poner aqui las vistas que se correspondan
    public void GoToTest(View v) {
        startActivity(new Intent(this, ActividadTest.class));
    }
    public void GoToMain(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }
}