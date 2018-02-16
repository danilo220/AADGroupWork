package com.aadgroup.aadgroupwork;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
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

import java.util.ArrayList;
import java.util.Locale;
import static java.lang.System.in;

public class MainActivity extends AppCompatActivity
{
    //ArrayList<Account> allAccounts = new ArrayList<>();
    //int accIndex = -1;
    private boolean userIsInteracting;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private DatabaseReference mUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mUsers = mDatabase.child("users");

        Button logInButton = findViewById(R.id.btn_login);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

/*        allAccounts.add(new Account("Dave123", "1234", false));
        allAccounts.add(new Account("Sarah88", "1234", false));
        allAccounts.add(new Account("Henry", "1234", true));

        final Button btnBegin = findViewById(R.id.btn_begin);
        btnBegin.setVisibility(View.VISIBLE);
        btnBegin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), DotCancellation.class);
                myIntent.putExtra("AccountDetails", allAccounts.get(accIndex));
                startActivity(myIntent);
            }
        });

        Button logInButton = findViewById(R.id.btn_login);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtUsername = findViewById(R.id.txtUsername);
                String username = txtUsername.getText().toString();

                EditText txtPassword = findViewById(R.id.txtPassword);
                String password = txtPassword.getText().toString();

                Boolean accountFound = false;

                for (int i = 0; i < allAccounts.size(); i++)
                {
                    if (allAccounts.get(i).getUsername().equals(username))
                    {
                        accountFound = true;
                        accIndex = i;
                        break;
                    }
                }

                if (accountFound && allAccounts.get(accIndex).getPassword().equals(password))
                {
                    ConstraintLayout loginLayout = findViewById(R.id.loginLayout);
                    loginLayout.setVisibility(View.GONE);

                    ConstraintLayout loggedOnLayout = findViewById(R.id.loggedInLayout);
                    loggedOnLayout.setVisibility(View.VISIBLE);

                    TextView loggedInMsg = findViewById(R.id.txtLoggedInMsg);
                    loggedInMsg.setText(getResources().getString(R.string.loggedIn) + username + "!");

                    if (allAccounts.get(accIndex).getIsClinician())
                    {
                        Button btnResults = findViewById(R.id.btn_results);
                        btnResults.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        btnBegin.setVisibility(View.VISIBLE);
                    }
                }
                else
                {
                    TextView errorMsg = findViewById(R.id.txtErrorMessage);
                    errorMsg.setText("Account details incorrect!");
                }
            }
        });*/

        Button menuButton = findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), menuActivity.class);
                startActivity(myIntent);
            }
        });

        Button dotButton = findViewById(R.id.btn_dot);
        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), DotCancellation.class);
                startActivity(myIntent);
            }
        });

        Button directionButton = findViewById(R.id.btn_direction);
        directionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), SquareMatricesDirections.class);
                startActivity(myIntent);
            }
        });

        Button compassButton = findViewById(R.id.btn_compass);
        compassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), SquareMatricesCompass.class);
                startActivity(myIntent);
            }
        });

        Button roadRecognitionButton = findViewById(R.id.btn_road_recognition);
        roadRecognitionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), RoadSign.class);
                startActivity(myIntent);
            }
        });

        Button pathFormingButton = findViewById(R.id.btn_path_forming);
        pathFormingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), PathForming.class);
                startActivity(myIntent);
            }
        });


        Button resultsButton = findViewById(R.id.btn_results);
        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), Results.class);
                startActivity(myIntent);
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
                            break;
                        case "German":
                            switchLanguage("de");
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
        //userIsInteracting = true;
    }

    private void signIn() {

        EditText txtUsername = findViewById(R.id.txtUsername);
        String username = txtUsername.getText().toString();

        EditText txtPassword = findViewById(R.id.txtPassword);
        String password = txtPassword.getText().toString();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(MainActivity.this, "Fields are Empty", Toast.LENGTH_LONG).show();

        } else {
            mAuth.signInWithEmailAndPassword(username, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Intent myIntent = new Intent(getApplicationContext(), menuActivity.class);
                                startActivity(myIntent);
                                // Sign in success, update UI with the signed-in user's information
                                //FirebaseUser user = mAuth.getCurrentUser();
                                //Toast.makeText(MainActivity.this, "Sign in Successful", Toast.LENGTH_LONG).show();
                                mUsers.child("Email").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        String value = "didnt find anything";
                                        value = dataSnapshot.getValue(String.class);
                                        Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
                                    }
                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                        //nothing
                                    }
                                });
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Email or Password incorrect", Toast.LENGTH_LONG).show();
                            }

                            // ...
                        }
                    });
        }
    }





}
