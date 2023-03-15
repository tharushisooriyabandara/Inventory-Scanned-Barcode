package com.example.inventory_scannedbarcode;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.*;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDataComparison {

    public static void compare() {
        // Get references to the "data" and "comparison" nodes in Firebase
        DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference("Inventory");
        DatabaseReference comparisonRef = FirebaseDatabase.getInstance().getReference("Scanned_Barcode1");

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("path/to/data");


        // Add a ValueEventListener to the "data" node to retrieve the data
        dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Create a list to store the retrieved items
                List<Item> items = new ArrayList<>();
                // Loop through the child nodes of the "data" node
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    // Get the values of the child nodes and create an Item object
                    String price = (String) childSnapshot.child("Price").getValue();
                    String weight = (String) childSnapshot.child("Weight").getValue();
                    String barcode = (String) childSnapshot.child("barcode").getValue();
                    String timestamp = (String) childSnapshot.child("timestamp").getValue();
                    Item item = new Item(price, weight, barcode, timestamp);
                    // Add the item to the list
                    items.add(item);
                }

                // Add a ValueEventListener to the "comparison" node to retrieve the data
                comparisonRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Create a list to store the matching items
                        List<Item> matchingItems = new ArrayList<>();
                        // Loop through the child nodes of the "comparison" node
                        for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                            // Get the barcode value of the child node
                            String barcode = (String) childSnapshot.child("barcode").getValue();
                            // Loop through the items in the "data" list and compare their barcodes with the "comparison" barcode
                            for (Item item : items) {
                                if (item.getBarcode().equals(barcode)) {
                                    // If a match is found, add the matching item to the list and break out of the loop
                                    matchingItems.add(item);
                                    break;
                                }
                            }
                        }

                        // Do something with the matching items, such as printing them out to the console
                        for (Item item : matchingItems) {
                            System.out.println(item.toString());
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle error
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle error
            }
        });
    }
}



