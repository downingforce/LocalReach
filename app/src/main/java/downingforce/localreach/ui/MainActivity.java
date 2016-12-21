package downingforce.localreach.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import downingforce.localreach.Constants;
import downingforce.localreach.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.seachCharitiesButton) Button mSearchCharitiesButton;
    @Bind(R.id.zipCode) EditText mZipCodeEditText;
    @Bind(R.id.myCharitiesButton) Button mMyCharitiesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSearchCharitiesButton.setOnClickListener(this);
        mMyCharitiesButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSearchCharitiesButton) {
            Intent intent = new Intent(MainActivity.this, CharityResults.class);
            startActivity(intent);
        }
        if (v == mMyCharitiesButton) {
            Intent intent = new Intent(MainActivity.this, SavedCharityList.class);
            startActivity(intent);
        }
    }
}

