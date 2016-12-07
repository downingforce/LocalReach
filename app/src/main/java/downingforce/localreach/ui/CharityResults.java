package downingforce.localreach.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import downingforce.localreach.R;
import downingforce.localreach.adapters.CharityListAdapter;
import downingforce.localreach.services.GuideStarService;
import downingforce.localreach.models.Charity;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Response;
import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;

public class CharityResults extends AppCompatActivity {

    public ArrayList<Charity> mCharities = new ArrayList<>();
    public static final String TAG = CharityResults.class.getSimpleName();

    @Bind(R.id.resultsLabel) TextView mResultsLabel;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private CharityListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity_results);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mResultsLabel.setText("Charities for: " + location);

        getCharities(location);

        mResultsLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CharityResults.this, "Your Neighborhood", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getCharities(String location) {
        final GuideStarService guideStarService = new GuideStarService();
        guideStarService.findCharities(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mCharities= guideStarService.processResults(response);

                CharityResults.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new CharityListAdapter(getApplicationContext(), mCharities);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(CharityResults.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
