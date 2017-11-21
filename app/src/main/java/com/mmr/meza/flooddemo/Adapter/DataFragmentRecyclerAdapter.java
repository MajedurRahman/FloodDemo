package com.mmr.meza.flooddemo.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mmr.meza.flooddemo.Model.DataItem;
import com.mmr.meza.flooddemo.R;

import java.util.ArrayList;

/**
 * Created by Majedur Rahman on 10/18/2017.
 */

public class DataFragmentRecyclerAdapter extends RecyclerView.Adapter<DataFragmentRecyclerAdapter.DataFragmentHolder> {

    Context context;
    ArrayList<DataItem> dataItems;
    LayoutInflater layoutInflater;

    public DataFragmentRecyclerAdapter(Context context, ArrayList<DataItem> dataItemArrayList) {

        this.context = context;
        this.dataItems = dataItemArrayList;
        layoutInflater = LayoutInflater.from(context);


    }

    @Override
    public DataFragmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.data_item, parent, false);

        return new DataFragmentHolder(view);
    }

    @Override
    public void onBindViewHolder(DataFragmentHolder holder, int position) {


        if (dataItems.get(position).getTitle().contains("5")){
            int backgroundColor = ContextCompat.getColor(context, R.color.onGreen);
            holder.cardView.setCardBackgroundColor(backgroundColor);
            holder.dataTV.setTextColor(Color.WHITE);
        }
        else if (dataItems.get(position).getTitle().contains("6")){
            int backgroundColor = ContextCompat.getColor(context, R.color.yellowgreen);
            holder.cardView.setCardBackgroundColor(backgroundColor);
            holder.dataTV.setTextColor(Color.WHITE);
        }
        else if (dataItems.get(position).getTitle().contains("7")){
            int backgroundColor = ContextCompat.getColor(context, R.color.colorSun);
            holder.cardView.setCardBackgroundColor(backgroundColor);
            holder.dataTV.setTextColor(Color.WHITE);
        }
        else if (dataItems.get(position).getTitle().contains("8")){
            int backgroundColor = ContextCompat.getColor(context, R.color.colorOrange);
            holder.cardView.setCardBackgroundColor(backgroundColor);
            holder.dataTV.setTextColor(Color.WHITE);
        }
        else if (dataItems.get(position).getTitle().contains("9")){
            int backgroundColor = ContextCompat.getColor(context, R.color.sweetPink);
            holder.cardView.setCardBackgroundColor(backgroundColor);
            holder.dataTV.setTextColor(Color.WHITE);
        }

        holder.dataTV.setText(dataItems.get(position).getTitle());
        holder.timeTV.setText(dataItems.get(position).getTime());
        holder.dateTV.setText(dataItems.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public static class DataFragmentHolder extends RecyclerView.ViewHolder {


        TextView timeTV;
        TextView dateTV;
        TextView dataTV;
        CardView cardView;

        public DataFragmentHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.data_card);
            timeTV = itemView.findViewById(R.id.timeData);
            dataTV = itemView.findViewById(R.id.dataTitleTV);
            dateTV = itemView.findViewById(R.id.dateData);


        }
    }
}
