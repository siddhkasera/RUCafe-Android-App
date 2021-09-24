package com.example.rucafe;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

public class CurrentOrder extends AppCompatActivity {

    ListView currentOrderListView;
    ArrayList<String> menuItemsList = new ArrayList<>(); //might have to change to list of menuItem type ?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);

        //list view for orders
        currentOrderListView = findViewById(R.id.currentOrderListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menuItemsList);
        getOrderList();
        currentOrderListView.setAdapter(arrayAdapter);
        currentOrderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedOrder = menuItemsList.get(position);
                Toast.makeText(getApplicationContext(), "com.example.rucafe.Order selected: " + selectedOrder, Toast.LENGTH_LONG).show();
            }

        });

    }

    void getOrderList()
    {

        menuItemsList.add("sample");


    }

    //remove order button




    //place order button



}