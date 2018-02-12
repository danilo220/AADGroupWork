package com.aadgroup.aadgroupwork;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import static java.lang.System.in;

public class MainActivity extends AppCompatActivity
{
    ArrayList<Account> allAccounts = new ArrayList<>();
    int accIndex = -1;
    private boolean userIsInteracting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allAccounts.add(new Account("Dave123", "1234", false));
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

        Button roadRecognitionButton = findViewById(R.id.btn_road_recognition);
        roadRecognitionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), RoadSign.class);
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
                            //this.setContentView(R.layout.activity_main);
                            Toast toast = Toast.makeText(getApplicationContext(), "en", Toast.LENGTH_SHORT);
                            toast.show();
                            break;
                        case "German":
                            switchLanguage("de");
                            Toast toast2 = Toast.makeText(getApplicationContext(), "de", Toast.LENGTH_SHORT);
                            toast2.show();
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
                /*String languageToLoad = languageCode; // your language
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                this.setContentView(R.layout.activity_main)*/
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
    @Override
    public void onUserInteraction()
    {
        super.onUserInteraction();
        userIsInteracting = true;
    }

}
