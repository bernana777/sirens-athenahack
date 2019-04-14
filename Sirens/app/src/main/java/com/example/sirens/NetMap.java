package com.example.sirens;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.content.DialogInterface;

public class NetMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_map);

        Intent intentBundle = getIntent();
        Bundle extrasBundle = intentBundle.getExtras();
        final double boatLat = extrasBundle.getDouble("boatLat");
        final double boatLong = extrasBundle.getDouble("boatLat");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(NetMap.this, PlanYourRoute.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("boatLat", boatLat);
                bundle.putDouble("boatLong", boatLong);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });



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



    }

}
