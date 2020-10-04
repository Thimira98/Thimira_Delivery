package com.example.delivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.delivery.DATABASE.Order;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_main_2 extends AppCompatActivity {
    /*private EditText total;
    private EditText charges;
    private EditText amount;
    private Button btnCon;*/

    /*private EditText etName;
    private EditText etAddress;
    private EditText etDistrict;
    private EditText etPhone;
    private EditText etEmailAddress;*/
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
    TextView lbSum;

    //price
    String item1_2;
    String item2_2;
    String item3_2;
    String item4_2;
    String item5_2;

    Button butDelete;
    DatabaseReference dbRef;
    Order order;

    int n1_2, n2_2, n3_2, n4_2, n5_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        //Item name
        etItem1 = findViewById(R.id.etItem1);
        etItem2 = findViewById(R.id.etItem2);
        etItem3 = findViewById(R.id.etItem3);
        etItem4 = findViewById(R.id.etItem4);
        etItem5 = findViewById(R.id.etItem5);

        //Item price
        etItem1price1 = findViewById(R.id.etItem1price1);
        etItem2price2 = findViewById(R.id.etItem2price2);
        etItem3price3 = findViewById(R.id.etItem3price3);
        etItem4price4 = findViewById(R.id.etItem4price4);
        etItem5price5 = findViewById(R.id.etItem5price5);
        lbSum = findViewById(R.id.lbSum);

        butDelete = findViewById(R.id.BtnDelete);

        order = new Order();

        butDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Order").child("Ord1");
                dbRef.child("Order").child("Ord1").child("item1").setValue(etItem1.getText().toString().trim());
                dbRef.child("Order/Ord1/item2").setValue(etItem2.getText().toString().trim());
                dbRef.child("Order/Ord1/item3").setValue(etItem3.getText().toString().trim());
                dbRef.child("Order/Ord1/item4").setValue(etItem4.getText().toString().trim());
                dbRef.child("Order/Ord1/item5").setValue(etItem5.getText().toString().trim());
                dbRef.removeValue();
                Toast.makeText(getApplicationContext(), "Successfully deleted", Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent = getIntent();
        //Item name
        String item1_1 = intent.getStringExtra("n1_1");
        String item2_1 = intent.getStringExtra("n2_1");
        String item3_1 = intent.getStringExtra("n3_1");
        String item4_1 = intent.getStringExtra("n4_1");
        String item5_1 = intent.getStringExtra("n5_1");

        //Item Price
        item1_2 = intent.getStringExtra("n1_2");
        item2_2 = intent.getStringExtra("n2_2");
        item3_2 = intent.getStringExtra("n3_2");
        item4_2 = intent.getStringExtra("n4_2");
        item5_2 = intent.getStringExtra("n5_2");

        //Item Name Display
        etItem1.setText(item1_1);
        etItem2.setText(item2_1);
        etItem3.setText(item3_1);
        etItem4.setText(item4_1);
        etItem5.setText(item5_1);

        //price Display
        etItem1price1.setText(item1_2);
        etItem2price2.setText(item2_2);
        etItem3price3.setText(item3_2);
        etItem4price4.setText(item4_2);
        etItem5price5.setText(item5_2);

        n1_2 = Integer.parseInt(item1_2);
        n2_2 = Integer.parseInt(item2_2);
        n3_2 = Integer.parseInt(item3_2);
        n4_2 = Integer.parseInt(item4_2);
        n5_2 = Integer.parseInt(item5_2);


       /* etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etDistrict = findViewById(R.id.etDistrict);
        etPhone = findViewById(R.id.etPhone);
        etEmailAddress = findViewById(R.id.etEmailAddress);
       // btnCon = (Button) findViewById(R.id.btnCon);*/

       /*btnCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openthird();
            }
        });*/


        //Register
      /*  total = findViewById(R.id.etTotal);
        charges = findViewById(R.id.etcharges);
        amount = findViewById(R.id.etAmount);

        //setting data
        total.setText("Rs 50,230/=");
        charges.setText("Rs 500/=");
        amount.setText("Rs 50,830/=");*/


    }

    public void add(View view) {
        lbSum.setText(item1_2 + " + " + item2_2 + " + " + item3_2 + " + " + item4_2 + " + " + item5_2 + " = " + (n1_2 + n2_2 + n3_2 + n4_2 + n5_2));
    }


    public void openThird(View view) {
        Intent intent = new Intent(this, activity_main_3.class);
        Toast.makeText(this, "Thank You!", Toast.LENGTH_SHORT).show();

        //startActivity(intent);
       /* intent.putExtra("name", etName.getText().toString());
        intent.putExtra("address", etAddress.getText().toString());
        intent.putExtra("district", etDistrict.getText().toString());
        intent.putExtra("phone", etPhone.getText().toString());
        intent.putExtra("emailAddress", etEmailAddress.getText().toString());*/

        startActivity(intent);
    }

            /* public void openthird(View view) {
                    Intent intent = new Intent(this, activity_main_3.class);
                    intent.putExtra("name",etName.getText().toString());
                    intent.putExtra("address",etAddress.getText().toString());
                    intent.putExtra("district",etDistrict.getText().toString());
                    intent.putExtra("phone",etPhone.getText().toString());
                    intent.putExtra("emailAddress",etEmailAddress.getText().toString());

                    startActivity(intent);
                }*/

}