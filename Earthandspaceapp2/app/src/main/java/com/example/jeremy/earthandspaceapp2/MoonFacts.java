package com.example.jeremy.earthandspaceapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MoonFacts extends AppCompatActivity {

    TextView moonTFECalc;
    TextView moonTFSCalc;

    BigDecimal secInYear = new BigDecimal("31536000");
    BigDecimal moonDistance = new BigDecimal("384400000");
    double speedLight = 299792458;
    double speedInput = speedSelection.speedInput;
    BigDecimal speed = BigDecimal.valueOf(speedInput);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moon_facts);

        moonTFSCalc = (TextView) findViewById(R.id.moonTFSCalc);

        BigDecimal moonTFSYear = moonDistance.divide(speed, 5, 5).divide(secInYear, 5, 5);
        moonTFSCalc.setText(moonTFSYear.toPlainString() + " Years");

        //Calculating time for earth
        moonTFECalc = (TextView) findViewById(R.id.moonTFECalc);

        DecimalFormat df = new DecimalFormat("###.00000");

        //converting the time for earth to double to ease calculation
        double moonTFSYearDouble = moonTFSYear.doubleValue();
        //calculating time dialation
        double moonTFEYear = (moonTFSYearDouble / (1 - Math.sqrt((Math.pow(speedInput, 2) / Math.pow(speedLight, 2)))));


        moonTFECalc.setText(df.format(moonTFEYear) + " Years");
    }
}
