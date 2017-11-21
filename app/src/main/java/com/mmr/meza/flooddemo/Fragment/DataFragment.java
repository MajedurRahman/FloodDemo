package com.mmr.meza.flooddemo.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mmr.meza.flooddemo.Adapter.DataFragmentRecyclerAdapter;
import com.mmr.meza.flooddemo.Adapter.HomeRecyclerAdapter;
import com.mmr.meza.flooddemo.Model.DataItem;
import com.mmr.meza.flooddemo.Model.FloodData;
import com.mmr.meza.flooddemo.R;

import java.util.ArrayList;


public class DataFragment extends Fragment {


    public DataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_data, container, false);

        getDataFromFireBase();
        initRecyclerView(parentView);
        return parentView;
    }


    private void initRecyclerView(View view) {


        ArrayList<DataItem> dataList = new ArrayList<>();

        /***
         * Add Menu here
         */


        dataList.add(new DataItem("Water Level - 7 ", "1:30 AM", "14/11/2017"));
        dataList.add(new DataItem("Water Level - 5 ", "9:00 PM", "13/11/2017"));
        dataList.add(new DataItem("Water Level - 6 ", "11:30 AM", "13/11/2017"));
        dataList.add(new DataItem("Water Level - 8 ", "5:00 AM", "13/11/2017"));
        dataList.add(new DataItem("Water Level - 7 ", "9:30 AM", "13/11/2017"));
        dataList.add(new DataItem("Water Level - 6 ", "1:00 PM", "12/11/2017"));
        dataList.add(new DataItem("Water Level - 5 ", "6:30 AM", "12/11/2017"));
        dataList.add(new DataItem("Water Level - 6 ", "10:50 PM", "11/11/2017"));
        dataList.add(new DataItem("Water Level - 5 ", "12:05 AM", "11/11/2017"));

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.dataRecycler);


     //   GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
         LinearLayoutManager layout = new LinearLayoutManager(getActivity());

        DataFragmentRecyclerAdapter adapter = new DataFragmentRecyclerAdapter(getActivity(), dataList);
        rv.setAdapter(adapter);
        rv.setLayoutManager(layout);

    }


    void getDataFromFireBase(){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dataRoot = database.getReference("FloodData");
        final DatabaseReference area_bhugai_nakuagaonRef = database.getReference("FloodData").child("0").child("area_bhugai_nakuagaon").getRef();
        DatabaseReference area_jariajanjail_jariajanjailRef = database.getReference("FloodData").child("1").child("area_jariajanjail_jariajanjail").getRef();


        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                area_bhugai_nakuagaonRef.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {




                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }


}
