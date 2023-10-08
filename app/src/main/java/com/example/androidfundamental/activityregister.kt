package com.example.androidfundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class activityregister : AppCompatActivity(), View.OnClickListener {

    private lateinit var editusername : EditText
    private lateinit var editemail : EditText
    private lateinit var editpassword : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activityregister)

        editusername = findViewById(R.id.edt_username)
        editemail = findViewById(R.id.edt_email)
        editpassword = findViewById(R.id.edt_password)

        val bundle = intent.extras
        if(bundle != null){
            editusername.setText(bundle.getString("username"))
            editemail.setText(bundle.getString("email"))
            editpassword.setText(bundle.getString("password"))
        }

        val buttonregister : Button = findViewById(R.id.buttonregister)
        buttonregister.setOnClickListener(this)

        val linktologin : TextView = findViewById(R.id.labellinnkregister)
        linktologin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.buttonregister -> {
                val bundle = Bundle()
                bundle.putString("username", editusername.text.toString())
                bundle.putString("email", editemail.text.toString())
                bundle.putString("password", editpassword.text.toString())

                val intent = Intent(this@activityregister, activitylogin::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            R.id.labellinnkregister -> {
                val intent = Intent(this@activityregister, activitylogin::class.java)
                startActivity(intent)
            }
        }
    }
}