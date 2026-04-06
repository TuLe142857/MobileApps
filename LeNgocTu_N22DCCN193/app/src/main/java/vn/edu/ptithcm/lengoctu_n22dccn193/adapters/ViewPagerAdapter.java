package vn.edu.ptithcm.lengoctu_n22dccn193.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import vn.edu.ptithcm.lengoctu_n22dccn193.fragments.BookGridFragment;
import vn.edu.ptithcm.lengoctu_n22dccn193.fragments.CartFragment;
import vn.edu.ptithcm.lengoctu_n22dccn193.fragments.ProfileFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new BookGridFragment();
        }else if(position == 1){
            return new CartFragment();
        }else{
            return new ProfileFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
