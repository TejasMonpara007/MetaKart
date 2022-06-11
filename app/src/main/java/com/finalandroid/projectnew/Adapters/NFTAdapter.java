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

import com.finalandroid.projectnew.Activities.AllDetailsActivity;
import com.finalandroid.projectnew.Models.NftModel;
import com.finalandroid.projectnew.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class NFTAdapter extends FirebaseRecyclerAdapter<NftModel, NFTAdapter.NFTViewHolder> {

    private Context mContext;

    public NFTAdapter(@NonNull FirebaseRecyclerOptions<NftModel> options, Context mContext) {
        super(options);
        this.mContext = mContext;

    }

    @Override
    protected void onBindViewHolder(@NonNull NFTAdapter.NFTViewHolder holder, int position, @NonNull NftModel model) {

        holder.firstname.setText(model.getProductname());

        holder.proprice.setText(String.valueOf(model.getPrice()));

        Picasso.with(mContext)
                .load(model.getImage())
                .placeholder(R.mipmap.nft_four)
                .fit()
                .centerCrop()
                .into(holder.age);

        holder.cardclickHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent card = new Intent(mContext, AllDetailsActivity.class);
                card.putExtra("name", model.getProductname());

                card.putExtra("image", model.getImage());
                card.putExtra("prooprice", model.getPrice());
                card.putExtra("maindesc", model.getDescription());
                card.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                mContext.startActivity(card);

            }
        });
    }

    @NonNull
    @Override
    public NFTAdapter.NFTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_data_home, parent, false);
        return new NFTAdapter.NFTViewHolder(view);
    }

    class NFTViewHolder extends RecyclerView.ViewHolder {
        private TextView firstname, proprice;
        ImageView age;
        private CardView cardclickHolder;


        public NFTViewHolder(@NonNull View itemView) {
            super(itemView);

            firstname = itemView.findViewById(R.id.firstname);
            proprice = itemView.findViewById(R.id.proprice);
            cardclickHolder = itemView.findViewById(R.id.cardClickHolder);
            age = itemView.findViewById(R.id.metaImg);
        }
    }
}
