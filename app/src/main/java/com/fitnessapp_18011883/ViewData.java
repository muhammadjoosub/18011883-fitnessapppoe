package com.fitnessapp_18011883;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewData extends AppCompatActivity {
    TextView Name, DOB, Age, Height, weight, targetWeight,IH,IW,IDW;
    Switch ImperialSwitch;
    Button data;
    PersonalInfoClass personalInfoClass;
    private FirebaseAuth mAuth;
    FirebaseDatabase db = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        mAuth =FirebaseAuth.getInstance();
        Name=findViewById(R.id.TextViewName);
        DOB=findViewById(R.id.TextViewDOB);
        Age=findViewById(R.id.TextViewAge);
        Height=findViewById(R.id.TextViewHeight);
        weight=findViewById(R.id.TextViewWeight);
        targetWeight= findViewById(R.id.TextViewTargetWeight);
        IH = findViewById(R.id.textViewheightChange);
        IW = findViewById(R.id.textViewWeightChange);
        IDW =findViewById(R.id.textViewWeightChange2);
        ImperialSwitch= findViewById(R.id.switch1);

        data=findViewById(R.id.btn_Data);

        ImperialSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(b){
                    IH.setText("inches");
                    IW.setText("lbs");
                    IDW.setText("lbs");
                }else
                {
                    IH.setText("meters");
                    IW.setText(("kg"));
                    IDW.setText("kg");
                }

            }
        });

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference = db.getReference(mAuth.getCurrentUser().getUid());
                reference.child("PersonalInfo").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        personalInfoClass = dataSnapshot.getValue(PersonalInfoClass.class);

                        Name.setText(personalInfoClass.getName());
                        DOB.setText(personalInfoClass.getDOB());
                        Age.setText(personalInfoClass.getAge());
                        Height.setText(personalInfoClass.getHeight());
                        weight.setText(personalInfoClass.getWeight());
                        targetWeight.setText(personalInfoClass.getTargetWeight());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}