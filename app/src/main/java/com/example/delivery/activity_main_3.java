package com.example.delivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.delivery.DATABASE.Order;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_main_3 extends activity_main_2 {

    //EditText txtName, txtAddress, txtDistrict, txtPhone, txtEmailAddress;
    EditText etName, etAddress, etDistrict, etPhone, etEmailAddress;
    Button butUpdate, butSaveCon;
    DatabaseReference dbRef;
    Order order;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);

        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etDistrict = findViewById(R.id.etDistrict);
        etPhone = findViewById(R.id.etPhone);
        etEmailAddress = findViewById(R.id.etEmailAddress);


        butUpdate=(Button)findViewById(R.id.BtnUpdate);
        butSaveCon=(Button)findViewById(R.id.BtnCOM);

        order = new Order();
        dbRef= FirebaseDatabase.getInstance().getReference().child("Order");

        butUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference();
                dbRef.child("Order").child("Ord1").child("name").setValue(etName.getText().toString().trim());
                dbRef.child("Order/Ord1/address").setValue(etAddress.getText().toString().trim());
                Toast.makeText(getApplicationContext(), "Sucessfully updated", Toast.LENGTH_SHORT).show();
                clearControls();
            }
        });

        butSaveCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int userPhone = Integer.parseInt(etPhone.getText().toString().trim());

                order.setName(etName.getText().toString().trim());
                order.setAddress(etAddress.getText().toString().trim());
                order.setDisrict(etDistrict.getText().toString().trim());
                order.setPhoneNumber(userPhone);
                order.setEmail(etEmailAddress.getText().toString().trim());

                dbRef.push().setValue(order);
                Toast.makeText(activity_main_3.this, "Sucessfully Inserted", Toast.LENGTH_LONG).show();
            }
        });


    }

    private void openActivity_main_2() {
        Intent intent = new Intent(this, activity_main_2.class);
        startActivity(intent);

    }

    private void clearControls() {
        etName.setText("");
        etAddress.setText("");
        etDistrict.setText("");
        etPhone.setText("");
        etEmailAddress.setText("");
    }
}