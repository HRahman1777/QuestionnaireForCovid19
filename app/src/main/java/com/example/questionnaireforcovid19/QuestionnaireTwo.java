package com.example.questionnaireforcovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class QuestionnaireTwo extends AppCompatActivity {

    private RadioButton radioButtonEleven, radioButtonThiteen,
    radioButtonFifteen, radioButtonSeventeen, radioButtonNinteen;

    public int red, red2, sim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_two);

        Button buttonSubmitT = findViewById(R.id.buttonTwoIid);
        radioButtonEleven = findViewById(R.id.radioElevenButtonid);
        radioButtonThiteen= findViewById(R.id.radioThrteenButtonid);
        radioButtonFifteen = findViewById(R.id.radioFifteenButtonID);
        radioButtonSeventeen = findViewById(R.id.radioSeventeenButtonID);
        radioButtonNinteen = findViewById(R.id.radioNinteenButtonID);

        Bundle bundle = getIntent().getExtras();
        red = bundle.getInt("KeyR");
        red2 = bundle.getInt("KeyR2");
        sim = bundle.getInt("KeyS");

        buttonSubmitT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButtonEleven.isChecked()) {
                    red=red+2;
                }


                if (radioButtonThiteen.isChecked()){
                    red++;
                }


                if (radioButtonFifteen.isChecked()){
                    red2++;
                }


                if (radioButtonSeventeen.isChecked()){
                    red2++;
                }


                if (radioButtonNinteen.isChecked()){
                    red2++;
                }


                Intent intent = new Intent((QuestionnaireTwo.this),(QuestionnaireThree.class));
                intent.putExtra("KeyR",red);
                intent.putExtra("KeyR2",red2);
                intent.putExtra("KeyS",sim);
                startActivity(intent);

            }
        });
    }
}
