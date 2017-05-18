package com.chat.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ClientPage extends AppCompatActivity {
        private static final String TAG = "ClientPage";
        FirebaseDatabase database;
        DatabaseReference myRef;
        //========Message setup=============
        TextView tvMessage;
        EditText etNewMessage;
        //========Button Setup==============
        Button btUpdate;
        Button btButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.client_page);
            //========Intent initializing======================
            Intent intent = new Intent(this, InterpreterPage.class);
            //========Getting Message ID======================
            tvMessage = (TextView) findViewById(R.id.tv_message);
            etNewMessage = (EditText) findViewById(R.id.et_newData);
            //========Getting Button ID======================
            btUpdate = (Button) findViewById(R.id.bt_update);
            btButton = (Button) findViewById(R.id.bt_button);
            //========Getting the Client reference===========
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference("Client");
            //=======Drop down box setting============================================
            final Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
            String[] items = new String[]{"Select the language","Korean", "Chinese", "Japanese", "Spanish", "Arabian"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
            dropdown.setAdapter(adapter);
            final String[] str2 = {new String()};
            dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3)
                {
                    str2[0] =dropdown.getSelectedItem().toString();
                    Toast.makeText(getApplicationContext(), str2[0], Toast.LENGTH_SHORT).show();
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub
                }
            });
            //=======Button Click Event====================================================
            btUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //===========Get the message from the input and push to the database=======
                    String newMessage = etNewMessage.getText().toString();
                    myRef.push().setValue("Translate To "+ str2[0] +" : " +newMessage);
                    //=======Setting the toast message==============================
                    Toast.makeText(ClientPage.this, "Message Sent", Toast.LENGTH_SHORT).show();
                }
            });
        }
        //===========Button Click Event for opening the mailbox============================
        public void onClick(View view) {
            Intent intent  = new Intent(this, ViewDatabase2.class);
            startActivity(intent);
        }
}
