//Opin käyttämään StringBuilder-luokkaa osoitteessa https://www.javatpoint.com/StringBuilder-class

package com.izdeveloper.wishlistappv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.izdeveloper.wishlistappv2.allFragments.addPage;
import com.izdeveloper.wishlistappv2.allFragments.importancePage;
import com.izdeveloper.wishlistappv2.allFragments.listPage;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dispthruFragment();
        TabLayout tabSpace = findViewById(R.id.tabArea);
        ViewPager2 fragmentSpace = findViewById(R.id.fragmentArea);

        PagerAdapter tabAdapter = new PagerAdapter(this);
        fragmentSpace.setAdapter(tabAdapter);

        tabSpace.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentSpace.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentContainer, new listPage())
                                .commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentContainer, new addPage())
                                .commit();
                        break;
                }
                dispthruFragment();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new listPage())
                .commit();

        fragmentSpace.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                super.onPageSelected(position);
                tabSpace.getTabAt(position).select();
            }
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.importanceContainer, new importancePage())
                .commit();

    }

    public void dispthruFragment() {
        importancePage fragment = (importancePage) getSupportFragmentManager().findFragmentById(R.id.importanceContainer);
        if (fragment != null) {

            ArrayList<Article> starred = Storage.getSingle().getStars();
            ArrayList<String> nStarred = new ArrayList<>();

            for (Article i : starred) {

                nStarred.add(i.getItemName());
            }
            fragment.printImpArt(nStarred);
        }
    }
}
