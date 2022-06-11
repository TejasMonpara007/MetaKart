package com.finalandroid.projectnew.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.finalandroid.projectnew.Adapters.MyProductAdapter;
import com.finalandroid.projectnew.Adapters.ViewPagerAdapterForMainActivity;
import com.finalandroid.projectnew.MainActivity;
import com.finalandroid.projectnew.Models.MyProductModel;
import com.finalandroid.projectnew.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Timer;
import java.util.TimerTask;

public class HomePageActivity extends AppCompatActivity {

    ImageView btnLogoutt;
    private Button viewNfts;
    private TextView userTxt;


    private CardView homeCardView;
    private Button buyNow, viewMore;

    TextView username;
    SharedPreferences sharedPreferences;

    Toolbar toolbar;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;
    final long PERIOD_MS = 4000;

    private RecyclerView recycleProducts;


    int NUM_PAGES = 4;

    ViewPager viewPagerMainActivity;
    int[] imageIconMainActivity = new int[]

            {
                    R.mipmap.nft_nine, R.mipmap.nft_two,
                    R.mipmap.nft_thirteen
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        viewMore = findViewById(R.id.ViewMore);
        homeCardView = findViewById(R.id.card_home);

        btnLogoutt = findViewById(R.id.log_out);
        /*userTxt = findViewById(R.id.txtUSerName);
        viewNfts = findViewById(R.id.btnViewNfts);*/

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        recycleProducts = findViewById(R.id.recyclerProducts);

        MyProductModel[] myListData = new MyProductModel[] {
                new MyProductModel("Cycber Kong", R.mipmap.nft_fourteen, 20, " "),
                new MyProductModel("Fat Ape", R.mipmap.nft_new, 25, " "),
                new MyProductModel("Monkartist", R.mipmap.nft_four, 30, " "),
                new MyProductModel("Ray moondsend", R.mipmap.nft_ten, 35, ""),
                new MyProductModel("Painting for Art", R.mipmap.nft_thirteen, 40, ""),
                new MyProductModel("Singular Art", R.mipmap.nft_elevan, 45, ""),

        };

        MyProductAdapter myProductAdapter = new MyProductAdapter(getApplicationContext(),myListData);
        recycleProducts.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recycleProducts.setAdapter(myProductAdapter);
/*
        if (firebaseUser!= null)
        {
            String email = firebaseUser.getEmail();
            userTxt.setText(email.toString());
        }*/

        btnLogoutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent ik = new Intent(HomePageActivity.this, MainActivity.class);
                startActivity(ik);
            }
        });

       /* viewNfts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ik = new Intent(HomePageActivity.this, DisplayDataActivity.class);
                startActivity(ik);

            }
        });*/

        buyNow = findViewById(R.id.btn_buy_now);
        buyButtonClick();

        // fragment

        viewPagerMainActivity = findViewById(R.id.view_pager_main_activity);
        ViewPagerAdapterForMainActivity adaptersss = new ViewPagerAdapterForMainActivity(this, imageIconMainActivity);
        viewPagerMainActivity.setAdapter(adaptersss);

        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {

                if (currentPage == NUM_PAGES - 1) {
                    currentPage = 0;
                }
                viewPagerMainActivity.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(update);
            }
        }, DELAY_MS, PERIOD_MS);


    }

    public void buyButtonClick()
    {
        buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bIntent = new Intent(HomePageActivity.this, DisplayDataActivity.class);
                startActivity(bIntent);
            }
        });

        viewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bIntent = new Intent(HomePageActivity.this, DisplayDataActivity.class);
                startActivity(bIntent);
            }
        });
    }
}