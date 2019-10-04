package com.example.quicklauncher2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//attempts to launch an activity within my own app
        Button SecondActivityBtn = (Button) findViewById(R.id.SecondActivityBtn);
        SecondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);

                startIntent.putExtra("com.example.quicklauncher2.SOMETHING", "HELLO WORLD!");

                startActivity(startIntent);
            }
        });
        //attempt to launch an activity outside my app
        Button GoogleBtn = (Button) findViewById(R.id.GoogleBtn);
        GoogleBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String google = "https://www.google.com";
                Uri webaddress = Uri.parse(google);

                Intent gotogoogle = new Intent(Intent.ACTION_VIEW, webaddress);
                if (gotogoogle.resolveActivity(getPackageManager()) != null){
                    startActivity(gotogoogle);
                }
            }
        });
    }
}
