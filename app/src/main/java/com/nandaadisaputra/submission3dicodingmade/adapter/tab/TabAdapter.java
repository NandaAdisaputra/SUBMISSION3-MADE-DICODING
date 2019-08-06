package com.nandaadisaputra.submission3dicodingmade.adapter.tab;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.nandaadisaputra.submission3dicodingmade.fragment.fragment.MovieFragment;
import com.nandaadisaputra.submission3dicodingmade.fragment.fragment.TvFragment;


public class TabAdapter extends FragmentPagerAdapter {

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new MovieFragment();
        }
        return new TvFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "Movie";
        }
        return "Tv Show";
    }

    @Override
    public int getCount() {
        return 2;
    }

}
