package org.electricity.maasha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DashboardActivity extends AppCompatActivity {

    DatabaseReference databaseReference;

    private TextView monthlyBill;
    private TextView consumption;
    private TextView current;
    private TextView power;

    private Button signoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        monthlyBill = findViewById(R.id.monthlyBillText);
        consumption = findViewById(R.id.consumtion);
        current = findViewById(R.id.current);
        power = findViewById(R.id.power);
        signoutBtn = findViewById(R.id.signoutBtn);



        databaseReference = FirebaseDatabase.getInstance().getReference();

        ValueEventListener billValueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String bill = snapshot.getValue().toString();
                monthlyBill.setText(bill);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        ValueEventListener consumptionValueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String bill = snapshot.getValue().toString();
                consumption.setText(bill);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        ValueEventListener currentValueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String bill = snapshot.getValue().toString();
                current.setText(bill);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        ValueEventListener powerValueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String bill = snapshot.getValue().toString();
                power.setText(bill);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        databaseReference.child("maasha445").child("Bill Monthly Rs").addValueEventListener(billValueEventListener);
        databaseReference.child("maasha445").child("Consumption kWh").addValueEventListener(consumptionValueEventListener);
        databaseReference.child("maasha445").child("Current A").addValueEventListener(currentValueEventListener);
        databaseReference.child("maasha445").child("Power kW").addValueEventListener(powerValueEventListener);


        signoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}