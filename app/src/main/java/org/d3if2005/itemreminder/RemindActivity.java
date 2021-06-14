package org.d3if2005.itemreminder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RemindActivity extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView ourreminder;
    ArrayList<MyReminder> list;
    RemindAdapter remindAdapter;
    Button btnAddNew, btn_logout;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddNew = findViewById(R.id.btnAddNew);
        btn_logout = findViewById(R.id.btn_logout);

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(RemindActivity.this, NewTaskAct.class);
                startActivity(a);
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemindActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // working with data
        ourreminder = findViewById(R.id.ourreminder);
        ourreminder.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<MyReminder>();

        // get data from firebase
        reference = FirebaseDatabase.getInstance().getReference().child("ReminderApp");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //to retrive data and replace layout
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    MyReminder p = dataSnapshot.getValue(MyReminder.class);
                    list.add(p);
                }
                remindAdapter = new RemindAdapter(RemindActivity.this, list);
                ourreminder.setAdapter(remindAdapter);
                remindAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //to show the eror
                Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
