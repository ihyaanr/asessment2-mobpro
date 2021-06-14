package org.d3if2005.itemreminder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var toRegistBtn = findViewById<Button>(R.id.btn_toRegist)
        var LoginBtn = findViewById<Button>(R.id.btn_login)

        toRegistBtn.setOnClickListener {
            var intent = Intent(this@MainActivity, RegistActivity::class.java)
            startActivity(intent)
        }

        LoginBtn.setOnClickListener {
            var intent = Intent(this@MainActivity, RemindActivity::class.java)
            startActivity(intent)
        }

    }
}