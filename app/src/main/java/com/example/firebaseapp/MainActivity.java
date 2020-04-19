package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;


public class MainActivity extends AppCompatActivity {

    private Button mSendData;
    private Firebase nRef;

    private EditText mValueField;
    private Button mAddBtn;
    private EditText mKeyValue;


    private Button mPindahLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        nRef = new Firebase("https://fir-app-b8187.firebaseio.com/Users");

// Menyimpan ke firebase hanya 1
//        mSendData = (Button) findViewById(R.id.sendData);
//        mSendData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Firebase nRefChild = nRef.child("Name");
//
//                nRefChild.setValue("NGIIIK");
//
//            }
//        });



//Menyimpan multiple ke database
        mValueField = (EditText) findViewById(R.id.valueField);
        mAddBtn = (Button) findViewById(R.id.addBtn);
        mKeyValue = (EditText) findViewById(R.id.keyValue);

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = mValueField.getText().toString();
                String key = mKeyValue.getText().toString();

//                Firebase childRef = nRef.child("Name");
//                childRef.setValue(value);

                Firebase childRef = nRef.child(key);
                childRef.setValue(value);
            }
        });

        mPindahLayout = (Button) findViewById(R.id.pindahLayout);
        mPindahLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

    public void openActivity2() {

        Intent intent = new Intent(this,ChangeActivity.class);
        startActivity(intent);
    }
}
