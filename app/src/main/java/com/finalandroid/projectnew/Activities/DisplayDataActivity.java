package com.finalandroid.projectnew.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.finalandroid.projectnew.Adapters.NFTAdapter;
import com.finalandroid.projectnew.Models.NftModel;
import com.finalandroid.projectnew.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DisplayDataActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    NFTAdapter adapter;
    DatabaseReference mbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        mbase = FirebaseDatabase.getInstance().getReference();

        recyclerView = findViewById(R.id.recycler1);

        FirebaseRecyclerOptions<NftModel> options
                = new FirebaseRecyclerOptions.Builder<NftModel>()
                .setQuery(mbase, NftModel.class)
                .build();

        adapter = new NFTAdapter(options, getApplicationContext());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
       // adapter.startListening();

    }

    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }
}