package com.example.fernando.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Fernando on 21/01/2018.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    //contrutor
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentMainAdapter fragmentMainAdapter = new FragmentMainAdapter();
                return fragmentMainAdapter;
            case 1:
                FragmentMainAdapter fragmentMainAdapter2 = new FragmentMainAdapter();
                return fragmentMainAdapter2;
            case 2:
                FragmentMainAdapter fragmentMainAdapter3 = new FragmentMainAdapter();
                return fragmentMainAdapter3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // mostra 3 paginas
        return 3;
    }
}
