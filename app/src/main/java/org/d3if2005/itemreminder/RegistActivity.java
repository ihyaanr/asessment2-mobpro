package org.d3if2005.itemreminder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RegistActivity extends AppCompatActivity {

    private Button toLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toLoginBtn = findViewById(R.id.btn_toRegist);

        toLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toLogin();
            }
        });

    }

    public void toLogin(){
        Intent intent = new Intent(org.d3if2005.itemreminder.RegistActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
