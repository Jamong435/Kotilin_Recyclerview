package com.kim9212.ex91kotlinrecyclerviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_intro.*
import kotlinx.android.synthetic.main.activity_main.*

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        clickbtn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                var intent= Intent(this@IntroActivity,MainActivity::class.java)
                startActivity(intent)
            }
        })

    }

    fun clickExit(view: View) {
        finish()
    }

}