package iteso.com.rentstudio;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Activity_Main_Screen extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    public Fragment_Main fragment_main;
    public Fragment_Lessors fragment_lessors;
    public Fragment_Properties fragment_properties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__main__screen);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(1);

        tabLayout.setupWithViewPager(mViewPager);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if(fragment_properties == null){
                        return new Fragment_Properties();
                    }
                    return fragment_properties;
                case 1:
                    if(fragment_main == null){
                        return new Fragment_Main();
                    }
                    return fragment_main;
                case 2:
                    if(fragment_lessors == null){
                        return new Fragment_Lessors();
                    }
                    return fragment_lessors;
                default:
                    return new Fragment_Main();
            }
        };

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return "Propiedades";
                case 1: return "Home";
                case 2: return "Arrendadores";
            }
            return null;
        }
    }
}
