package com.example.rucafe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import android.content.Context;
import android.widget.ListView;
import java.util.ArrayList;
import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.List;

public class CurrentOrder1 extends AppCompatActivity {

    //TextView subTotalView = (TextView) findViewById(R.id.subTotalView);
   // TextView taxView = (TextView) findViewById(R.id.taxView);
   // TextView totalView = (TextView)  findViewById(R.id.totalView);
    DecimalFormat df = new DecimalFormat("0.00"); //look at format
    private static ArrayList<MenuItem> orderItems = new ArrayList<>();
    private static ArrayList<MenuItem> orders = new ArrayList<>();

    private static Order partialOrder= new Order(orders);
    ListView currentOrderListView;
    private String size;
    private double tax;
    private static double price;

    private double subTotal;
    private double totalPrice;
    private final double taxRate = 0.06625;


    public static Order getCurrentOrder(){
        return partialOrder;
    }

    public static void addMainOrder(Order menuItems){
        for(MenuItem item: menuItems.getItems()){
            orderItems.add(item);
            partialOrder.add(item);
            if(item instanceof Coffee){
                price = price +  ((Coffee) item).getCoffeePrice();
            }
            if(item instanceof Donut){
                price = price + ((Donut) item).getDonutPrice();
            }
            partialOrder.setTotalPrice(price);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);

        Intent intent = getIntent();
        settingText(partialOrder);

        //Context context = getApplicationContext();
       // CharSequence text = coffeeOrder.toString();
        //CharSequence text = df.format(coffeeOrder.getCoffeePrice());
        //CharSequence text = newPartialOrder.toString();
        //int duration = Toast.LENGTH_SHORT;

        //Toast toast = Toast.makeText(context, text, duration);
        //toast.show();


        currentOrderListView = findViewById(R.id.currentOrderListView);
        //for(int i =0; i< orderItems.size(); i++) {
            ArrayAdapter<MenuItem> arrayAdptSelected = new ArrayAdapter<MenuItem>(this, android.R.layout.simple_list_item_1,orderItems);// (List<MenuItem>) orderItems.get(i));
            currentOrderListView.setAdapter(arrayAdptSelected);

       // }
        currentOrderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //on click in list view
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            }
        });
    }
    public void settingText(Order order){
        TextView subTotalView = (TextView) findViewById(R.id.subTotalView);
        TextView taxView = (TextView) findViewById(R.id.taxView);
        TextView totalView = (TextView)  findViewById(R.id.totalView);

        subTotal = order.getTotalPrice();
        tax = subTotal * taxRate;
        totalPrice =  subTotal + tax;
        subTotalView.setText(df.format(subTotal));
        taxView.setText(df.format(tax));
        totalView.setText(df.format(totalPrice));

    }

}