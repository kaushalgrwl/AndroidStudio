package com.example.detailslab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static java.lang.Boolean.*;


public class MainActivity extends AppCompatActivity {

    private EditText username;
    private RadioGroup ageGroup;
    private RadioButton ageOption;
    private CheckBox optionSurat, optionBangalore, optionMysore, optionDelhi;
    private Button submit;
    private int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INITIALIZATION
        username = findViewById(R.id.username);
        ageGroup = findViewById(R.id.ageGroup);
        optionSurat = findViewById(R.id.optionCityGuwahati);
        optionBangalore = findViewById(R.id.optionCityBangalore);
        optionMysore = findViewById(R.id.optionCityMysore);
        optionDelhi = findViewById(R.id.optionCityDelhi);
        submit = findViewById(R.id.submitButton);


        //SUBMIT BUTTON EVENT CONTROLLER
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer displayMsg = new StringBuffer();
                displayMsg.append("Username: ");
                flag = 0;

                String user = username.getText().toString();

                //VALIDATION
                if (user.matches("") ) {
                    flag = -1;

                    Toast toast = Toast.makeText(MainActivity.this, "Please enter username",
                            Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    displayMsg.append(user).append("\n");
                }

                int radioID = ageGroup.getCheckedRadioButtonId();
                ageOption = findViewById(radioID);

                //VALIDATION
                if (radioID == -1) {
                    flag = -1;
                    Toast toast = Toast.makeText(MainActivity.this, "Please enter age",
                            Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    displayMsg.append("Age Group: ");
                    displayMsg.append(ageOption.getText()).append("\n");
                }

                //VALIDATION
                if (optionSurat.isChecked() == FALSE && optionBangalore.isChecked() == FALSE && optionMysore.isChecked() == FALSE && optionDelhi.isChecked() == FALSE) {
                    flag = -1;
                    Toast toast = Toast.makeText(MainActivity.this, "Please select at least one city",
                            Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    displayMsg.append("Preferred City: ");
                    if(optionSurat.isChecked()){
                        displayMsg.append(optionSurat.getText());
                    }
                    if(optionBangalore.isChecked()){
                        displayMsg.append(", ").append(optionBangalore.getText());
                    }
                    if(optionMysore.isChecked()){
                        displayMsg.append(", ").append(optionMysore.getText());
                    }
                    if(optionDelhi.isChecked()){
                        displayMsg.append(", ").append(optionDelhi.getText());
                    }
                }

                //FINAL DISPLAY MESSAGE
                if (flag == 0) {
                    Toast.makeText(MainActivity.this, displayMsg,Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}