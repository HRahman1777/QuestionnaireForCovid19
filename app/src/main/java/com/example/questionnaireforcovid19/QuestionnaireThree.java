package com.example.questionnaireforcovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class QuestionnaireThree extends AppCompatActivity {

    private RadioButton radioButtonTwentyThree, radioButtonTwentyFive, radioButtonTwentySeven
            , radioButtonTwentyNine, radioButtonThirtyOne, radioButtonThirtyThree;
    public int red=0, red2=0, sim=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_three);

        Button buttonSubmitTh = findViewById(R.id.buttonThreeIid);
        radioButtonTwentyThree = findViewById(R.id.radioTwentyThreeButtonID);
        radioButtonTwentyFive = findViewById(R.id.radioTwentyFiveButtonID);
        radioButtonTwentySeven = findViewById(R.id.radioTwentySevenButtonID);
        radioButtonTwentyNine = findViewById(R.id.radioTwtntyNineButtonID);
        radioButtonThirtyOne = findViewById(R.id.radioThirtyOneButtonID);
        radioButtonThirtyThree = findViewById(R.id.radioThirtyThreeButtonID);

        Bundle bundle = getIntent().getExtras();
        red = bundle.getInt("KeyR");
        red2 = bundle.getInt("KeyR2");
        sim = bundle.getInt("KeyS");

        buttonSubmitTh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButtonTwentyThree.isChecked()) {
                    sim++;
                }


                if (radioButtonTwentyFive.isChecked()){
                    sim++;
                }


                if (radioButtonTwentySeven.isChecked()){
                    sim++;
                }


                if (radioButtonTwentyNine.isChecked()){
                    sim++;
                }


                if (radioButtonThirtyOne.isChecked()){
                    sim++;
                }
                if (radioButtonThirtyThree.isChecked()){
                    red2++;
                }


                Intent intent = new Intent((QuestionnaireThree.this),(Result.class));
                intent.putExtra("KeyR",red);
                intent.putExtra("KeyR2",red2);
                intent.putExtra("KeyS",sim);
                startActivity(intent);

            }
        });
    }
}
