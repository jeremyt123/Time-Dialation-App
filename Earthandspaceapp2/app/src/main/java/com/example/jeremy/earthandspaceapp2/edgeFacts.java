package com.example.jeremy.earthandspaceapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class edgeFacts extends AppCompatActivity {

    TextView edgeTFECalc;
    TextView edgeTFSCalc;

    BigDecimal secInYear = new BigDecimal("31536000");
    BigDecimal edgeDistance = new BigDecimal("131000000000000000000000000");
    double speedLight = 299792458;
    double speedInput = speedSelection.speedInput;
    BigDecimal speed = BigDecimal.valueOf(speedInput);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edge_facts);

        edgeTFSCalc = (TextView) findViewById(R.id.edgeTFSCalc);

        BigDecimal edgeTFSYear = edgeDistance.divide(speed, 0, 0).divide(secInYear, 0,0);
        edgeTFSCalc.setText(edgeTFSYear.toPlainString() + " Years");

        //Calculating time for earth
        edgeTFECalc = (TextView) findViewById(R.id.edgeTFECalc);

        DecimalFormat df = new DecimalFormat("###");

        //converting the time for earth to double to ease calculation
        double edgeTFSYearDouble = edgeTFSYear.doubleValue();
        //calculating time dialation
        double edgeTFEYear = (edgeTFSYearDouble / (1 - Math.sqrt((Math.pow(speedInput, 2) / Math.pow(speedLight, 2)))));


        edgeTFECalc.setText(df.format(edgeTFEYear) + " Years");
    }
}
