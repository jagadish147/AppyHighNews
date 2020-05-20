package com.happy.high.news.ui.news;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.happy.high.news.ui.news.business.BusinessFragment;
import com.happy.high.news.ui.news.technology.TechnologyFragment;

/**
 * Created by Jagadish on 19/05/2020.
 */

public class NewsPagerAdapter extends FragmentStatePagerAdapter {

    private int mTabCount;

    public NewsPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mTabCount = 0;
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        mTabCount = count;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return BusinessFragment.newInstance();
            case 1:
                return TechnologyFragment.newInstance();
            default:
                return null;
        }
    }
}
