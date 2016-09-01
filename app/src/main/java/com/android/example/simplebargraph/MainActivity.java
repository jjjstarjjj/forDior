package com.android.example.simplebargraph;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.AxisValueFormatter;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barChart = (BarChart) findViewById(R.id.bargraph);
//y축 데이터 불러오기 list 사용
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 11f));
        entries.add(new BarEntry(1f, 1f));
        entries.add(new BarEntry(2f, 2f));
        entries.add(new BarEntry(3f, 3f));
        entries.add(new BarEntry(4f, 4f));
        entries.add(new BarEntry(5f, 6f));
        entries.add(new BarEntry(6f, 3f));


        BarDataSet Bardataset = new BarDataSet(entries,"BarDataSet");

        BarData data = new BarData(Bardataset);
        barChart.setData(data);

        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        data.setBarWidth(0.85f);

        barChart.setFitBars(true);
        barChart.setTouchEnabled(false);
        barChart.setDragEnabled(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setDrawBarShadow(false);

//x축 변수 설정 및 세팅
        String[] values = new String[]{
                "일요일","월요일","화요일","수요일","목요일","금요일","토요일"
        };
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValueFormatter(values));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(22f);

        YAxis right = barChart.getAxisRight();
        right.setDrawLabels(false);

        YAxis left = barChart.getAxisLeft();
        left.setTextSize(18f);

    }
    //x축 설정하기위한 함수
    public class MyXAxisValueFormatter implements AxisValueFormatter {

        private String[] mValues;

        public MyXAxisValueFormatter(String[] values) {
            this.mValues = values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            // "value" represents the position of the label on the axis (x or y)
            return mValues[(int) value];
        }

        /** this is only needed if numbers are returned, else return 0 */
        @Override
        public int getDecimalDigits() { return 0; }
    }
}
