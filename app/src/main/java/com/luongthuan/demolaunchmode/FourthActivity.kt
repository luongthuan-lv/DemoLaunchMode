package com.luongthuan.demolaunchmode

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fourth.*


class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        onClick()
        Log.i("TESTING", "CREATED: " + this.javaClass.simpleName + " -- TASK ID: " + taskId);
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TESTING", "DESTROYED: " + this.javaClass.simpleName + " -- TASK ID: " + taskId)

    }

    private fun startActivity(activity: Activity?, targetActivityClass: Class<*>?) {
        val intent = Intent(activity, targetActivityClass)
        startActivity(intent)
    }

    private fun onClick() {
        btnMain.setOnClickListener {
            startActivity(this, MainActivity::class.java)
        }

        btnFirst.setOnClickListener {
            startActivity(this, FirstActivity::class.java)
        }

        btnSecond.setOnClickListener {
            startActivity(this, SecondActivity::class.java)
        }

        btnThird.setOnClickListener {
            startActivity(this, ThirdActivity::class.java)
        }

        btnFourth.setOnClickListener {
            startActivity(this, FourthActivity::class.java)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.i("TESTING", "NEW INTENT: " + this.javaClass.simpleName + " -- TASK ID: " + taskId)

    }
}