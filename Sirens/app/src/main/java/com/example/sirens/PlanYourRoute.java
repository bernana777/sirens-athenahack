package com.example.sirens;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PlanYourRoute extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_your_route);

        Intent intentBundle = getIntent();
        Bundle extrasBundle = intentBundle.getExtras();
        final double boatLat = extrasBundle.getDouble("boatLat");
        final double boatLong = extrasBundle.getDouble("boatLat");

        /*
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(NetMa.this, PlanYourRoute.class);
                startActivity(intent);
            }
        });
        */

        //for each?
        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setX(60);
        imageButton.setY(22);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                {
                    final AlertDialog.Builder NetInfo = new AlertDialog.Builder(getApplicationContext());
                    NetInfo.create();
                    NetInfo.setMessage("Net ID: "+"\nLongtitude: "+"\nLatitude: ")
                            .setTitle("Net Information")
                            .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });
                }
            }
        });

        ImageButton boatButton = findViewById(R.id.boatButton);
        imageButton.setX(60);
        imageButton.setY(22);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                {
                    final AlertDialog.Builder NetInfo = new AlertDialog.Builder(getApplicationContext());
                    NetInfo.create();
                    NetInfo.setMessage("Latitude: "+boatLat+"\nLongitude: "+boatLong)
                            .setTitle("Boat Location")
                            .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });
                }
            }
        });
    }
}
