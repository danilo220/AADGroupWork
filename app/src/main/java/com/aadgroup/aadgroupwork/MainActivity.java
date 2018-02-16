package com.aadgroup.aadgroupwork;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
{
    private boolean userIsInteracting;
    private FirebaseAuth mAuth;
    Button btnBegin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        Button logInButton = findViewById(R.id.btn_login);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        btnBegin = findViewById(R.id.btn_begin);
        btnBegin.setVisibility(View.VISIBLE);
        btnBegin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), menuActivity.class);
                startActivity(myIntent);
            }
        });

        Button clinicianButton = findViewById(R.id.btn_clinician);
        clinicianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), ClinicianActivity.class);
                startActivity(myIntent);
            }
        });

        Button logoutButton = findViewById(R.id.btn_logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstraintLayout loginLayout = findViewById(R.id.loginLayout);
                loginLayout.setVisibility(View.VISIBLE);

                ConstraintLayout loggedInLayout = findViewById(R.id.loggedInLayout);
                loggedInLayout.setVisibility(View.GONE);

                Button btnLogin = findViewById(R.id.btn_login);
                btnLogin.setVisibility(View.VISIBLE);

                FirebaseAuth.getInstance().signOut();
            }
        });

        //http://www.theappguruz.com/blog/multi-language-support-to-android-app
        final Spinner languageSelect = findViewById(R.id.spn_language);
        languageSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (userIsInteracting) {
                    String selectedLanguage = languageSelect.getSelectedItem().toString();
                    switch (selectedLanguage) {
                        case "English":
                            switchLanguage("en");
                            languageSelect.setSelection(0);
                            userIsInteracting = false;
                            break;
                        case "German":
                            switchLanguage("de");
                            languageSelect.setSelection(1);
                            userIsInteracting = false;
                            break;
                        default:
                            break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

            public void switchLanguage(String languageCode)
            {
                //https://stackoverflow.com/questions/12908289/how-to-change-language-of-app-when-user-selects-language
                Locale myLocale = new Locale(languageCode);
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale = myLocale;
                res.updateConfiguration(conf, dm);
                Intent refresh = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(refresh);
                finish();
            }
        });
    }

    //prevents spinner from auto-firing
    @Override
    public void onUserInteraction()
    {
        super.onUserInteraction();
        userIsInteracting = true;
    }

    private void signIn() {

        EditText txtUsername = findViewById(R.id.txtUsername);
        String username = txtUsername.getText().toString();

        EditText txtPassword = findViewById(R.id.txtPassword);
        String password = txtPassword.getText().toString();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(MainActivity.this, "Fields are Empty", Toast.LENGTH_LONG).show();

        } else {
            mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
            {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(MainActivity.this, "Sign in Successful", Toast.LENGTH_LONG).show();
                        showPanel();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Email or Password incorrect", Toast.LENGTH_LONG).show();
                    }

                }
            });
        }
    }

    private void showPanel()
    {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String uid = user.getUid();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ConstraintLayout loginLayout = findViewById(R.id.loginLayout);
                loginLayout.setVisibility(View.GONE);

                ConstraintLayout loggedInLayout = findViewById(R.id.loggedInLayout);
                loggedInLayout.setVisibility(View.VISIBLE);

                TextView loggedInMsg = findViewById(R.id.txtLoggedInMsg);
                String username = dataSnapshot.child("users").child(uid).child("Email").getValue(String.class);
                loggedInMsg.setText(getResources().getString(R.string.loggedIn) + " " + username + "!");

                Boolean clinician = dataSnapshot.child("users").child(uid).child("Clinician").getValue(Boolean.class);
                if (clinician)
                {
                    Button btnClinician = findViewById(R.id.btn_clinician);
                    btnClinician.setVisibility(View.VISIBLE);
                }
                else
                {
                    Button btnBegin = findViewById(R.id.btn_begin);
                    btnBegin.setVisibility(View.VISIBLE);
                }
                Button btnLogin = findViewById(R.id.btn_login);
                btnLogin.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
