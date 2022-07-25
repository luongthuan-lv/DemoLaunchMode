package com.luongthuan.demolaunchmode

import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_MULTIPLE_TASK
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onClick()
        Log.i("TESTING", "CREATED: " + this.javaClass.simpleName + " -- TASK ID: " + taskId)

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TESTING", "DESTROYED: " + this.javaClass.simpleName + " -- TASK ID: " + taskId)

    }

    private fun startActivity(
        activity: Activity?,
        targetActivityClass: Class<*>?,
        isAddFlag: Boolean = false
    ) {
        val intent = Intent(activity, targetActivityClass)
        if (isAddFlag) {
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_MULTIPLE_TASK
        }
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
            startActivity(this, SecondActivity::class.java, true)
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