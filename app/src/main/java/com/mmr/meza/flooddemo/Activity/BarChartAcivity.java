package com.mmr.meza.flooddemo.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mmr.meza.flooddemo.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.formatter.ColumnChartValueFormatter;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.view.ColumnChartView;

public class BarChartAcivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchart_acivity);


        ColumnChartView chartView = (ColumnChartView) findViewById(R.id.lineChart);


        List<SubcolumnValue> pointValues = new ArrayList<>();

        SubcolumnValue subcolumnValue = new SubcolumnValue();
        subcolumnValue.setLabel("myLabel");
        subcolumnValue.setValue(5);
        subcolumnValue.setColor(Color.DKGRAY);
        subcolumnValue.setTarget(15);
        pointValues.add(subcolumnValue);
        pointValues.add(new SubcolumnValue(10, Color.RED));
        pointValues.add(new SubcolumnValue(7, Color.YELLOW));
        pointValues.add(new SubcolumnValue(5, Color.GREEN));
        pointValues.add(new SubcolumnValue(9, Color.RED));
        pointValues.add(new SubcolumnValue(10, Color.RED));
        pointValues.add(new SubcolumnValue(7, Color.YELLOW));
        pointValues.add(new SubcolumnValue(5, Color.GREEN));
        pointValues.add(new SubcolumnValue(9, Color.RED));
        pointValues.add(new SubcolumnValue(10, Color.RED));
        pointValues.add(new SubcolumnValue(7, Color.YELLOW));
        pointValues.add(new SubcolumnValue(5, Color.GREEN));
        pointValues.add(new SubcolumnValue(9, Color.RED));
        pointValues.add(new SubcolumnValue(10, Color.RED));
        pointValues.add(new SubcolumnValue(7, Color.YELLOW));
        pointValues.add(new SubcolumnValue(5, Color.GREEN));
        pointValues.add(new SubcolumnValue(9, Color.RED));


        Column column = new Column(pointValues);

        List<Column> columns = new ArrayList<Column>();

        columns.add(column);
        ColumnChartData columnChartData = new ColumnChartData();

        columnChartData.setColumns(columns);

        chartView.setColumnChartData(columnChartData);
    }
}
