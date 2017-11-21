package com.mmr.meza.flooddemo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mmr.meza.flooddemo.Activity.AppHome;
import com.mmr.meza.flooddemo.Activity.BarChartAcivity;
import com.mmr.meza.flooddemo.Activity.BubbleChartActivity;
import com.mmr.meza.flooddemo.Activity.ColumnChartActivity;
import com.mmr.meza.flooddemo.Activity.LineChartActivity;
import com.mmr.meza.flooddemo.Activity.LineColumnDependencyActivity;
import com.mmr.meza.flooddemo.Activity.PieChartActivity;
import com.mmr.meza.flooddemo.Activity.PointChart;
import com.mmr.meza.flooddemo.Activity.PreviewColumnChartActivity;
import com.mmr.meza.flooddemo.Activity.SpeedChartActivity;
import com.mmr.meza.flooddemo.Model.HomeItem;
import com.mmr.meza.flooddemo.R;

import java.util.ArrayList;


/**
 * Created by Majedur Rahman on 10/18/2017.
 */

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ItemHolder> {

    Context context;
    ArrayList<HomeItem> homeItems;
    LayoutInflater layoutInflater;


    public HomeRecyclerAdapter(Context context, ArrayList<HomeItem> itemArrayList) {
        this.context = context;
        this.homeItems = itemArrayList;
        layoutInflater = LayoutInflater.from(context);


    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.home_menu_item, parent, false);

        return new ItemHolder(view ,context);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {


        holder.onClick(position );
        holder.imageViewMenu.setImageResource(homeItems.get(position).getImage());
        holder.textViewTitle.setText(homeItems.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }

    public static class ItemHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        ImageView imageViewMenu;
        CardView cardView;
        Context context;
        public ItemHolder(View itemView ,final Context con) {
            super(itemView);
            context=con;
            cardView = itemView.findViewById(R.id.homeCard);
            textViewTitle = itemView.findViewById(R.id.titleTextView);
            imageViewMenu = itemView.findViewById(R.id.itemImage);
        }


        public void onClick(final int position){

           cardView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   switch (position){

                       case 0:
                           context.startActivity(new Intent(context, AppHome.class).putExtra("activity",0));
                           break;
                       case 1:
                            context.startActivity(new Intent(context, AppHome.class).putExtra("activity",1));
                           break;
                       case 2:
                           context.startActivity(new Intent(context,AppHome.class).putExtra("activity",2));
                           break;
                       case 3:
                           context.startActivity(new Intent(context, AppHome.class).putExtra("activity",3));
                           break;
                       case 4:
                           context.startActivity(new Intent(context,AppHome.class).putExtra("activity",4));
                           break;
                   }


               }
           });

        }
    }
}
