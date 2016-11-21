package downingforce.localreach;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CharityDetail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity_detail);

        TextView charity = (TextView) findViewById(R.id.charity_label);

        Intent i = getIntent();
        // getting attached intent data
        String charityName = i.getStringExtra("charityName");
        // displaying selected product name
        charity.setText(charityName);

    }
}
