package com.mmr.meza.flooddemo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mmr.meza.flooddemo.R;

import lecho.lib.hellocharts.view.BubbleChartView;

public class AppHome extends AppCompatActivity {

    private int activitynuber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent FlagActivity = getIntent();

        activitynuber = FlagActivity.getIntExtra("activity", -1);


    }

    public void onClick(View view) {

        if (activitynuber != -1) {


            switch (activitynuber){
                case 0:
                    startActivity(new Intent(this, ColumnChartActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(this, PreviewColumnChartActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(this, PieChartActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(this, LineColumnDependencyActivity.class));
                    break;
                case 4:
                    startActivity(new Intent(this, BubbleChartActivity.class));
                    break;
            }

        }


    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
