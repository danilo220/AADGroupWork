package com.aadgroup.aadgroupwork;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.System.in;

public class MainActivity extends AppCompatActivity
{
    ArrayList<Account> allAccounts = new ArrayList<>();
    int accIndex = -1;

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
                    loggedInMsg.setText("You are logged in as " + username + "!");

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
    }

}
