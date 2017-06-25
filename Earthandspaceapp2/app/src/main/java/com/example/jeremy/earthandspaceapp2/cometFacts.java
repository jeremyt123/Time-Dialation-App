package com.example.jeremy.earthandspaceapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class cometFacts extends AppCompatActivity {
    TextView cometTFECalc;
    TextView cometTFSCalc;

    BigDecimal secInYear = new BigDecimal("31536000");
    BigDecimal cometDistance = new BigDecimal("510000000000");
    double speedLight = 299792458;
    double speedInput = speedSelection.speedInput;
    BigDecimal speed = BigDecimal.valueOf(speedInput);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comet_facts);

        cometTFSCalc = (TextView) findViewById(R.id.cometTFSCalc);

        BigDecimal cometTFSYear = cometDistance.divide(speed, 5, 5).divide(secInYear, 5, 5);
        cometTFSCalc.setText(cometTFSYear.toPlainString() + " Years");

        //Calculating time for earth
        cometTFECalc = (TextView) findViewById(R.id.cometTFECalc);

        DecimalFormat df = new DecimalFormat("###.00000");

        //converting the time for earth to double to ease calculation
        double cometTFSYearDouble = cometTFSYear.doubleValue();
        //calculating time dialation
        double cometTFEYear = (cometTFSYearDouble / (1 - Math.sqrt((Math.pow(speedInput, 2) / Math.pow(speedLight, 2)))));


        cometTFECalc.setText(df.format(cometTFEYear) + " Years");
    }
}
