package com.arf.fragmenttablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabsLayout tabsLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabsLayout  =   findViewById(R.id.tabLayout);
        viewPager   =   findViewById(R.id.viewPager);

        ArrayList<Fragmnet> fragmnets = new ArrayList<>();
        fragmnets.add(new ChatFragment());
        fragmnets.add(new StatusFragment());
        fragmnets.add(new CallFragment());

        ArrayList<String> judulFragmnet = new MyViewPagerAdapter(getSupportFragmentManager(), Fragment, judulFragment);

    }
}