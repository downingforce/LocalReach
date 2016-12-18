package downingforce.localreach.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import downingforce.localreach.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LandingScreenActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.searchButton) Button mSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //click listener on button to take user to MainActivity
        mSearchButton.setOnClickListener(this);
    }

    @Override
    public void onClick (View v){
        Intent intent = new Intent(LandingScreenActivity.this, MainActivity.class);
        startActivity(intent);
    }
}

