package com.example.jeremy.earthandspaceapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class andromedaFacts extends AppCompatActivity {

    TextView andromedaTFECalc;
    TextView andromedaTFSCalc;

    BigDecimal secInYear = new BigDecimal("31536000");
    BigDecimal andromedaDistance = new BigDecimal("24000000000000000000000");
    double speedLight = 299792458;
    double speedInput = speedSelection.speedInput;
    BigDecimal speed = BigDecimal.valueOf(speedInput);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andromeda_facts);
        andromedaTFSCalc = (TextView) findViewById(R.id.andromedaTFSCalc);

        BigDecimal andromedaTFSYear = andromedaDistance.divide(speed, 0, 0).divide(secInYear, 0,0);
        andromedaTFSCalc.setText(andromedaTFSYear.toPlainString() + " Years");

        //Calculating time for earth
        andromedaTFECalc = (TextView) findViewById(R.id.andromedaTFECalc);

        DecimalFormat df = new DecimalFormat("###");

        //converting the time for earth to double to ease calculation
        double andromedaTFSYearDouble = andromedaTFSYear.doubleValue();
        //calculating time dialation
        double andromedaTFEYear = (andromedaTFSYearDouble / (1 - Math.sqrt((Math.pow(speedInput, 2) / Math.pow(speedLight, 2)))));


        andromedaTFECalc.setText(df.format(andromedaTFEYear) + " Years");
    }
}
