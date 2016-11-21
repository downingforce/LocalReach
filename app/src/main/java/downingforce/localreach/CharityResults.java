package downingforce.localreach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CharityResults extends AppCompatActivity {
    @Bind(R.id.resultsLabel) TextView mResultsLabel;
    @Bind(R.id.charityList) ListView mCharityListView;
    private String[] charitiesTestArray = new String[] {"Red Cross", "Habitat for Humanity", "Charity Water", "United Way", "PBS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity_results);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, charitiesTestArray);
        mCharityListView.setAdapter(adapter);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mResultsLabel.setText("Charities for: " + location);
    }
}
