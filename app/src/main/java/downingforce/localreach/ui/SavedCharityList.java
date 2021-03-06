package downingforce.localreach.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;
import downingforce.localreach.Constants;
import downingforce.localreach.R;
import downingforce.localreach.adapters.FirebaseCharityViewHolder;
import downingforce.localreach.models.Charity;

public class SavedCharityList extends AppCompatActivity {
    private DatabaseReference mCharityReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_charity_results);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mCharityReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_CHARITIES)
                .child(uid);

        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Charity, FirebaseCharityViewHolder>
                (Charity.class, R.layout.charity_list_item, FirebaseCharityViewHolder.class, mCharityReference) {

            @Override
            protected void populateViewHolder(FirebaseCharityViewHolder viewHolder, Charity model, int position) {
                viewHolder.bindCharity(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}