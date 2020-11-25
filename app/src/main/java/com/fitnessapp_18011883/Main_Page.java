package com.fitnessapp_18011883;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Main_Page extends AppCompatActivity {
    Button PersonalInfo, Water, Meals, view, Targets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__page);
        PersonalInfo=(Button) findViewById(R.id.PersonalInfo);
        Water=(Button) findViewById(R.id.Intake);
        Meals=(Button) findViewById(R.id.Meals);

        view= findViewById(R.id.btn_PersonalView);
        Targets=findViewById(R.id.targets);

        Targets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main_Page.this, TargetGoals.class));
            }
        });

        PersonalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main_Page.this, PersonalInfo.class));
            }
        });

        Water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main_Page.this, WaterIntake.class));
            }
        });

        Meals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main_Page.this, Meals.class));
            }
        });


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main_Page.this, ViewData.class));
            }
        });
    }
}