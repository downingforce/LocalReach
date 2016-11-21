package downingforce.localreach;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CharityResults extends ListActivity {
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

        //listener to eventually display each charity onClick

        ListView listViewItem = getListView();
        
        listViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String charityName = ((TextView) view).getText().toString();
                Intent newIntent = new Intent(getApplicationContext(), CharityDetail.class);
                newIntent.putExtra("charityName", charityName);
                startActivity(newIntent);
            }
        });
    }
}
