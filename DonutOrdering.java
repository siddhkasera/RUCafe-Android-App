package com.example.rucafe;

import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import java.io.Serializable;
import java.util.ArrayList;

public class DonutOrdering extends AppCompatActivity {

    /*ListView flavorsListView;
    ListView selectedFlavorListView;
    ArrayList<String> flavorsArrayList = new ArrayList<>();
    ArrayList<String> selectedFlavorsArrList = new ArrayList<>();

     */
    ArrayList<Integer> quantityList = new ArrayList<>();
    ArrayList<String> arrayListQty = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9","10"));
    TextView subtotalDonutOrder;
    int quantity;
    protected double currentTotal = 0.00;
    private final double donutPrice = 1.39;
    DecimalFormat df = new DecimalFormat("0.00"); //look at format
    Button donutAddOrderButton;
    Order order;
    TextView flavorPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut_ordering);

        String flavor = getIntent().getStringExtra("flavorname");
        flavorPrint = findViewById(R.id.flavorPrint);
        flavorPrint.setText(flavor);

        final Spinner qtySpinner = findViewById(R.id.qtySpinnerDonut);
        ArrayAdapter<String> arrayAdapterQty = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayListQty);
        arrayAdapterQty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        qtySpinner.setAdapter(arrayAdapterQty);
        qtySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + tutorialsName, Toast.LENGTH_LONG).show();
                quantity = Integer.parseInt(qtySpinner.getSelectedItem().toString());
                calculateQtyTotal();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //add to order button
        donutAddOrderButton = findViewById(R.id.donutAddOrderButton);
        donutAddOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    public void addDonutOrder(View view) {
        Donut donutOrder = new Donut(flavorPrint.getText().toString(), quantityList);
        donutOrder.itemPrice();

        ArrayList<MenuItem> donutOrdered = new ArrayList<>();
        donutOrdered.add(donutOrder);
        Order order = new Order(donutOrdered);
        CurrentOrder.addMainOrder(order);
        Intent intent = new Intent(this, CurrentOrder.class);
        startActivity(intent);

    }

    public void calculateQtyTotal(){
        subtotalDonutOrder = findViewById(R.id.subtotalDonutOrder);
        for(int i = 1; i<= arrayListQty.size(); i++){
            if(quantity == i) {
                    currentTotal = donutPrice * i;
                    subtotalDonutOrder.setText(df.format(currentTotal));
            }
        }
    }

}