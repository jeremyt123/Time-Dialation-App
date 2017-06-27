package com.example.jeremy.earthandspaceapp2;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Destinationselector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destinationselector);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        backgroundImage.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.appbackgroundweb, 500, 500));
    //running the buttons on startup
        configuresunButton();
        configureissButton();
        configuremoonButton();
        configuremarsButton();
        configurecometButton();
        configureproximaButton();
        configurepolarisButton();
        configureandromedaButton();
        configureedgeButton();
    }
    //creating the button methods
    private void configuresunButton(){
        Button sunButton = (Button) findViewById(R.id.sunButton);
        sunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Destinationselector.this, SunFacts.class));
            }
        });
    }

    private void configureissButton(){
        Button issButton = (Button) findViewById(R.id.issButton);
        issButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Destinationselector.this, ISSFacts.class));
            }
        });
    }

    private void configuremoonButton(){
        Button moonButton = (Button) findViewById(R.id.moonButton);
        moonButton.setOnClickListener(new View.OnClickListener(){
            @Override
                    public  void onClick(View v) {
                        startActivity(new Intent(Destinationselector.this, MoonFacts.class));
            }

        });
    }

    private void configuremarsButton(){
        Button marsButton = (Button) findViewById(R.id.marsButton);
        marsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Destinationselector.this, MarsFacts.class));
            }
        });
    }

    private void configurecometButton(){
        Button cometButton = (Button) findViewById(R.id.cometButton);
        cometButton.setOnClickListener(new View.OnClickListener(){
          @Override
                  public void onClick(View v){
                startActivity(new Intent(Destinationselector.this, cometFacts.class));
            }
        });
    }

    private void configureproximaButton() {
        Button proximaButton = (Button) findViewById(R.id.proximaButton);
        proximaButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Destinationselector.this, proximaFacts.class));
            }
        });
    }

    private void configurepolarisButton() {
        Button polarisButton = (Button) findViewById(R.id.polarisButton);
        polarisButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                startActivity(new Intent(Destinationselector.this, polarisFacts.class));
            }
        });
    }

    private void configureandromedaButton(){
        final Button andromedaButton = (Button) findViewById(R.id.andromedaButton);
        andromedaButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                startActivity(new Intent(Destinationselector.this, andromedaFacts.class));
            }
        });
    }

    private void configureedgeButton(){
        Button edgeButton = (Button) findViewById(R.id.edgeButton);
        edgeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Destinationselector.this, edgeFacts.class));
            }
        });
    }
    //formatting large image
    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight){
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if(height > reqHeight || width > reqWidth){
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            while((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth ){
                inSampleSize *= 2;

            }
        }
        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight){
        //decoding the image
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}
