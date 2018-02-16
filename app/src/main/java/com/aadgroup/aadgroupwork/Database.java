package com.aadgroup.aadgroupwork;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Date;

public class Database extends AppCompatActivity
{
    private FirebaseUser user;
    private String uid;
    private DatabaseReference databaseReference;
    private String username;
    private String result;
    private String date;
    private Boolean clinician;

    public Database()
    {
        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();

        addData();
        fetchData();
    }

    private void addData(){ //String field, Class<?> value
        databaseReference = FirebaseDatabase.getInstance().getReference();
        String userID = uid;
        String result = "pass";
        Boolean clinician = false;

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();

        databaseReference.child("users").child(userID).setValue(userID);
        databaseReference.child("users").child(userID).child("Email").setValue(email);
        databaseReference.child("users").child(userID).child("Result").setValue(result);
        databaseReference.child("users").child(userID).child("Date & Time").setValue(currentDateTimeString);
        databaseReference.child("users").child(userID).child("Clinician").setValue(clinician);
    }

    public void fetchData() {

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                username = dataSnapshot.child("users").child(uid).child("Email").getValue(String.class);
                result = dataSnapshot.child("users").child(uid).child("Result").getValue(String.class);
                date = dataSnapshot.child("users").child(uid).child("Date & Time").getValue(String.class);
                clinician = dataSnapshot.child("users").child(uid).child("Clinician").getValue(Boolean.class);
                //Toast.makeText(getApplicationContext(), username, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public String getUsername()
    {
        return username;
    }

    public String getResult()
    {
        return result;
    }

    public String getDate()
    {
        return date;
    }

    public Boolean getClinician()
    {
        return clinician;
    }
}
