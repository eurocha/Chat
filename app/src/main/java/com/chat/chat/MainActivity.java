package com.chat.chat;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //===== Button Intializing==========//
    Button btClient;
    Button btInterpreter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //=====intent initializing===================//
        final Intent intent = new Intent(this, ClientPage.class);
        final Intent intent2 = new Intent(this, InterpreterPage.class);
        //====Get the Button Id from xml==========================//
        btClient = (Button) findViewById(R.id.button1);
        btInterpreter = (Button) findViewById(R.id.button2);
        //==========Button1 setting==============================//
        btClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        //=========Button2 setting==================================//
        btInterpreter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });
    }
}

