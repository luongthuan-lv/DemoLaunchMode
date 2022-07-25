package com.luongthuan.demolaunchmode

import android.app.ActivityManager
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

import android.app.Activity
import android.app.ActivityManager.RunningTaskInfo

import android.os.Bundle
import androidx.annotation.Nullable
import java.lang.StringBuilder


/**
 * Created by Luong Thuan on 25/07/2022.
 */
open class BaseActivity : AppCompatActivity() {
    var activityManager: ActivityManager? = null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (activityManager == null) {
            activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        }
    }

    protected fun startActivity(activity: Activity?, targetActivityClass: Class<*>?) {
        val intent = Intent(activity, targetActivityClass)
        startActivity(intent)
    }

    protected open fun getNumberOfTasks(): Int {
        return activityManager!!.appTasks.size
    }

    protected open fun getAppTaskState(): String? {
        val stringBuilder = StringBuilder()
        val totalNumberOfTasks =
            activityManager!!.getRunningTasks(10).size //Returns total number of tasks - stacks
        stringBuilder.append("\nTotal Number of Tasks: $totalNumberOfTasks\n\n")
        val taskInfo =
            activityManager!!.getRunningTasks(10) //returns List of RunningTaskInfo - corresponding to tasks - stacks
        for (info in taskInfo) {
            stringBuilder.append(
                """
                Task Id: ${info.id}, Number of Activities : ${info.numActivities}
                
                """.trimIndent()
            ) //Number of Activities in task - stack

            // Display the root Activity of task-stack
            stringBuilder.append(
                """
                TopActivity: ${
                    info.topActivity!!.className.replace(
                        "lauchmodesdemo.youtube.codetutor.com.activitylauchmodesdemo.",
                        ""
                    )
                }
                
                """.trimIndent()
            )

            // Display the top Activity of task-stack
            stringBuilder.append(
                """
                BaseActivity:${
                    info.baseActivity!!.className.replace(
                        "lauchmodesdemo.youtube.codetutor.com.activitylauchmodesdemo.",
                        ""
                    )
                }
                
                """.trimIndent()
            )
            stringBuilder.append("\n\n")
        }
        return stringBuilder.toString()
    }
}