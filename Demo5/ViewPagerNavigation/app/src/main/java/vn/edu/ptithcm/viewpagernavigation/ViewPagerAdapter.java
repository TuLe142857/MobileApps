package vn.edu.ptithcm.viewpagernavigation;

import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new FirstFragment();
        if (position == 1)
            return new SecondFragment();
        return new ThirdFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
