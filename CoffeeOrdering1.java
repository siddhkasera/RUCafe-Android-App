package com.example.rucafe;

import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import android.widget.CheckBox;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

public class CoffeeOrdering1 extends AppCompatActivity {
    String selectedFromList;
    int quantity;
    int numAddOns;

    protected double currentTotal = 0.00;
    private final double shortPrice = 1.99;
    private final double tallPrice = 2.49;
    private final double grandePrice = 2.99;
    private final double ventiPrice = 3.49;
    private final double addInCost = 0.20;

    DecimalFormat df = new DecimalFormat("0.00"); //look at format
    ArrayList<String> arrayListQty = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
    ArrayList<String> addInsList = new ArrayList<String>();
    protected Coffee coffeeOrder;
   // Coffee coffeeOrder = new Coffee(selectedFromList, quantity,addInsList ,numAddOns);
    // protected ArrayList<String> addIns = new ArrayList<String>();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_ordering);

        //size Spinner
        Spinner spinner = findViewById(R.id.sizeSpinner);
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("Short", "Tall", "Grande", "Venti"));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + tutorialsName, Toast.LENGTH_LONG).show();
                selectedFromList = spinner.getSelectedItem().toString();
                TextView textView = (TextView) findViewById(R.id.textView);
                calculateSizeSubTotal();
                //textView.setText(df.format(currentTotal));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //qty Spinner

        Spinner qtySpinner = findViewById(R.id.qtySpinnerDonut);
       // ArrayList<String> arrayListQty = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
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
    }

    public void calculateSizeSubTotal() {
        TextView textView = (TextView) findViewById(R.id.textView);

        if (selectedFromList.equals("Short")) {
            currentTotal = quantity * shortPrice;
            textView.setText(df.format(currentTotal));
        }
        if (selectedFromList.equals("Tall")) {
            currentTotal =  quantity * tallPrice;
            textView.setText(df.format(currentTotal));
        }
        if (selectedFromList.equals("Venti")) {
            currentTotal = quantity * ventiPrice;
            textView.setText(df.format(currentTotal));
        }
        if (selectedFromList.equals("Grande")) {
            currentTotal = quantity *  grandePrice;
            textView.setText(df.format(currentTotal));
        }
    }

    public void calculateQtyTotal(){
        TextView textView = (TextView) findViewById(R.id.textView);

        for(int i =1; i< arrayListQty.size()-1; i++){
            if(quantity == i) {
                if (selectedFromList.equals("Short")) {
                    currentTotal = shortPrice * i;
                    textView.setText(df.format(currentTotal));
                }
                if (selectedFromList.equals("Tall")) {
                    currentTotal = tallPrice * i;
                    textView.setText(df.format(currentTotal));
                }
                if (selectedFromList.equals("Grande")) {
                    currentTotal = grandePrice * i;
                    textView.setText(df.format(currentTotal));
                }
                if (selectedFromList.equals("Venti")) {
                    currentTotal = ventiPrice * i;
                    textView.setText(df.format(currentTotal));
                }
                textView.setText(df.format(currentTotal));
            }
        }
    }
    public void onCheckboxClicked(View view){
        TextView textView = (TextView) findViewById(R.id.textView);
        CheckBox cream = (CheckBox)findViewById(R.id.cream);
        CheckBox caramel = (CheckBox)findViewById(R.id.caramel);
        CheckBox milk = (CheckBox)findViewById(R.id.milk);
        CheckBox syrup = (CheckBox)findViewById(R.id.syrup);
        CheckBox whippedCream = (CheckBox)findViewById(R.id.whippedCream);

        if(caramel.isChecked()){
            currentTotal = currentTotal + addInCost;
            textView.setText(df.format(currentTotal));
        }else{
            currentTotal = currentTotal + addInCost;
            textView.setText(df.format(currentTotal));
        }
        if(milk.isChecked()){
            currentTotal = currentTotal + addInCost;
            textView.setText(df.format(currentTotal));
        }if(cream.isChecked()){
            currentTotal = currentTotal + addInCost;
            textView.setText(df.format(currentTotal));
        }if(whippedCream.isChecked()){
            currentTotal = currentTotal + addInCost;
            textView.setText(df.format(currentTotal));
        }if(syrup.isChecked()){
            currentTotal = currentTotal + addInCost;
            textView.setText(df.format(currentTotal));
        }
    }

    /*public void onCheckboxClicked(View view) {
        TextView textView = (TextView) findViewById(R.id.textView);
        //Context context = getApplicationContext();
        //int duration = Toast.LENGTH_SHORT;

        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.cream:
                if (checked){
                    currentTotal = currentTotal + addInCost;
                    textView.setText(df.format(currentTotal));
                }//else{
                   // currentTotal = currentTotal - addInCost;
                   // textView.setText(df.format(currentTotal));
                //}
            case R.id.milk:
                if(checked){
                    currentTotal = currentTotal + addInCost;
                    textView.setText(df.format(currentTotal));
                }else{
                    currentTotal = currentTotal - addInCost;
                    textView.setText(df.format(currentTotal));
                }
            case R.id.syrup:
                if(checked){
                    currentTotal = currentTotal + addInCost;
                    textView.setText(df.format(currentTotal));

                }else{
                    currentTotal = currentTotal - addInCost;
                    textView.setText(df.format(currentTotal));
                }
            case R.id.caramel:
                if(checked){
                    currentTotal = currentTotal + addInCost;
                    textView.setText(df.format(currentTotal));
                }else{
                    currentTotal = currentTotal - addInCost;
                    textView.setText(df.format(currentTotal));
                }
            case R.id.whippedCream:
                if (checked){
                    currentTotal = currentTotal + addInCost;
                    textView.setText(df.format(currentTotal));
                }else{
                    currentTotal = currentTotal - addInCost;
                    textView.setText(df.format(currentTotal));

                }
        }
    }
*/
    private void addAddOns(){
        CheckBox cream = (CheckBox)findViewById(R.id.cream);
        CheckBox caramel = (CheckBox)findViewById(R.id.caramel);
        CheckBox milk = (CheckBox)findViewById(R.id.milk);
        CheckBox syrup = (CheckBox)findViewById(R.id.syrup);
        CheckBox whippedCream = (CheckBox)findViewById(R.id.whippedCream);
        if(caramel.isChecked()){
            numAddOns++;
            coffeeOrder.add("Caramel");
        }if(milk.isChecked()){
            numAddOns++;
            coffeeOrder.add("Milk");
        }if(cream.isChecked()){
            numAddOns++;
            coffeeOrder.add("Cream");
        }if(whippedCream.isChecked()){
            numAddOns++;
            coffeeOrder.add("Whipped Cream");
        }if(syrup.isChecked()){
            numAddOns++;
            coffeeOrder.add("Syrup");
        }
    }
    public void addCoffeeOrder(View view) {
        //coffeeOrder.setSize(selectedFromList);
        //coffeeOrder.setQty(quantity);
        coffeeOrder = new Coffee(selectedFromList, quantity,addInsList, numAddOns);
        addAddOns();
        coffeeOrder.setNumAddOn(numAddOns);
        coffeeOrder.itemPrice();

        ArrayList<MenuItem> coffeeOrdered = new ArrayList<>();
        coffeeOrdered.add(coffeeOrder);
        Order order = new Order(coffeeOrdered);
        CurrentOrder1.addMainOrder(order);
        Intent intent = new Intent(this, CurrentOrder1.class);
        //intent.putExtra("Order", coffeeOrder);
        startActivity(intent);
    }
}