package org.d3if2005.itemreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListItemActivity extends AppCompatActivity {

    private Button btnaddlist, btn_finishreminder, btn_backtoTask, btn_backtoMain;
    private ListView listitemreminder;

    private ArrayAdapter<String> adapter;
    private ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        btnaddlist = findViewById(R.id.btn_addlist);
        btn_backtoTask = findViewById(R.id.btn_backtoTask);
        btn_backtoMain = findViewById(R.id.btn_backToMain);
        btn_finishreminder = findViewById(R.id.btn_finishreminder);
        listitemreminder = findViewById(R.id.list_itemreminder);

        btnaddlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });

        list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, list);
        listitemreminder.setAdapter(adapter);
        setUpListViewListener();


        btn_finishreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListItemActivity.this, RemindActivity.class);
                startActivity(intent);
            }
        });

        btn_backtoTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListItemActivity.this, NewTaskAct.class);
                startActivity(intent);
            }
        });

        btn_backtoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListItemActivity.this, RemindActivity.class);
                startActivity(intent);
            }
        });

    }


    private void setUpListViewListener() {
        listitemreminder.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long id) {
                Context context = getApplicationContext();
                Toast.makeText(context,"Item Removed", Toast.LENGTH_LONG).show();

                list.remove(i);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void addItem(View view) {
        EditText input = findViewById(R.id.etaddlist);
        String itemText = input.getText().toString();

        if (!(itemText.equals(""))){
            adapter.add(itemText);
            input.setText("");
        }else {
            Toast.makeText(getApplicationContext(), "Please Enter text...", Toast.LENGTH_SHORT).show();
        }
    }
}