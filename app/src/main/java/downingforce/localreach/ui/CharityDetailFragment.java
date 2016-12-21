package downingforce.localreach.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import downingforce.localreach.Constants;
import downingforce.localreach.R;
import downingforce.localreach.models.Charity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharityDetailFragment extends Fragment implements View.OnClickListener{
    @Bind(R.id.charityImageView) ImageView mImageLabel;
    @Bind(R.id.charityNameTextView) TextView mNameLabel;
    @Bind(R.id.nteeTextView) TextView mCategoriesLabel;
    @Bind(R.id.statementTextView) TextView mStatementLabel;
    @Bind(R.id.websiteTextView) TextView mWebsiteLabel;
    @Bind(R.id.addressTextView) TextView mAddressLabel;
    @Bind(R.id.saveCharityButton) TextView mSaveCharityButton;

    private Charity mCharity;
    private ArrayList<Charity> mCharities;
    private int mPosition;


    public static CharityDetailFragment newInstance(ArrayList<Charity> charities, Integer position) {
        CharityDetailFragment charityDetailFragment = new CharityDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(Constants.EXTRA_KEY_CHARITIES, Parcels.wrap(charities));
        args.putInt(Constants.EXTRA_KEY_POSITION, position);

        charityDetailFragment.setArguments(args);
        return charityDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCharities = Parcels.unwrap(getArguments().getParcelable(Constants.EXTRA_KEY_CHARITIES));
        mPosition = getArguments().getInt(Constants.EXTRA_KEY_POSITION);
        mCharity = mCharities.get(mPosition);
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

        mWebsiteLabel.setOnClickListener(this);
        mSaveCharityButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mCharity.getmWebsite()));
            startActivity(webIntent);
        }
        if (v == mSaveCharityButton) {
            DatabaseReference restaurantRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_CHARITIES);
            restaurantRef.push().setValue(mCharity);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }

}