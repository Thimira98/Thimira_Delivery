package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.delivery.DATABASE.Order;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

   /* EditText etName;
    EditText etAddress;
    EditText etDistrict;
    EditText etPhone;
    EditText etEmailAddress;*/

    EditText etItem1;
    EditText etItem2;
    EditText etItem3;
    EditText etItem4;
    EditText etItem5;

    EditText etItem1price1;
    EditText etItem2price2;
    EditText etItem3price3;
    EditText etItem4price4;
    EditText etItem5price5;

    Button butUpdate;
    DatabaseReference dbRef;
    Order order;

    private Button btnCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etDistrict = findViewById(R.id.etDistrict);
        etPhone = findViewById(R.id.etPhone);
        etEmailAddress = findViewById(R.id.etEmailAddress);*/
        etItem1=findViewById(R.id.etItem1);
        etItem2=findViewById(R.id.etItem2);
        etItem3=findViewById(R.id.etItem3);
        etItem4=findViewById(R.id.etItem4);
        etItem5=findViewById(R.id.etItem5);

        etItem1price1=findViewById(R.id.etItem1price1);
        etItem2price2=findViewById(R.id.etItem2price2);
        etItem3price3=findViewById(R.id.etItem3price3);
        etItem4price4=findViewById(R.id.etItem4price4);
        etItem5price5=findViewById(R.id.etItem5price5);

        butUpdate = findViewById(R.id.ButtonUpdate);

        order = new Order();

        butUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference();
                dbRef.child("Order").child("Ord1").child("item1").setValue(etItem1.getText().toString().trim());
                dbRef.child("Order/Ord1/item2").setValue(etItem2.getText().toString().trim());
                dbRef.child("Order/Ord1/item3").setValue(etItem3.getText().toString().trim());
                dbRef.child("Order/Ord1/item4").setValue(etItem4.getText().toString().trim());
                dbRef.child("Order/Ord1/item5").setValue(etItem5.getText().toString().trim());

                dbRef.child("Order/Ord1/item1Price1").setValue(etItem2.getText().toString().trim());
                dbRef.child("Order/Ord1/item2Price2").setValue(etItem3.getText().toString().trim());
                dbRef.child("Order/Ord1/item3Price3").setValue(etItem4.getText().toString().trim());
                dbRef.child("Order/Ord1/item4Price4").setValue(etItem5.getText().toString().trim());
                dbRef.child("Order/Ord1/item5Price5").setValue(etItem5.getText().toString().trim());

                Toast.makeText(getApplicationContext(), "Sucessfully updated", Toast.LENGTH_SHORT).show();
                clearControls();
            }
        });
        Intent intent= getIntent();
    }

    public void openSecond(View view) {
        Intent intent = new Intent(this, activity_main_3.class);

            /*intent.putExtra("name", etName.getText().toString());
            intent.putExtra("address", etAddress.getText().toString());
            intent.putExtra("district", etDistrict.getText().toString());
            intent.putExtra("phone", etPhone.getText().toString());
            intent.putExtra("emailAddress", etEmailAddress.getText().toString());*/

        intent.putExtra("n1_1",etItem1.getText().toString());
        intent.putExtra("n2_1",etItem2.getText().toString());
        intent.putExtra("n3_1",etItem3.getText().toString());
        intent.putExtra("n4_1",etItem4.getText().toString());
        intent.putExtra("n5_1",etItem5.getText().toString());

        intent.putExtra("n1_2",etItem1price1.getText().toString());
        intent.putExtra("n2_2",etItem2price2.getText().toString());
        intent.putExtra("n3_2",etItem3price3.getText().toString());
        intent.putExtra("n4_2",etItem4price4.getText().toString());
        intent.putExtra("n5_2",etItem5price5.getText().toString());


        startActivity(intent);

    }

    private void init(){
        //  btnCon = findViewById(R.id.btnCon);

    }
    private void clearControls() {
        etItem1.setText("");
        etItem2.setText("");
        etItem3.setText("");
        etItem4.setText("");
        etItem5.setText("");

        etItem1price1.setText("");
        etItem2price2.setText("");
        etItem3price3.setText("");
        etItem4price4.setText("");
        etItem5price5.setText("");
    }
}