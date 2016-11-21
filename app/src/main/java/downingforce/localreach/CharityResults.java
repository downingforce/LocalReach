package downingforce.localreach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CharityResults extends AppCompatActivity {
    private TextView mResultsLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity_results);

        mResultsLabel = (TextView) findViewById(R.id.resultsLabel);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mResultsLabel.setText("Charities for: " + location);
    }
}
