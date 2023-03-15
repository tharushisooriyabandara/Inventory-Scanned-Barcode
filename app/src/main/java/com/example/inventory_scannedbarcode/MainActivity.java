package com.example.inventory_scannedbarcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

     FirebaseDataComparison firebaseDataComparison;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//

        firebaseDataComparison = new FirebaseDataComparison();
        firebaseDataComparison.compare();
    }
}