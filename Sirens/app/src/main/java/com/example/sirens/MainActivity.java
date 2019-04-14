package com.example.sirens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonGps = findViewById(R.id.buttonGps);
        final Button buttonGo = findViewById(R.id.buttonGo);

        final EditText editLat = findViewById(R.id.editTextLat);
        final EditText editLong = findViewById(R.id.editTextLong);

        buttonGps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                double latitude = 51.52;
                double longitude = -13.03;
                Intent intentBundle = new Intent(MainActivity.this, NetMap.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("lat", latitude);
                bundle.putDouble("long", longitude);
                intentBundle.putExtras(bundle);
                startActivity(intentBundle);
            }
        });

        buttonGo.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     // Code here executes on main thread after user presses button
                     double latitude = Double.parseDouble(editLat.getText().toString());
                     double longitude = Double.parseDouble(editLong.getText().toString());
                     Intent intentBundle = new Intent(MainActivity.this, NetMap.class);
                     Bundle bundle = new Bundle();
                     bundle.putDouble("lat", latitude);
                     bundle.putDouble("long", longitude);
                     intentBundle.putExtras(bundle);
                     startActivity(intentBundle);
                 }
             });
    }
}
