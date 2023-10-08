package com.example.androidfundamental

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var textview : TextView
    private lateinit var email: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textview = findViewById(R.id.textView)

        val email = intent.getParcelableExtra<User>("User")?.email
        textview.text = "Selamat datang $email"

        val buttonlogout : Button = findViewById(R.id.buttonlogout)
        buttonlogout.setOnClickListener(this)

        val buttonfragment1 : Button = findViewById(R.id.buttonfragment1)
        buttonfragment1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.buttonlogout -> {
                // Mengirim data kembali ke halaman login
                val intent = Intent(this@MainActivity, activitylogin::class.java)
                intent.putExtra("email", email)
                intent.putExtra("password", password)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
            R.id.buttonfragment1 -> {
//                val intent = Intent(this@MainActivity, FragmentActivity::class.java)
//                startActivity(intent)
                val fragment = fragment1()
                fragment.show(supportFragmentManager, "Fragment1Dialog")
            }
        }
    }

}