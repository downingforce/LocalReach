package downingforce.localreach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.seachCharitiesButton) Button mSearchCharitiesButton;
    @Bind(R.id.zipCode) EditText mZipCodeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSearchCharitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = mZipCodeEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, CharityResults.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });
    }
}
