package com.example.rucafe;


import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Context;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
public class StoreOrdering extends AppCompatActivity {

    // private static ArrayList<Order> orders = new ArrayList<>();
    private static StoreOrders mainOrder = new StoreOrders();
    private static ArrayList<Order> orderArrayList = new ArrayList<Order>();
    private static ArrayList<Order> orderItems = new ArrayList<>();
    private static ArrayList<Integer> orderNumList = new ArrayList<>();

    Order orderSelected;

    ListView allOrderList;
    TextView totalView;

    public static void addMainOrder(Order order) {
        //for (int i = 0; i < order.; i++) {
        mainOrder.add(order);//getListOfOrders().get(i));
        //}

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);


        totalView = findViewById(R.id.totalView);
        //totalView = Double.parseDouble(mainOrder.listOfOrders.get(0).getTotalPrice());


        for (int i = 1; i <= mainOrder.listOfOrders.size(); i++) {
            orderNumList.add(i);
        }

        for (int i = 0; i < mainOrder.listOfOrders.size(); i++) {
            orderItems.add(mainOrder.listOfOrders.get(i));
        }

        final Spinner qtySpinner = findViewById(R.id.orderNumberSpinner);
        ArrayAdapter<Integer> arrayAdapterQty = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, orderNumList);
        arrayAdapterQty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        qtySpinner.setAdapter(arrayAdapterQty);
        qtySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + tutorialsName, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        allOrderList = findViewById(R.id.storeOrdersListView);
        final ArrayAdapter<Order> arrayAdptSelected = new ArrayAdapter<Order>(this, android.R.layout.simple_list_item_1, orderItems);// (List<MenuItem>) orderItems.get(i));
        allOrderList.setAdapter(arrayAdptSelected);

        allOrderList.setOnItemClickListener(new AdapterView.OnItemClickListener() { //on click in list view
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //itemSelected = (MenuItem) currentOrderListView.getItemAtPosition(position);
                orderSelected = (Order) allOrderList.getItemAtPosition(position);
                Context context = getApplicationContext();

                CharSequence text = "Please click longer to delete the item";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        });

        allOrderList = findViewById(R.id.storeOrdersListView);
        allOrderList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                orderSelected = (Order)  allOrderList.getItemAtPosition(position);
                final int itemPosition = position;
                new AlertDialog.Builder(StoreOrdering.this).setTitle("Are you sure ?")
                        .setMessage("Do you want to delete this order")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                orderItems.remove(itemPosition);
                                int orderNumber = orderSelected.getOrderNumber();
                                removeOrder(orderNumber);
                                //settingText(partialOrder);
                                arrayAdptSelected.notifyDataSetChanged();


                            }

                        })
                        .setNegativeButton("No", null)
                        .show();

                return true;
            }

        });



    }

    private void removeOrder(int orderNumber){
        for(int i =0; i< mainOrder.getListOfOrders().size(); i++)
        {
            if(mainOrder.getListOfOrders().get(i).getOrderNumber() == orderNumber){
                mainOrder.remove(mainOrder.getListOfOrders().get(i));
            }
        }
    }



}