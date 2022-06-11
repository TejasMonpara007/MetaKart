package com.finalandroid.projectnew.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.finalandroid.projectnew.R;
import com.squareup.picasso.Picasso;

public class AllDetailsActivity extends AppCompatActivity {

    ImageView imageREcyclerDetails;
    private TextView myNameProductText, myNamePriceProduct, productDesc, descPrice, counterText;;
    private int img, pPrice;
    private static int counter;
    private int stringVal;

    private String mParam1, descstrPara;
    private int mParam2;
    private int image;

    private String mmm = "";


    int prodesc;
    String pName;
    Button submitCheckout;

    private CardView btnAddition, btnSubtraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_details);

        myNamePriceProduct = findViewById(R.id.textProductdetailsPrice);
        myNameProductText = findViewById(R.id.textProductdetailsName);
        imageREcyclerDetails = findViewById(R.id.myImageProductDetails);
        submitCheckout = findViewById(R.id.submitCheckout);
        productDesc = findViewById(R.id.textProductdetailsDesc);
        /*descPrice = findViewById(R.id.textProductdetailsPrice);*/

        counterText = findViewById(R.id.textcountNumber);

        Intent ip = getIntent();
        String ssimg = ip.getExtras().getString("image");
        pName = ip.getStringExtra("name");

        prodesc = ip.getIntExtra("prooprice", 0);

        String priDesccc = ip.getExtras().getString("maindesc");

        Picasso.with(AllDetailsActivity.this).load(ssimg).into(imageREcyclerDetails);

        buttonAddOrRemove();

        //Picasso.with(getApplicationContext()).load(img).into(imageREcyclerDetails);

        imageREcyclerDetails.setImageResource(img);
        myNameProductText.setText(pName);
        productDesc.setText(priDesccc);
        myNamePriceProduct.setText(String.valueOf(prodesc));

        submitCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent ii = new Intent(AllDetailsActivity.this, CheckOutActivity.class);

                ii.putExtra("nameproduct", pName);
                ii.putExtra("quantity", stringVal);
                ii.putExtra("imageview",ssimg);
                ii.putExtra("priceee", prodesc);

                startActivity(ii);
            }
        });
    }

    public void buttonAddOrRemove()
    {
        btnAddition = findViewById(R.id.btnAddPlus);
        btnSubtraction = findViewById(R.id.btnAddMinus);

        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<1;i++){

                    counter = Integer.parseInt(counterText.getText().toString());
                    counter+=1;
                    stringVal = counter;
                    counterText.setText(String.valueOf(stringVal));
                }
            }
        });

        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int j=0;j<1;j++){

                    counter = Integer.parseInt(counterText.getText().toString());
                    counter-=1;
                    stringVal = counter;
                    counterText.setText(String.valueOf(stringVal));
                }

            }
        });
    }
}