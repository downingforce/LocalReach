package downingforce.localreach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.seachCharitiesButton)
    Button mSearchCharitiesButton;
    @Bind(R.id.zipCode)
    EditText mZipCodeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //click listener on button to pass user entered zipcode to CharityResults activity
        mSearchCharitiesButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSearchCharitiesButton) {
            String location = mZipCodeEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, CharityResults.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }
}