package com.example.tabtest;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.example.tabtest.custom.SampleAdapter;
import com.example.tabtest.custom.VerticalViewpager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.tabtest.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SampleAdapter adapter = new SampleAdapter(this);

        final VerticalViewpager verticalViewpager = findViewById(R.id.view_pager_test);
        verticalViewpager.setAdapter(adapter);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                verticalViewpager.setCurrentItem(1);
            }
        },2000);
        verticalViewpager.setOnClickListener(null);
        verticalViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(position < adapter.getCount() - 1){
                            verticalViewpager.setCurrentItem(position+1);
                        }else{
                            verticalViewpager.setCurrentItem(0);
                        }
                    }
                },2000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setTabTextColors(Color.parseColor("#ffffff"), Color.parseColor("#000000"));
        tabs.setupWithViewPager(viewPager);

        Spinner spinner = findViewById(R.id.spinner);
        arrayList.add("슬기1");
        arrayList.add("슬기2");
        arrayList.add("슬기3");
        arrayList.add("슬기4");
        arrayList.add("슬기5");
        arrayList.add("슬기6");
        arrayList.add("슬기7");

        spinner.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,arrayList));
    }
}