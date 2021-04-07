package com.tugas5.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> arralistFragment;
    ArrayList<String> arrayListjudul;

    public MyViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> arralistFragment, ArrayList<String> arrayListjudul) {
        super (fm);
        this.arralistFragment = arralistFragment;
        this.arrayListjudul = arrayListjudul;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arralistFragment.get(position);
    }

    @Override
    public int getCount() {
        return arralistFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrayListjudul.get(position);
    }
}