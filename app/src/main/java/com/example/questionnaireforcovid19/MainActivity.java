package com.example.questionnaireforcovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    public Button button;
    public EditText editTextName, editTextDate, editTextAge;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.mainSubmitBtnID);
        editTextName = findViewById(R.id.nameETid);
        editTextDate = findViewById(R.id.dateETid);
        editTextAge = findViewById(R.id.ageETid);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strName = editTextName.getText().toString();
                String strDate = editTextDate.getText().toString();
                String strAge = editTextAge.getText().toString();

                if (strName.equals("") || strDate.equals("") || strAge.equals("")){
                    Toast.makeText(MainActivity.this, "Enter info properly!!",Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference = FirebaseDatabase.getInstance().getReference().child("name");
                    databaseReference.setValue(strName);

                    databaseReference = FirebaseDatabase.getInstance().getReference().child("date");
                    databaseReference.setValue(strDate);

                    databaseReference = FirebaseDatabase.getInstance().getReference().child("age");
                    databaseReference.setValue(strAge);

                    Intent intent = new Intent((MainActivity.this),(QuestionnaireOne.class));
                    startActivity(intent);
                }
            }
        });

    }
}
