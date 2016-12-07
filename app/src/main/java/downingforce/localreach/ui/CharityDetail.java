package downingforce.localreach.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import downingforce.localreach.R;

public class CharityDetail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity_detail);

        TextView charity = (TextView) findViewById(R.id.charity_label);

        // getting attached intent data and displaying selected charity
        Intent i = getIntent();
        String charityName = i.getStringExtra("charityName");
        charity.setText(charityName);

    }
}
