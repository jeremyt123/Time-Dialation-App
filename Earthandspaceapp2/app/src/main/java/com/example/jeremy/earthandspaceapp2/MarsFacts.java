package com.example.jeremy.earthandspaceapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MarsFacts extends AppCompatActivity {

    TextView marsTFECalc;
    TextView marsTFSCalc;

    BigDecimal secInYear = new BigDecimal("31536000");
    BigDecimal marsDistance = new BigDecimal("54600000000");
    double speedLight = 299792458;
    double speedInput = speedSelection.speedInput;
    BigDecimal speed = BigDecimal.valueOf(speedInput);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mars_facts);

        marsTFSCalc = (TextView) findViewById(R.id.marsTFSCalc);

        BigDecimal marsTFSYear = marsDistance.divide(speed, 5, 5).divide(secInYear, 5, 5);
        marsTFSCalc.setText(marsTFSYear.toPlainString() + " Years");

        //Calculating time for earth
        marsTFECalc = (TextView) findViewById(R.id.marsTFECalc);

        DecimalFormat df = new DecimalFormat("###.00000");

        //converting the time for earth to double to ease calculation
        double marsTFSYearDouble = marsTFSYear.doubleValue();
        //calculating time dialation
        double marsTFEYear = (marsTFSYearDouble / (1 - Math.sqrt((Math.pow(speedInput, 2) / Math.pow(speedLight, 2)))));


        marsTFECalc.setText(df.format(marsTFEYear) + " Years");
    }
}
