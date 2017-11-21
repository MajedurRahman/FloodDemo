package com.mmr.meza.flooddemo.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.mmr.meza.flooddemo.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.listener.BubbleChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.BubbleChartData;
import lecho.lib.hellocharts.model.BubbleValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.BubbleChartView;
import lecho.lib.hellocharts.view.Chart;

public class BubbleChartActivity extends ActionBarActivity {

    private static BubbleValue value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_chart);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }
    }

    /**
     * A fragment containing a bubble chart.
     */
    public static class PlaceholderFragment extends Fragment {

        private static final int BUBBLES_NUM = 12;

        private BubbleChartView chart;
        private BubbleChartData data;
        private boolean hasAxes = true;
        private boolean hasAxesNames = false;
        private ValueShape shape = ValueShape.CIRCLE;
        private boolean hasLabels = true;
        private boolean hasLabelForSelected = false;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            setHasOptionsMenu(true);
            View rootView = inflater.inflate(R.layout.fragment_bubble_chart, container, false);

            chart = (BubbleChartView) rootView.findViewById(R.id.chart);
            chart.setOnValueTouchListener(new ValueTouchListener());

            generateData();

            return rootView;
        }

        @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
            inflater.inflate(R.menu.bubble_chart, menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.action_reset) {
                reset();
                generateData();
                return true;
            }
            if (id == R.id.action_shape_circles) {
                setCircles();
                return true;
            }
            if (id == R.id.action_shape_square) {
                setSquares();
                return true;
            }
            if (id == R.id.action_toggle_labels) {
                toggleLabels();
                return true;
            }
            if (id == R.id.action_toggle_axes) {
                toggleAxes();
                return true;
            }
            if (id == R.id.action_toggle_axes_names) {
                toggleAxesNames();
                return true;
            }
            if (id == R.id.action_animate) {
                prepareDataAnimation();
                chart.startDataAnimation();
                return true;
            }
            if (id == R.id.action_toggle_selection_mode) {
                toggleLabelForSelected();
                Toast.makeText(getActivity(),
                        "Selection mode set to " + chart.isValueSelectionEnabled() + " select any point.",
                        Toast.LENGTH_SHORT).show();
                return true;
            }
            if (id == R.id.action_toggle_touch_zoom) {
                chart.setZoomEnabled(!chart.isZoomEnabled());
                Toast.makeText(getActivity(), "IsZoomEnabled " + chart.isZoomEnabled(), Toast.LENGTH_SHORT).show();
                return true;
            }
            if (id == R.id.action_zoom_both) {
                chart.setZoomType(ZoomType.HORIZONTAL_AND_VERTICAL);
                return true;
            }
            if (id == R.id.action_zoom_horizontal) {
                chart.setZoomType(ZoomType.HORIZONTAL);
                return true;
            }
            if (id == R.id.action_zoom_vertical) {
                chart.setZoomType(ZoomType.VERTICAL);
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

        private void reset() {
            hasAxes = true;
            hasAxesNames = true;
            shape = ValueShape.CIRCLE;
            hasLabels = false;
            hasLabelForSelected = false;

            chart.setValueSelectionEnabled(hasLabelForSelected);
        }

        private void generateData() {

            List<BubbleValue> values = new ArrayList<BubbleValue>();
            for (int i = 0; i < BUBBLES_NUM; ++i) {

                switch (i){
                    case 0:
                        value = new BubbleValue(i, 6 , 10);
                        value.setColor(ChartUtils.COLOR_GREEN);
                        value.setLabel("January");
                        break;
                    case 1:
                        value = new BubbleValue(i, 10 , 9);
                        value.setColor(ChartUtils.COLOR_GREEN);
                        value.setLabel("February");
                        break;
                    case 2:
                        value = new BubbleValue(i, 8,13);
                        value.setColor(ChartUtils.COLOR_GREEN);
                        value.setLabel("March");
                        break;
                    case 3:
                        value = new BubbleValue(i, 15,17);
                        value.setColor(ChartUtils.COLOR_ORANGE);
                        value.setLabel("April");
                        break;
                    case 4:
                        value = new BubbleValue(i, 12,18);
                        value.setColor(ChartUtils.COLOR_ORANGE);
                        value.setLabel("May");
                        break;
                    case 5:
                        value = new BubbleValue(i, 17,25);
                        value.setColor(ChartUtils.COLOR_RED);
                        value.setLabel("June");
                        break;
                    case 6:
                        value = new BubbleValue(i, 25,35);
                        value.setColor(ChartUtils.COLOR_RED);
                        value.setLabel("July");
                        break;
                    case 7:
                        value = new BubbleValue(i, 20,20);
                        value.setColor(ChartUtils.COLOR_RED);
                        value.setLabel("August");
                        break;
                    case 8:
                        value = new BubbleValue(i,13,13);
                        value.setColor(ChartUtils.COLOR_ORANGE);
                        value.setLabel("September");
                        break;
                    case 9:
                        value = new BubbleValue(i, 9 , 12);
                        value.setColor(ChartUtils.COLOR_GREEN);
                        value.setLabel("October");
                        break;
                    case 10:
                        value = new BubbleValue(i, 4,12);
                        value.setColor(ChartUtils.COLOR_GREEN);
                        value.setLabel("November");
                        break;
                    case 11:
                        value = new BubbleValue(i, 7,9);
                        value.setColor(ChartUtils.COLOR_GREEN);
                        value.setLabel("December");
                        break;

                }
                values.add(value);
                value.setShape(shape);
            }

            data = new BubbleChartData(values);
            data.setHasLabels(hasLabels);
            data.setHasLabelsOnlyForSelected(hasLabelForSelected);

            if (hasAxes) {
                Axis axisX = new Axis();
                Axis axisY = new Axis().setHasLines(true);
                if (hasAxesNames) {
                    axisX.setName("Axis X");
                    axisY.setName("Axis Y");
                }
                data.setAxisXBottom(axisX);
                data.setAxisYLeft(axisY);
            } else {
                data.setAxisXBottom(null);
                data.setAxisYLeft(null);
            }

            chart.setBubbleChartData(data);

        }

        private void setCircles() {
            shape = ValueShape.CIRCLE;
            generateData();
        }

        private void setSquares() {
            shape = ValueShape.SQUARE;
            generateData();
        }

        private void toggleLabels() {
            hasLabels = !hasLabels;

            if (hasLabels) {
                hasLabelForSelected = false;
                chart.setValueSelectionEnabled(hasLabelForSelected);
            }

            generateData();
        }

        private void toggleLabelForSelected() {
            hasLabelForSelected = !hasLabelForSelected;

            chart.setValueSelectionEnabled(hasLabelForSelected);

            if (hasLabelForSelected) {
                hasLabels = false;
            }

            generateData();
        }

        private void toggleAxes() {
            hasAxes = !hasAxes;

            generateData();
        }

        private void toggleAxesNames() {
            hasAxesNames = !hasAxesNames;

            generateData();
        }

        /**
         * To animate values you have to change targets values and then call {@link Chart#startDataAnimation()}
         * method(don't confuse with View.animate()).
         */
        private void prepareDataAnimation() {
            for (BubbleValue value : data.getValues()) {
                value.setTarget(value.getX() + (float) Math.random() * 4 * getSign(), (float) Math.random() * 100,
                        (float) Math.random() * 1000);
            }
        }

        private int getSign() {
            int[] sign = new int[]{-1, 1};
            return sign[Math.round((float) Math.random())];
        }

        private class ValueTouchListener implements BubbleChartOnValueSelectListener {

            @Override
            public void onValueSelected(int bubbleIndex, BubbleValue value) {

            }

            @Override
            public void onValueDeselected() {
                // TODO Auto-generated method stub

            }
        }
    }
}
