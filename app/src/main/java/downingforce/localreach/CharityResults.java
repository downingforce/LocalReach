package downingforce.localreach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CharityResults extends AppCompatActivity {
    private TextView mResultsLabel;
    private String[] charitiesTestArray = new String[] {"Red Cross", "Habitat for Humanity", "Charity Water", "United Way", "PBS"};
    private ListView mCharityListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity_results);

        mCharityListView = (ListView) findViewById(R.id.charityList);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, charitiesTestArray);
        mCharityListView.setAdapter(adapter);
        mResultsLabel = (TextView) findViewById(R.id.resultsLabel);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mResultsLabel.setText("Charities for: " + location);
    }
}
