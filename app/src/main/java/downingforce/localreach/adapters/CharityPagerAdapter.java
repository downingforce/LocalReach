package downingforce.localreach.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import downingforce.localreach.models.Charity;
import downingforce.localreach.ui.CharityDetailFragment;


public class CharityPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Charity> mCharities;

    public CharityPagerAdapter(FragmentManager fm, ArrayList<Charity> charities) {
        super(fm);
        mCharities = charities;
    }

    @Override
    public Fragment getItem(int position) {
        return CharityDetailFragment.newInstance(mCharities.get(position));
    }

    @Override
    public int getCount() {
        return mCharities.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mCharities.get(position).getmName();
    }
}