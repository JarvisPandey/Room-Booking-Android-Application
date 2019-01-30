package com.example.shubhampandey.bookmyroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;



public class uploadroomdetails extends AppCompatActivity {


    EditText editplace,editbhk,editrent,editphone;
    Button data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadroomdetails);

        editplace=(EditText) findViewById(R.id.editText2);
        editbhk=(EditText) findViewById(R.id.editText3);
        editrent=(EditText) findViewById(R.id.editText4);
        editphone=(EditText) findViewById(R.id.editText);

        data=(Button) findViewById(R.id.button);

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(uploadroomdetails.this,"Data Uploaded",Toast.LENGTH_SHORT).show();
            }
        });

        }


}