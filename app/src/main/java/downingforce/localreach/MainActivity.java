package downingforce.localreach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button mSearchCharitiesButton;
    private EditText mZipCodeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mZipCodeEditText = (EditText) findViewById(R.id.zipCode);
        mSearchCharitiesButton = (Button) findViewById(R.id.seachCharitiesButton);
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
