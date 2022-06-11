package com.finalandroid.projectnew.AddCartAll;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.finalandroid.projectnew.R;

public class CustomerViewHolder extends RecyclerView.ViewHolder
{
    public TextView txt_name,txt_last_name,txt_option, proname;

    public CustomerViewHolder(@NonNull View itemView)
    {
        super(itemView);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_last_name = itemView.findViewById(R.id.last_nametxt);
        txt_option = itemView.findViewById(R.id.txt_option);
        //proname = itemView.findViewById(R.id.proname);
    }
}
