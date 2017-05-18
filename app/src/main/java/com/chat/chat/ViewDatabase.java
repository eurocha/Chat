package com.chat.chat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;


public class ViewDatabase extends AppCompatActivity {
    private FirebaseDatabase database;
    DatabaseReference myRef;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_data_layout);
        //=======Getting the client reference===================
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Client");
        //========Listview setup================================
        listView = (ListView)findViewById(R.id.listView);

        //====== Reading from the database==================================
        myRef.addValueEventListener(new ValueEventListener() {
            public static final String TAG ="ViewDatabase";
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
    //==========Showdata function============================================
    public void showData(DataSnapshot dataSnapshot)
    {
        ArrayList<String> array = new ArrayList<>();
        // ====adding strings to array===================
        for(DataSnapshot ds : dataSnapshot.getChildren())
        {
            array.add(  (String) ds.getValue());
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, array);
        listView.setAdapter(adapter);


    }

}
