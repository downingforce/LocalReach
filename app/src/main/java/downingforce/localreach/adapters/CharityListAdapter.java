package downingforce.localreach.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import downingforce.localreach.R;
import downingforce.localreach.models.Charity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

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

    public class CharityViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.charityImageView) ImageView mCharityImageView;
        @Bind(R.id.charityNameTextView) TextView mCharityNameTextView;
        @Bind(R.id.missionStatementTextView) TextView mMissionStatementTextView;
        private Context mContext;


        public CharityViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindCharity(Charity charity) {
            mCharityNameTextView.setText(charity.getmName());
            mMissionStatementTextView.setText(charity.getmMission());
        }
    }
}
