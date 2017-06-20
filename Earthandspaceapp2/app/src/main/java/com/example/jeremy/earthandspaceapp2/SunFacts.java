package com.example.jeremy.earthandspaceapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class SunFacts extends AppCompatActivity {

    TextView sunTFECalc;
    TextView sunTFSCalc;

    BigDecimal secInYear = new BigDecimal("31536000");
    BigDecimal sunDistance = new BigDecimal("150000000000");
    double speedLight = 299792458;
    double speedInput = speedSelection.speedInput;
    BigDecimal speed = BigDecimal.valueOf(speedInput);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Calculating time for ship
        setContentView(R.layout.activity_sun_facts);

        sunTFSCalc = (TextView) findViewById(R.id.sunTFSCalc);

        BigDecimal sunTFSYear = sunDistance.divide(speed, 5, 5).divide(secInYear, 5, 5);
        sunTFSCalc.setText(sunTFSYear.toPlainString() + " Years");

        //Calculating time for earth
        sunTFECalc = (TextView) findViewById(R.id.sunTFECalc);

        DecimalFormat df = new DecimalFormat("###.00000");

        //converting the time for earth to double to ease calculation
        double sunTFSYearDouble = sunTFSYear.doubleValue();
        //calculating time dialation
        double sunTFEYear = (sunTFSYearDouble / (1 - Math.sqrt((Math.pow(speedInput, 2) / Math.pow(speedLight, 2)))));


        sunTFECalc.setText(df.format(sunTFEYear) + " Years");
    }

}
