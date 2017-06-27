package com.example.jeremy.earthandspaceapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class polarisFacts extends AppCompatActivity {
    TextView polarisTFECalc;
    TextView polarisTFSCalc;

    BigDecimal secInYear = new BigDecimal("31536000");
    BigDecimal polarisDistance = new BigDecimal("4100000000000000000");
    double speedLight = 299792458;
    double speedInput = speedSelection.speedInput;
    BigDecimal speed = BigDecimal.valueOf(speedInput);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polaris_facts);

        polarisTFSCalc = (TextView) findViewById(R.id.polarisTFSCalc);

        BigDecimal polarisTFSYear = polarisDistance.divide(speed, 5, 5).divide(secInYear, 5, 5);
        polarisTFSCalc.setText(polarisTFSYear.toPlainString() + " Years");

        //Calculating time for earth
        polarisTFECalc = (TextView) findViewById(R.id.polarisTFECalc);

        DecimalFormat df = new DecimalFormat("###.00000");

        //converting the time for earth to double to ease calculation
        double polarisTFSYearDouble = polarisTFSYear.doubleValue();
        //calculating time dialation
        double polarisTFEYear = (polarisTFSYearDouble / (1 - Math.sqrt((Math.pow(speedInput, 2) / Math.pow(speedLight, 2)))));


        polarisTFECalc.setText(df.format(polarisTFEYear) + " Years");
    }
}
