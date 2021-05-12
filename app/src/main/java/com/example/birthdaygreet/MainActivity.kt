package com.example.birthdaygreet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//    fun createBirthdayCard(view: View) {
//        val name = nameInput.editableText.toString()
//        Toast.makeText(this, "Button was Clicked by $name", Toast.LENGTH_SHORT).show()
//    }

    fun createBirthdayCard(view: View) {
        val intent = Intent(this, BirthdayGreetingActivity::class.java)
        val name = nameInput.editableText.toString()
        intent.putExtra(BirthdayGreetingActivity.NAME_EXTRA, name)
        startActivity(intent)
    }

}