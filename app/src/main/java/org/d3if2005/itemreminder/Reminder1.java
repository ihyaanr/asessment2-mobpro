package org.d3if2005.itemreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Reminder1 extends AppCompatActivity {

    EditText titlereminder, locationreminder, datereminder;
    Button btn_reminderback, btn_finishreminder, btn_backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder1);

        btn_finishreminder = findViewById(R.id.btn_finishreminder);
        btn_reminderback = findViewById(R.id.btn_reminderback);
        btn_backToMain = findViewById(R.id.btn_backToMain);

        btn_backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reminder1.this, RemindActivity.class);
                startActivity(intent);
            }
        });
        btn_reminderback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reminder1.this, RemindActivity.class);
                startActivity(intent);
            }
        });

        btn_finishreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reminder1.this, RemindActivity.class);
                startActivity(intent);
            }
        });

//        titlereminder.setText(getIntent().getExtras().getString("titlereminder"));
//        locationreminder.setText(getIntent().getExtras().getString("locationreminder"));
//        datereminder.setText(getIntent().getExtras().getString("datereminder"));

    }
}