package com.finalandroid.projectnew.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.finalandroid.projectnew.Models.MyProductModel;
import com.finalandroid.projectnew.R;

public class MyProductAdapter extends RecyclerView.Adapter<MyProductAdapter.MyViewHolder> {

    private MyProductModel[] listdata;
    Context myContext;

    public MyProductAdapter(Context myContext, MyProductModel[] listdata) {
        this.listdata = listdata;
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.recycler_data, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final MyProductModel myListData = listdata[position];
        holder.textViewRecyclerName.setText(listdata[position].getName());
        holder.textViewPriceRec.setText(String.valueOf(listdata[position].getPrice()));
        holder.imageViewRecycler.setImageResource(listdata[position].getImgId());


        holder.cardREcycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewRecycler;
        CardView cardREcycler;
        public TextView textViewRecyclerName, textViewPriceRec;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardREcycler = (CardView) itemView.findViewById(R.id.cardviewRecycler);
            imageViewRecycler = (ImageView) itemView.findViewById(R.id.imageViewRecycler);
            textViewRecyclerName = (TextView) itemView.findViewById(R.id.textViewRecyclerName);
            textViewPriceRec = (TextView) itemView.findViewById(R.id.textViewRecyclerPrice);
        }
    }
}
