package com.example.rucafe;

import java.util.ArrayList;

/**
 * This class extends menuitem that encapsulates the datafields and method for a donut order.
 * @author Siddhi Kasera, Sonal Madhok
 */

public class Donut extends MenuItem implements Customizable {

    //private String type;
    private String flavor; //chocolate, strawberry, sugar_glazed.
    private double price;
    private final double donutPrice = 1.39;
    private int quantity = 0;
    private ArrayList<Integer> quantityList = new ArrayList<Integer>();


    /**
     * Two parameter constructor for donut
     * @param flavor flavor of donut
     * @param quantityList quantity of donut selected
     */
    public Donut(String flavor, ArrayList<Integer> quantityList){
        super();
        this.flavor = flavor;
        this.quantityList = quantityList;
    }

    public void qtyListCount(ArrayList<Integer> quantityList){
        System.out.println("List is " + quantityList);
        for(int i =0; i< quantityList.size(); i++){
            quantity = quantityList.get(i);
        }
        System.out.println("Quantity is " + quantity);
    }


    /**
     * Calculates the price for donuts.
     */
    public void itemPrice(){
        //System.out.println("In the item price method in donut type " + this.type);
        qtyListCount(quantityList);
        price = donutPrice * quantity;

    }
    public double getDonutPrice(){
        return price;
    }
    /**
     * Adds the quantity of donuts in a list
     * @param obj to be added in the list
     * @return
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Integer){
            quantityList.add((Integer) obj);
            quantity = (Integer) obj;
        }
        return true;
    }

    /**
     * removes the quantity of donuts in a list
     * @param obj to be added in the list
     * @return returns true if successfully added.
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Integer){
            quantityList.remove((String) obj);
            //quantity--;
        }
        return true;
    }

    /**
     * Returns string form of the object
     * @return string
     */
    @Override
    public String toString(){
        return ( this.flavor + " " + this.quantityList);
    }
}