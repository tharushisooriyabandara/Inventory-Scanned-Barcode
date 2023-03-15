package com.example.inventory_scannedbarcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity<FirebaseDataComparison> extends AppCompatActivity {

    private FirebaseDataComparison firebaseDataComparison;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        firebaseDataComparison = new FirebaseDataComparison();
//        firebaseDataComparison.compareData();
    }
}