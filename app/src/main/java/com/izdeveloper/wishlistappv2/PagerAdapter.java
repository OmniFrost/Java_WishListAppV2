package com.izdeveloper.wishlistappv2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.izdeveloper.wishlistappv2.allFragments.addPage;
import com.izdeveloper.wishlistappv2.allFragments.listPage;

public class PagerAdapter extends FragmentStateAdapter {
    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new addPage();
            default:
                return new listPage();
        }
    }


    @Override
    public int getItemCount() {
        return 2;
    }
}
