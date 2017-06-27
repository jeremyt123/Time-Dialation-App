package com.example.jeremy.earthandspaceapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class proximaFacts extends AppCompatActivity {
    TextView proximaTFECalc;
    TextView proximaTFSCalc;

    BigDecimal secInYear = new BigDecimal("31536000");
    BigDecimal proximaDistance = new BigDecimal("39700000000000000");
    double speedLight = 299792458;
    double speedInput = speedSelection.speedInput;
    BigDecimal speed = BigDecimal.valueOf(speedInput);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxima_facts);


        proximaTFSCalc = (TextView) findViewById(R.id.proximaTFSCalc);

        BigDecimal proximaTFSYear = proximaDistance.divide(speed, 5, 5).divide(secInYear, 5, 5);
        proximaTFSCalc.setText(proximaTFSYear.toPlainString() + " Years");

        //Calculating time for earth
        proximaTFECalc = (TextView) findViewById(R.id.proximaTFECalc);

        DecimalFormat df = new DecimalFormat("###.00000");

        //converting the time for earth to double to ease calculation
        double proximaTFSYearDouble = proximaTFSYear.doubleValue();
        //calculating time dialation
        double proximaTFEYear = (proximaTFSYearDouble / (1 - Math.sqrt((Math.pow(speedInput, 2) / Math.pow(speedLight, 2)))));


        proximaTFECalc.setText(df.format(proximaTFEYear) + " Years");
    }
}
