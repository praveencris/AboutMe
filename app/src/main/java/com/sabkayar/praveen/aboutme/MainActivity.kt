package com.sabkayar.praveen.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener() {
            addNickname(it)
        }
    }

    private fun hideKeyBoard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val textViewNickname = findViewById<TextView>(R.id.nickname_text)
        if(editText.length()>0){
            textViewNickname.text = editText.text
            textViewNickname.visibility = View.VISIBLE
            editText.visibility = View.GONE
            view.visibility = View.GONE
            hideKeyBoard(view)
        }else{
            Toast.makeText(this,"Enter your nickname!",Toast.LENGTH_SHORT).show()
        }

    }
}