package com.example.questionnaireforcovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuestionnaireOne extends AppCompatActivity {

    private RadioButton radioButtonOne, radioButtonThree, radioButtonFive
            , radioButtonSeven, radioButtonNine;
    public int red=0, red2=0, sim=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_one);

        Button buttonSubmit = findViewById(R.id.buttonOneIid);
        radioButtonOne = findViewById(R.id.radioOneButtonid);
        radioButtonThree = findViewById(R.id.radioThreeButtonid);
        radioButtonFive = findViewById(R.id.radioFiveButtonid);
        radioButtonSeven = findViewById(R.id.radioSevenButtonid);
        radioButtonNine = findViewById(R.id.radioNineButtonid);



        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButtonOne.isChecked()) {
                    red++;
                }

                if (radioButtonThree.isChecked()){
                    red++;
                }

                if (radioButtonFive.isChecked()){
                    red++;
                }

                if (radioButtonSeven.isChecked()){
                    red++;
                }

                if (radioButtonNine.isChecked()){
                    sim++;
                }

                Intent intent = new Intent((QuestionnaireOne.this),(QuestionnaireTwo.class));
                intent.putExtra("KeyR",red);
                intent.putExtra("KeyR2",red2);
                intent.putExtra("KeyS",sim);
                startActivity(intent);

            }
        });


    }
}
