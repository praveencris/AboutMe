package com.sabkayar.praveen.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sabkayar.praveen.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    // Instance of MyName data class.
    private var myName = MyName("Praveen Kumar")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.myName = myName
        /* findViewById<Button>(R.id.done_button).setOnClickListener() {
             addNickname(it)
         }*/

        mBinding.doneButton.setOnClickListener() {
            addNickname(it)
        }
    }

    private fun hideKeyBoard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun addNickname(view: View) {
        mBinding.apply {
            if (this.nicknameEdit.length() > 0) {//this is optional
                myName?.nickname = nicknameEdit.text.toString()//set value for nickname member of data class
                //muName? -> telling compiler myName can be null
                //muName!! --> telling compiler myName will never be null,if we are sure about it
                invalidateAll()//Invalidates all binding expressions and requests a new rebind to refresh UI.
                nicknameText.visibility = View.VISIBLE
                nicknameEdit.visibility = View.GONE
                view.visibility = View.GONE
                hideKeyBoard(view)
            } else {
                Toast.makeText(this.root.context, "Enter your nickname!", Toast.LENGTH_SHORT).show()
            }
        }
        // Note apply() can be replaced with also() replaces this with 'it'

    }
}