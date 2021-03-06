package downingforce.localreach.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;
import downingforce.localreach.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.seachCharitiesButton) Button mSearchCharitiesButton;
    @Bind(R.id.zipCode) EditText mZipCodeEditText;
    @Bind(R.id.myCharitiesButton) Button mMyCharitiesButton;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSearchCharitiesButton.setOnClickListener(this);
        mMyCharitiesButton.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    getSupportActionBar().setTitle("Welcome back " + user.getDisplayName());
                } else {

                }
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v == mSearchCharitiesButton) {
            String location = mZipCodeEditText.getText().toString();
            if (location.equals("")) {
                Animation shake = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
                mZipCodeEditText.startAnimation(shake);
            } else {
                Intent intent = new Intent(MainActivity.this, CharityResults.class);
                intent.putExtra("location", location);
                startActivity(intent);
                Animation animation = new AlphaAnimation(1.0f, 0.0f);
                animation.setDuration(1000);
                mSearchCharitiesButton.startAnimation(animation);
            }
        }
        if (v == mMyCharitiesButton) {
            Intent intent = new Intent(MainActivity.this, SavedCharityList.class);
            startActivity(intent);
            Animation animation = new AlphaAnimation(1.0f, 0.0f);
            animation.setDuration(1000);
            mMyCharitiesButton.startAnimation(animation);
        }
    }
}

