package com.finalandroid.projectnew.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.finalandroid.projectnew.AddCartAll.CustomerModel;
import com.finalandroid.projectnew.AddCartAll.DAOEmployee;
import com.finalandroid.projectnew.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckOutActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    Spinner spinner;

    int totalPrice;
    private String title;
    private int quantityCounter;
    private static final String ARG_TITLE = "hello";
    private int imageDisplay;
    private int mParam3, mParam4;

    private EditText editCreditCard;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        spinner = findViewById(R.id.spinnerPayment);


        //ImageView imageViewOrderDetails = findViewById(R.id.imageOrderView);
        TextView tv = findViewById(R.id.ordersummaryTextview);
        TextView orderprice =  findViewById(R.id.ordersummaryPrice);
        TextView quantity = findViewById(R.id.ordersummaryQuantity);


        editCreditCard = findViewById(R.id.creditedittext);
        editCreditCard.setVisibility(View.GONE);

        final EditText edit_name = findViewById(R.id.editName);
        final EditText edit_position = findViewById(R.id.editLastName);
        final EditText edit_mobile = findViewById(R.id.editMobileNumber);
        final EditText edit_address = findViewById(R.id.editMobileAddress);
        final EditText edit_country = findViewById(R.id.editCity);

        Intent ip = getIntent();
        title = ip.getStringExtra("nameproduct");
        quantityCounter = ip.getIntExtra("quantity",0);
        imageDisplay = ip.getIntExtra("imageview",0);
        int aa = ip.getIntExtra("priceee", 0);

        totalPrice = quantityCounter * aa;

        tv.setText(title);
        quantity.setText(String.valueOf(quantityCounter));
        orderprice.setText(String.valueOf(totalPrice));
        //imageViewOrderDetails.setImageResource(mParam3);


        spinner.setOnItemSelectedListener(CheckOutActivity.this);

        Button btn = findViewById(R.id.btnCheckout);
        Button btn_open = findViewById(R.id.btnUpdate);
        btn_open.setOnClickListener(v->
        {
            Intent intent =new Intent(CheckOutActivity.this, AllCartActivity.class);
            startActivity(intent);
        });

        DAOEmployee dao =new DAOEmployee();
        CustomerModel emp_edit = (CustomerModel)getIntent().getSerializableExtra("EDIT");

        if(emp_edit !=null)
        {
            btn.setText("UPDATE");
            edit_name.setText(emp_edit.getName());
            edit_position.setText(emp_edit.getPosition());
            edit_address.setText(emp_edit.getAddress());
            edit_mobile.setText(emp_edit.getMobileNumber());
            edit_country.setText(emp_edit.getCountry());
            btn_open.setVisibility(View.GONE);
        }
        else
        {
            btn.setText("Checkout");
            btn_open.setVisibility(View.VISIBLE);

        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edit_name.length() == 0 || edit_position.length() == 0 || edit_mobile.length() == 0
                        || edit_address.length() == 0 || edit_country.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Enter Missing Details", Toast.LENGTH_SHORT).show();
                } else {

                    final Dialog dialog = new Dialog(CheckOutActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setCancelable(false);
                    dialog.setContentView(R.layout.order_dialog);

                    Button dialogButton = (Button) dialog.findViewById(R.id.confirmdialog);
                    TextView tvtxt = dialog.findViewById(R.id.dialogTexts);
                    tvtxt.setText(" Your order is confirmed ");
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent ih = new Intent(CheckOutActivity.this, AllCartActivity.class);
                            startActivity(ih);
                            dialog.dismiss();
                        }
                    });

                    dialog.show();

                    CustomerModel emp = new CustomerModel(edit_name.getText().toString(),
                            edit_position.getText().toString(),
                            edit_mobile.getText().toString(),
                            edit_address.getText().toString(),
                            edit_country.getText().toString());

                    if (emp_edit == null) {
                        dao.add(emp).addOnSuccessListener(suc ->
                        {

                            /*Intent card = new Intent(getApplicationContext(), AllCartActivity.class);
                            startActivity(card);*/
                            Toast.makeText(getApplicationContext(), "Record is inserted", Toast.LENGTH_SHORT).show();

                        }).addOnFailureListener(er ->
                        {
                            Toast.makeText(getApplicationContext(), "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                        });
                    } else {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("name", edit_name.getText().toString());
                        hashMap.put("position", edit_position.getText().toString());
                        hashMap.put("mobile", edit_mobile.getText().toString());
                        hashMap.put("address", edit_address.getText().toString());
                        hashMap.put("country", edit_country.getText().toString());
                        dao.update(emp_edit.getKey(), hashMap).addOnSuccessListener(suc ->
                        {
                            Toast.makeText(getApplicationContext(), "Record is updated", Toast.LENGTH_SHORT).show();

                        }).addOnFailureListener(er ->
                        {
                            Toast.makeText(getApplicationContext(), "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                        });
                    }
                }

            }
        });

       /* btn.setOnClickListener(v->
                {
                    if (edit_name.length() == 0 || edit_position.length() == 0 || edit_mobile.length() == 0
                            || edit_address.length() == 0 || edit_country.length() == 0) {
                        Toast.makeText(getApplicationContext(), "Enter Missing Details", Toast.LENGTH_SHORT).show();
                    } else {

                        final Dialog dialog = new Dialog(CheckOutActivity.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.setCancelable(false);
                        dialog.setContentView(R.layout.order_dialog);

                        Button dialogButton = (Button) dialog.findViewById(R.id.confirmdialog);
                        TextView tvtxt = dialog.findViewById(R.id.dialogTexts);
                        tvtxt.setText(" Your order is confirmed ");
                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent ih = new Intent(CheckOutActivity.this, AllCartActivity.class);
                                startActivity(ih);
                                dialog.dismiss();
                            }
                        });

                        dialog.show();

                        CustomerModel emp = new CustomerModel(edit_name.getText().toString(),
                                edit_position.getText().toString(),
                                edit_mobile.getText().toString(),
                                edit_address.getText().toString(),
                                edit_country.getText().toString());

                        if (emp_edit == null) {
                            dao.add(emp).addOnSuccessListener(suc ->
                            {

                                Intent card = new Intent(getApplicationContext(), AllCartActivity.class);
                                startActivity(card);
                                Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();

                            }).addOnFailureListener(er ->
                            {
                                Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                            });
                        } else {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("name", edit_name.getText().toString());
                            hashMap.put("position", edit_position.getText().toString());
                            hashMap.put("mobile", edit_mobile.getText().toString());
                            hashMap.put("address", edit_address.getText().toString());
                            hashMap.put("country", edit_country.getText().toString());
                            dao.update(emp_edit.getKey(), hashMap).addOnSuccessListener(suc ->
                            {
                                Toast.makeText(this, "Record is updated", Toast.LENGTH_SHORT).show();
                                finish();
                            }).addOnFailureListener(er ->
                            {
                                Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                            });
                        }
                    }*/



                List<String> categories = new ArrayList<String>();

                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

                categories.add("Cash");
                categories.add("Debit/Credit");


                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if(spinner.getItemAtPosition(i).toString().equalsIgnoreCase("Debit/Credit"))
        {
            editCreditCard.setVisibility(View.VISIBLE);
        }
        else {
            editCreditCard.setVisibility(View.GONE);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}