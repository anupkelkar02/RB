package com.example.mypc.reshimbandh.Others;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypc.reshimbandh.Fragments.InterestRecFragment;
import com.example.mypc.reshimbandh.Fragments.InterestSentFragment;
import com.example.mypc.reshimbandh.Fragments.MatchesFragment;
import com.example.mypc.reshimbandh.Fragments.NewMatchesFragment;
import com.example.mypc.reshimbandh.Fragments.ShortListedFragment;
import com.example.mypc.reshimbandh.R;

/**
 * Created by my pc on 19-11-2016.
 */

public class InterestTabFragment extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 4 ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        View x =  inflater.inflate(R.layout.tab_layout,null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return x;

    }
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new InterestSentFragment();
                case 1 : return new InterestRecFragment();
                case 2 : return new ShortListedFragment();
                case 3 : return new ShortListedFragment();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "ALL";
                case 1 :
                    return "LINK";
                case 2 :
                    return "RESPONSE NOT GIVEN";
                case 3:
                    return "NOT SUITABLE";
            }
            return null;
        }
    }

}
