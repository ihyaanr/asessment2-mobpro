package org.d3if2005.itemreminder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class NewTaskAct extends AppCompatActivity {

    EditText titlereminder, locationreminder;
    EditText datereminder;
    Button btnSaveReminder, btnCancelReminder, btn_backToMain;
    DatabaseReference reference;
    Integer reminderNum = new Random().nextInt();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        titlereminder = findViewById(R.id.titlereminder);
        locationreminder = findViewById(R.id.locationreminder);
        datereminder = findViewById(R.id.datereminder);

        btnSaveReminder = findViewById(R.id.btnSaveReminder);
        btnCancelReminder = findViewById(R.id.btnCancelReminder);
        btn_backToMain = findViewById(R.id.btn_backToMain);

//        datereminder.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//                String date = dayOfMonth + "/" + month + "/" + year;
//            }
//        });

        btnSaveReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // insert data to database
                reference = FirebaseDatabase.getInstance().getReference().child("ReminderApp").
                        child("Reminder"+reminderNum);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("titlereminder").setValue(titlereminder.getText().toString());
                        dataSnapshot.getRef().child("locationreminder").setValue(locationreminder.getText().toString());
                        dataSnapshot.getRef().child("datereminder").setValue(datereminder.getText().toString());

                        Intent intent = new Intent(NewTaskAct.this,ListItemActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        btnCancelReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain();
            }
        });

        btn_backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain();
            }
        });


    }

    public void backToMain(){
        Intent intent = new Intent(org.d3if2005.itemreminder.NewTaskAct.this, RemindActivity.class);
        startActivity(intent);
    }
}