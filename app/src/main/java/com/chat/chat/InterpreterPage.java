package com.chat.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InterpreterPage extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    //========Message setup=============
    TextView tvMessage;
    EditText etNewMessage;
    //=======Button setup================
    Button btUpdate;
    Button btButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        //=========Intent intializing=====================
        Intent intent = new Intent(this, ViewDatabase.class);
        //========Getting Message ID======================
        tvMessage = (TextView) findViewById(R.id.tv_message);
        etNewMessage = (EditText) findViewById(R.id.et_newData);
        //========Getting Button ID=======================
        btUpdate = (Button) findViewById(R.id.bt_update);
        btButton = (Button) findViewById(R.id.bt_button);
        //========Getting the Interpreter reference===========
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Interpreter");

        //=======Button Click Event===============================
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //===========Get the message from the input and push to the database=======
                String newMessage = etNewMessage.getText().toString();
                myRef.push().setValue(newMessage);
                //==========Setting the toast message==================================
                Toast.makeText(InterpreterPage.this, "Message Sent", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //========Button Click Event for opening the Mailbox==========================
    public void onClick(View view) {
        Intent intent  = new Intent(this, ViewDatabase.class);
        startActivity(intent);
    }
}

