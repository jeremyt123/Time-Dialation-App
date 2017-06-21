package com.example.jeremy.earthandspaceapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ISSFacts extends AppCompatActivity {
    TextView issTFECalc;
    TextView issTFSCalc;

    BigDecimal secInYear = new BigDecimal("31536000");
    BigDecimal issDistance = new BigDecimal("400000");
    double speedLight = 299792458;
    double speedInput = speedSelection.speedInput;
    BigDecimal speed = BigDecimal.valueOf(speedInput);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issfacts);

        issTFSCalc = (TextView) findViewById(R.id.issTFSCalc);

        BigDecimal issTFSYear = issDistance.divide(speed, 5, 5).divide(secInYear, 5, 5);
        issTFSCalc.setText(issTFSYear.toPlainString() + " Years");

        //Calculating time for earth
        issTFECalc = (TextView) findViewById(R.id.issTFECalc);

        DecimalFormat df = new DecimalFormat("###.00000");

        //converting the time for earth to double to ease calculation
        double issTFSYearDouble = issTFSYear.doubleValue();
        //calculating time dialation
        double issTFEYear = (issTFSYearDouble / (1 - Math.sqrt((Math.pow(speedInput, 2) / Math.pow(speedLight, 2)))));


        issTFECalc.setText(df.format(issTFEYear) + " Years");
    }
}
