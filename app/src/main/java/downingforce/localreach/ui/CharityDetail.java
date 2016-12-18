package downingforce.localreach.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import downingforce.localreach.R;
import downingforce.localreach.adapters.CharityPagerAdapter;
import downingforce.localreach.models.Charity;

public class CharityDetail extends AppCompatActivity {
    @Bind(R.id.viewPager)
    ViewPager mViewPager;
    private CharityPagerAdapter adapterViewPager;
    ArrayList<Charity> mCharities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity_detail);
        ButterKnife.bind(this);

        mCharities = Parcels.unwrap(getIntent().getParcelableExtra("charities"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new CharityPagerAdapter(getSupportFragmentManager(), mCharities);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}