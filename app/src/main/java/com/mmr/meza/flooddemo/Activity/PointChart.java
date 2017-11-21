package com.mmr.meza.flooddemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.mmr.meza.flooddemo.Plotter;
import com.mmr.meza.flooddemo.R;

import java.util.ArrayList;
import java.util.List;

public class PointChart extends AppCompatActivity {

    private Plotter plotter;
    private List<Integer> plots =  new ArrayList<>();
    private int numberOfPlots = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_chart);


        plotter = (Plotter) findViewById(R.id.plotter_view);
        plotData();



    }

    public void refresh(View view){

        plotData();
    }

    private void plotData(){

        plotter.invalidate();
        plots.clear();

        for(int i = numberOfPlots; i>0; i--){
            plots.add((int)(Math.random()*10));

        }

        plotter.setRowCol(10,10);
        plotter.setPlots(plots);
    }
}
