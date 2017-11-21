package com.mmr.meza.flooddemo.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mmr.meza.flooddemo.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.listener.ColumnChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.ColumnChartView;
import lecho.lib.hellocharts.view.LineChartView;

public class LineColumnDependencyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_column_dependency);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        public final static String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec",};

        public final static String[] days = new String[]{"Day 1"," 4", " 8", " 16", " 21", " 25", " 30" };

        private LineChartView chartTop;
        private ColumnChartView chartBottom;

        private LineChartData lineData;
        private ColumnChartData columnData;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_line_column_dependency, container, false);

            // *** TOP LINE CHART ***
            chartTop = (LineChartView) rootView.findViewById(R.id.chart_top);

            // Generate and set data for line chart
            generateInitialLineData();

            // *** BOTTOM COLUMN CHART ***

            chartBottom = (ColumnChartView) rootView.findViewById(R.id.chart_bottom);

            generateColumnData();

            return rootView;
        }

        private void generateColumnData() {

            int numSubcolumns = 1;
            int numColumns = months.length;

            List<AxisValue> axisValues = new ArrayList<AxisValue>();
            List<Column> columns = new ArrayList<Column>();
            List<SubcolumnValue> values;
            for (int i = 0; i < numColumns; ++i) {

                values = new ArrayList<SubcolumnValue>();
                for (int j = 0; j < numSubcolumns; ++j) {

                    if (i==6 ){
                        values.add(new SubcolumnValue((float) 90, ChartUtils.COLOR_RED));

                    }
                    else if ( i==5){
                        values.add(new SubcolumnValue((float) 80, ChartUtils.COLOR_RED));
                    }
                    else if ( i==7){
                        values.add(new SubcolumnValue((float) 70, ChartUtils.COLOR_RED));
                    }
                    else if ( i==3){
                        values.add(new SubcolumnValue((float) 50, ChartUtils.COLOR_ORANGE));
                    }
                    else if ( i==4){
                        values.add(new SubcolumnValue((float) 45, ChartUtils.COLOR_ORANGE));
                    }

                    else {
                        values.add(new SubcolumnValue((float) (Math.random() *50+ 5)%40, Color.parseColor("#FF96ED24")));

                    }
                }

                axisValues.add(new AxisValue(i).setLabel(months[i]));

                columns.add(new Column(values).setHasLabelsOnlyForSelected(true));
            }

            columnData = new ColumnChartData(columns);

            columnData.setAxisXBottom(new Axis(axisValues).setHasLines(true));
            columnData.setAxisYLeft(new Axis().setHasLines(true).setMaxLabelChars(2));

            chartBottom.setColumnChartData(columnData);

            // Set value touch listener that will trigger changes for chartTop.
            chartBottom.setOnValueTouchListener(new ValueTouchListener());

            // Set selection mode to keep selected month column highlighted.
            chartBottom.setValueSelectionEnabled(true);

            chartBottom.setZoomType(ZoomType.HORIZONTAL);

            // chartBottom.setOnClickListener(new View.OnClickListener() {
            //
            // @Override
            // public void onClick(View v) {
            // SelectedValue sv = chartBottom.getSelectedValue();
            // if (!sv.isSet()) {
            // generateInitialLineData();
            // }
            //
            // }
            // });

        }

        /**
         * Generates initial data for line chart. At the begining all Y values are equals 0. That will change when user
         * will select value on column chart.
         */
        private void generateInitialLineData() {
            int numValues = 7;

            List<AxisValue> axisValues = new ArrayList<AxisValue>();
            List<PointValue> values = new ArrayList<PointValue>();
            for (int i = 0; i < numValues; ++i) {
                values.add(new PointValue(i, 0));
                axisValues.add(new AxisValue(i).setLabel(days[i]));
            }

            Line line = new Line(values);
            line.setColor(ChartUtils.COLOR_GREEN).setCubic(true);

            List<Line> lines = new ArrayList<Line>();
            lines.add(line);

            lineData = new LineChartData(lines);
            lineData.setAxisXBottom(new Axis(axisValues).setHasLines(true));
            lineData.setAxisYLeft(new Axis().setHasLines(true).setMaxLabelChars(3));

            chartTop.setLineChartData(lineData);

            // For build-up animation you have to disable viewport recalculation.
            chartTop.setViewportCalculationEnabled(false);

            // And set initial max viewport and current viewport- remember to set viewports after data.
            Viewport v = new Viewport(0, 110, 6, 0);
            chartTop.setMaximumViewport(v);
            chartTop.setCurrentViewport(v);

            chartTop.setZoomType(ZoomType.HORIZONTAL);
        }

        private void generateLineData(int color, float range , int columnIndex) {
            // Cancel last animation if not finished.
            chartTop.cancelDataAnimation();

            // Modify data targets
            Line line = lineData.getLines().get(0);// For this example there is always only one line.
            line.setColor(color);
            int i = 10;
            for (PointValue value : line.getValues()) {
                // Change target only for Y value.

                if (columnIndex==6){
                    /*value.setTarget(value.getX(), (float) i++ );
                    Log.e("VAlue" , i+"");*/
                    value.setTarget(value.getX(), (float) Math.random() *60+20);


                }
                else if (columnIndex==7){
                    value.setTarget(value.getX(), (float) Math.random() *80+20);
                }
                else {
                    value.setTarget(value.getX(), (float)( Math.random() * range)%50);

                }
            }

            // Start new data animation with 300ms duration;
            chartTop.startDataAnimation(300);
        }

        private class ValueTouchListener implements ColumnChartOnValueSelectListener {
            int v;
            @Override
            public void onValueSelected(int columnIndex, int subcolumnIndex, SubcolumnValue value) {
                generateLineData(value.getColor(), 150 ,columnIndex);
                v=columnIndex;
            }

            @Override
            public void onValueDeselected() {

                generateLineData(ChartUtils.COLOR_GREEN, 0 ,v);

            }
        }
    }
}
