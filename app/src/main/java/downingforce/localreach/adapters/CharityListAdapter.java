package downingforce.localreach.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import downingforce.localreach.Constants;
import downingforce.localreach.R;
import downingforce.localreach.models.Charity;
import downingforce.localreach.ui.CharityDetail;

public class CharityListAdapter extends RecyclerView.Adapter<CharityListAdapter.CharityViewHolder> {
    private ArrayList<Charity> mCharities = new ArrayList<>();
    private Context mContext;


    public CharityListAdapter(Context context, ArrayList<Charity> charities) {
        mContext = context;
        mCharities = charities;
    }

    @Override
    public CharityListAdapter.CharityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.charity_list_item, parent, false);
        CharityViewHolder viewHolder = new CharityViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CharityListAdapter.CharityViewHolder holder, int position) {
        holder.bindCharity(mCharities.get(position));
    }

    @Override
    public int getItemCount() {
        return mCharities.size();
    }

    public class CharityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @Bind(R.id.charityImageView) ImageView mCharityImageView;
        @Bind(R.id.charityNameTextView) TextView mCharityNameTextView;
        @Bind(R.id.missionStatementTextView) TextView mMissionStatementTextView;
        private Context mContext;

        public CharityViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();

            Animation slide = AnimationUtils.loadAnimation(mContext, R.anim.slide);
            itemView.startAnimation(slide);;
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int itemPosition = getLayoutPosition();
                    Intent intent = new Intent(mContext, CharityDetail.class);
                    intent.putExtra("position", itemPosition);
                    intent.putExtra("charities", Parcels.wrap(mCharities));
                    mContext.startActivity(intent);
                }
            });
        }

        public void bindCharity(final Charity charity) {
            Picasso.with(mContext).load(charity.getmLogo()).into(mCharityImageView);
            mCharityNameTextView.setText(charity.getmName());
            mMissionStatementTextView.setText(charity.getmMission());
        }

        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, CharityDetail.class);
            intent.putExtra(Constants.EXTRA_KEY_POSITION, itemPosition);
            intent.putExtra(Constants.EXTRA_KEY_CHARITIES, Parcels.wrap(mCharities));
            mContext.startActivity(intent);
        }
    }
}