package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class ChangeActivity extends AppCompatActivity {
    private Button mButton1;
    private Button mLayout3;

    private TextView mValueView;
    private Firebase nRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        //memindahkan layout ke home
        mButton1 = (Button) findViewById(R.id.button1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        //pindah ke layout 3
        mLayout3 = (Button) findViewById(R.id.layout2);
        mLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });


        //mengambil data dari firebase
        mValueView = (TextView) findViewById(R.id.valueView);
        nRef = new Firebase("https://fir-app-b8187.firebaseio.com/AmbilData");

        nRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                mValueView.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {


            }
        });


    }

    //pindah layout ke home
    public void openActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    //pindah ke layout 3
    public void openActivity1(){
        Intent intent = new Intent(this,ListFireBase.class);
        startActivity(intent);
    }
}
