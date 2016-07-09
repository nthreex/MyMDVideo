package com.studyjams.mdvideo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.studyjams.mdvideo.Fragment.HistoryFragment;
import com.studyjams.mdvideo.Fragment.LocalVideoListFragment;
import com.studyjams.mdvideo.Fragment.VideoListFragment;

import java.util.List;

/**
 * Created by syamiadmin on 2016/7/6.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private List<String> mData;
    public MainPagerAdapter(FragmentManager fm, List<String> list) {
        super(fm);
        mData = list;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return VideoListFragment.newInstance(mData.get(position));
            case 3:
                return LocalVideoListFragment.newInstance(mData.get(position));
            default:
                return HistoryFragment.newInstance(mData.get(position));
        }

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mData.get(position);
    }
}
