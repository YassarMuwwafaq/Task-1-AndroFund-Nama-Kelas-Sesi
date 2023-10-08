package com.example.androidfundamental

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class activitylogin : AppCompatActivity(), View.OnClickListener {

    private lateinit var editemail : EditText
    private lateinit var editpassword : EditText

    //menampilkan hail data email dan password yang telah login sebelumnya
    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode ==Activity.RESULT_OK) {
            val data:Intent? = result.data
            val email = data?.getStringExtra("email")
            val password = data?.getStringExtra("password")

            editemail.setText(email)
            editpassword.setText(password)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activitylogin)

        //mendapatkan data email dan password dari register
        editemail = findViewById(R.id.edt_email)
        editpassword = findViewById(R.id.edt_password)
        val bundle = intent.extras
        if(bundle != null){
            editemail.setText(bundle.getString("email"))
            editpassword.setText(bundle.getString("password"))
        }

        val buttonlogin : Button = findViewById(R.id.buttonlogin)
        buttonlogin.setOnClickListener(this)

        val linktoregister : TextView = findViewById(R.id.labellinnklogin)
        linktoregister.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.buttonlogin -> {
                val intent = Intent(this@activitylogin, MainActivity::class.java)
                //mengirimkan data ke halaman utama
                intent.putExtra("User", User( editemail.text.toString(), editpassword.text.toString()))
                resultLauncher.launch(intent)
            //startActivity(intent)
            }

            R.id.labellinnklogin -> {
                val intent = Intent(this@activitylogin, activityregister::class.java)
                startActivity(intent)
            }
        }
    }
}

