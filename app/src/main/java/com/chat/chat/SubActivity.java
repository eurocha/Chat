package com.chat.chat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SubActivity extends Activity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("hihi");
    }
    public void onClick(View view)
    {
        finish();
    }

}
