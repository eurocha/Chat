package com.chat.chat;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    FirebaseDatabase database;
    DatabaseReference myRef;
    TextView tvMessage;
    EditText etNewMessage;
    Button btUpdate;
    Button btButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, SubActivity.class);
        tvMessage = (TextView) findViewById(R.id.tv_message);
        etNewMessage = (EditText) findViewById(R.id.et_newData);
        btUpdate = (Button) findViewById(R.id.bt_update);
        btButton = (Button) findViewById(R.id.bt_button);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("hihi");

        //Button event
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newMessage = etNewMessage.getText().toString();
                //myRef.setValue(newMessage);
                myRef.push().setValue(newMessage);

            }
        });
    }




        public void onClick(View view) {

            Intent intent  = new Intent(this, SubActivity.class);
            startActivity(intent);

        }


    }

