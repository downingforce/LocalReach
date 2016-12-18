package downingforce.localreach.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import downingforce.localreach.R;
import downingforce.localreach.models.Charity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharityDetailFragment extends Fragment {
    @Bind(R.id.charityImageView) ImageView mImageLabel;
    @Bind(R.id.charityNameTextView) TextView mNameLabel;
    @Bind(R.id.nteeTextView) TextView mCategoriesLabel;
    @Bind(R.id.statementTextView) TextView mStatementLabel;
    @Bind(R.id.websiteTextView) TextView mWebsiteLabel;
    @Bind(R.id.addressTextView) TextView mAddressLabel;
    @Bind(R.id.saveCharityButton) TextView mSaveCharityButton;

    private Charity mCharity;


    public CharityDetailFragment newInstance(Charity charity) {
        CharityDetailFragment charityDetailFragment = new CharityDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("charity", Parcels.wrap(charity));
        charityDetailFragment.setArguments(args);
        return charityDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCharity = Parcels.unwrap(getArguments().getParcelable("charity"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_charity_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mCharity.getmLogo()).into(mImageLabel);

        mNameLabel.setText(mCharity.getmName());
        mCategoriesLabel.setText(mCharity.getmNteecode());
        mStatementLabel.setText(mCharity.getmMission());
        mWebsiteLabel.setText(mCharity.getmWebsite());
        mAddressLabel.setText(mCharity.getmCity());

        return view;
    }

}
