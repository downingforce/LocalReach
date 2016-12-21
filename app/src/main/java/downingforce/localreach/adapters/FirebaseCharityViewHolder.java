package downingforce.localreach.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import downingforce.localreach.Constants;
import downingforce.localreach.R;
import downingforce.localreach.models.Charity;
import downingforce.localreach.ui.CharityDetail;

public class FirebaseCharityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;

    public FirebaseCharityViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindCharity(Charity charity) {
        ImageView charityImageView = (ImageView) mView.findViewById(R.id.charityImageView);
        TextView charityNameTextView = (TextView) mView.findViewById(R.id.charityNameTextView);
        TextView missionStatementTextView = (TextView) mView.findViewById(R.id.missionStatementTextView);

        Picasso.with(mContext)
                .load(charity.getmLogo())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(charityImageView);


        charityNameTextView.setText(charity.getmName());
        missionStatementTextView.setText(charity.getmMission());

    }

    @Override
    public void onClick(View view) {
        final ArrayList<Charity> charities = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_CHARITIES);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    charities.add(snapshot.getValue(Charity.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, CharityDetail.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("charities", Parcels.wrap(charities));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
