package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    BarChart barChart;
    private List<String> xDays = Arrays.asList("일","월","화","수","목","금","토");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ChartSetting();


    }

    private void ChartSetting()
    {

        barChart=findViewById(R.id.barchart);//차트가 들어갈 뷰(barchart)
        BarDataSet barDataSet = new BarDataSet(dataSet(),"7Days");//차트에 데이터 가져오기, 데이터 이름: Dataset 1

        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS); // 차트 바 색 지정
        barDataSet.setValueTextColor(Color.BLACK);// 폰트 색
        barDataSet.setValueTextSize(12f);// 차트 폰트 사이즈
        BarData barData =new BarData(barDataSet); //차트 바 생성

        barChart.setData(barData); // 차트 뷰에 데이터 삽입


        barChart.setFitBars(true);//차트 세로줄 중앙 설정
        //barChart.setDrawGridBackground(true);//차트 테두리 설정
        barChart.getDescription().setText(""); //차드 안 이름 설정
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);//x축 레이블 위치 설정
        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(xDays));

        barChart.getAxisLeft().setDrawAxisLine(false);//왼쪽 라인 삭제
        barChart.getAxisLeft().setAxisMinimum(0f);//최소
        barChart.getAxisLeft().setAxisMaximum(101f);//최대
        //barChart.getAxisLeft().setAxisLineWidth(2f);
        barChart.getAxisLeft().setGranularity(20f);//단위
        barChart.getAxisLeft().setLabelCount(10);

        barChart.getAxisRight().setDrawAxisLine(false);//오른쪽 라인 삭제
        barChart.getAxisRight().setDrawLabels(false);//오른쪽 레이블 그리기 삭제

        barChart.animateY(1500);//차트 바 애니메이션
        barChart.setTouchEnabled(false);//차트 터치 끄기
        barChart.invalidate();

    }




    //차트에 들어갈 데이터
    private ArrayList<BarEntry> dataSet() {

        ArrayList<BarEntry> entries=new ArrayList<>();

        // data set
        entries.add(new BarEntry(0, 40f));
        entries.add(new BarEntry(1, 20f));
        entries.add(new BarEntry(2, 30f));
        entries.add(new BarEntry(3, 10f));
        entries.add(new BarEntry(4, 50f));
        entries.add(new BarEntry(5, 70f));
        entries.add(new BarEntry(6, 60f));

        return entries;

    }




}


