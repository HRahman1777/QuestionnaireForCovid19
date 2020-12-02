package com.example.questionnaireforcovid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Result extends AppCompatActivity {

    public Button buttonHome;
    public TextView textViewName, textViewDate, textViewComment, textViewAge;

    public int red, red2, sim;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        buttonHome = findViewById(R.id.homeBtnID);
        textViewName = findViewById(R.id.textVnameID);
        textViewDate = findViewById(R.id.textVdateID);
        textViewComment = findViewById(R.id.textVcmtID);
        textViewAge = findViewById(R.id.textVageID);

        Bundle bundle = getIntent().getExtras();
        red = bundle.getInt("KeyR");
        red2 = bundle.getInt("KeyR2");
        sim = bundle.getInt("KeyS");

        finding();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("name");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String strN = dataSnapshot.getValue().toString();
                textViewName.setText(strN);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        databaseReference = FirebaseDatabase.getInstance().getReference().child("age");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String strA = dataSnapshot.getValue().toString();
                textViewAge.setText(strA);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        databaseReference = FirebaseDatabase.getInstance().getReference().child("date");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String strD = dataSnapshot.getValue().toString();
                textViewDate.setText(strD);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent((Result.this),(MainActivity.class));
                startActivity(intent);

            }
        });


    }

    @SuppressLint("SetTextI18n")
    private void finding() {
        String advice = getString(R.string.advice);
        String highRisk = getString(R.string.highRisk);
        String risk = getString(R.string.risk);
        if (red>=1 && red2>=4)
        {
            textViewComment.setText(highRisk+advice);
        }
        else if (red>=2 && red2>=2){
            textViewComment.setText(highRisk+advice);
        }
        else if (red>=2 && red2>=1){
            textViewComment.setText(risk+advice);
        }
        else if (red>=1 && red2>=2){
            textViewComment.setText(risk+advice);
        }
        else if (sim>=4 && red>=1){
            textViewComment.setText(risk+advice);
        }
        else if (sim>=4 && red2>=1){
            textViewComment.setText(risk+advice);
        }
        else
            textViewComment.setText(advice);
    }
}
