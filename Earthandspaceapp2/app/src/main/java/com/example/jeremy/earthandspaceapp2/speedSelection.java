package com.example.jeremy.earthandspaceapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

public class speedSelection extends AppCompatActivity {

    public EditText speedTxt;
    public static int speedInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_selection);

        configurecontinueButton();
        speedTxt = (EditText) findViewById(R.id.userSpeed);
    }
    //checking for button press
    private void configurecontinueButton(){
        Button continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getting the value from the speed field
                speedInput = Integer.parseInt(speedTxt.getText().toString());
                //turning the activity to the destination selector
                startActivity(new Intent(speedSelection.this, Destinationselector.class));
            }
        });
    }
}
