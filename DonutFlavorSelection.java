package com.example.rucafe;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DonutFlavorSelection extends AppCompatActivity {

    Button chocButton;
    Button vanillaButton;
    Button strawButton;
    Button glazedButton;
    Button blueButton;

    String chocolate = "Chocolate";
    String vanilla = "Vanilla";
    String strawberry = "Strawberry";
    String glazed = "Glazed";
    String blueberry = "Blueberry";

    String flavor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut_flavor_selection);

        chocButton = (Button) findViewById(R.id.chocolateButton);
        chocButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flavor = chocolate;
                openNewActivity();
            }
        });

        vanillaButton = (Button) findViewById(R.id.vanillaButton);
        vanillaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flavor = vanilla;
                openNewActivity();

            }
        });

        strawButton = (Button) findViewById(R.id.strawberryButton);
        strawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flavor = strawberry;
                openNewActivity();

            }
        });

        glazedButton = (Button) findViewById(R.id.glazedButton);
        glazedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flavor = glazed;
                openNewActivity();

            }
        });

        blueButton = (Button) findViewById(R.id.blueberryButton);
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flavor = blueberry;
                openNewActivity();

            }
        });

    }

    public void openNewActivity(){
        Intent intent = new Intent(this, DonutOrdering.class);

        intent.putExtra("flavorname", flavor);
        startActivity(intent);



    }



}