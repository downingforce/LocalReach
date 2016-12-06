package downingforce.localreach;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    @Bind(R.id.charityList) ListView mCharityListView;

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
                        String[] charityNames = new String[mCharities.size()];
                        for (int i = 0; i < charityNames.length; i++) {
                            charityNames[i] = mCharities.get(i).getmName();
                        }


                        ArrayAdapter adapter = new ArrayAdapter(CharityResults.this,
                                android.R.layout.simple_list_item_1, charityNames);
                        mCharityListView.setAdapter(adapter);
                    }
                });
            }
        });
    }
}
