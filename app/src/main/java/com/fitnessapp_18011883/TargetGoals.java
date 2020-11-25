package com.fitnessapp_18011883;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TargetGoals extends AppCompatActivity {
    EditText height,targetHeight, weight,targetWeight,calorie,targetCalories, morningWeight,middayWeight,nightWeight;
    TextView morning,midday,night;
    Button btn_Targets, btn_ViewWeight, btn_Upload;
    private FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    UserWeights userWeights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_goals);
        final ProgressBar Userheight = findViewById(R.id.progressBarHeight);
        final ProgressBar Userweight = findViewById(R.id.progressBarWeight);
        final ProgressBar UserTargetHeight = findViewById(R.id.progressBarTargetHeight);
        final ProgressBar UserTargetWeight = findViewById(R.id.progressBarWeight2);
        final ProgressBar UserCalories = findViewById(R.id.progressBarCalories);
        final ProgressBar UserTargetCalories = findViewById(R.id.progressBarTargetCalories);
        height= findViewById(R.id.editTextHeight);
        targetHeight= findViewById(R.id.editTextTargetHeight);
        weight= findViewById(R.id.editTextWeight);
        targetWeight= findViewById(R.id.editTextTargetWeight);
        calorie= findViewById(R.id.editTextCalories);
        targetCalories= findViewById(R.id.editTextTargetCalories);

        btn_Targets=findViewById(R.id.btn_View);


        btn_Targets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Userheight.setProgress(Integer.parseInt(height.getText().toString()));
                Userweight.setProgress(Integer.parseInt(weight.getText().toString()));
                UserCalories.setProgress(Integer.parseInt(calorie.getText().toString()));
                UserTargetHeight.setProgress(Integer.parseInt(targetHeight.getText().toString()));
                UserTargetWeight.setProgress(Integer.parseInt(targetWeight.getText().toString()));
                UserTargetCalories.setProgress(Integer.parseInt(targetCalories.getText().toString()));
            }
        });



    }
}